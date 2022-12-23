import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class JdbcJtable01 extends JPanel{

   private static final long serialVersionUID = 1L;
   private JButton jBtnDelRow = null;
   private JButton jBtnSaveRow = null;
   private JTable table;
   private JScrollPane scrollPane;

   private String driver = "oracle.jdbc.driver.OracleDriver";
   private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
   private String id = "hyCafe";
   private String pw = "1234";

   private String colNames[] = {"상품코드", "메뉴 이름", "금액"};
   private DefaultTableModel model = new DefaultTableModel(colNames, 0);

   private Connection conn = null;
   private PreparedStatement pstmt = null;
   private ResultSet rs = null;
   JTextField serch;
   public JdbcJtable01() {
      setLayout(null);
      table = new JTable(model);
      table.addMouseListener(new JTableMouseListener());
      scrollPane = new JScrollPane(table);
      scrollPane.setSize(500, 200);
      add(scrollPane);
      select();
      initialize();


   }

   private class JTableMouseListener implements MouseListener{

      @Override
      public void mouseClicked(java.awt.event.MouseEvent e) {
         JTable jtable = (JTable) e.getSource();
         int row = jtable.getSelectedRow();
         int col = jtable.getSelectedColumn();

         System.out.println(model.getValueAt(row, col));
      }

      @Override
      public void mousePressed(MouseEvent e) {
         // TODO Auto-generated method stub

      }

      @Override
      public void mouseReleased(MouseEvent e) {
         // TODO Auto-generated method stub

      }

      @Override
      public void mouseEntered(MouseEvent e) {
         // TODO Auto-generated method stub

      }

      @Override
      public void mouseExited(MouseEvent e) {
         // TODO Auto-generated method stub

      }

   }

   private void select() {
      String query = "SELECT menu_number, menu_name, price FROM menu";

      try {
         Class.forName(driver);
         conn = DriverManager.getConnection(url, id, pw);
         pstmt = conn.prepareStatement(query);
         rs = pstmt.executeQuery();

         while(rs.next()) {
            model.addRow(new Object[] {
                  rs.getInt("menu_number"),
                  rs.getString("menu_name"),
                  rs.getInt("price")
            });
         }
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         try {
            //            rs.close();
            pstmt.close();
            conn.close();
         } catch (Exception e) {

         }
      }
   }




   private void initialize() {
      serch = new JTextField();

      serch.setBounds(130, 250, 70, 20);

      JTextField num = new JTextField();

      num.setBounds(130, 300, 70, 20);

      JTextField name = new JTextField();

      name.setBounds(210, 300, 70, 20);

      JTextField price = new JTextField();

      price.setBounds(290, 300, 70, 20);

//      serch.addActionListener(new ActionListener() {
//
//         @Override
//         public void actionPerformed(ActionEvent e) {
//
//
//            DefaultTableModel model2 = (DefaultTableModel) table.getModel();
//            String query = "SELECT menu_number, menu_name, price FROM menu WHERE menu_name LIKE ?";
//
//            try {
//               Class.forName(driver);
//               conn = DriverManager.getConnection(url, id, pw);
//               pstmt = conn.prepareStatement(query);
//               pstmt.executeUpdate();
//
//               pstmt.setString(1, "menu_name");
//
//
//            } catch (Exception eeee) {
//               eeee.printStackTrace();
//            } finally {
//               try {
//                  pstmt.close();
//                  conn.close();
//               } catch (Exception e2) {
//                  e2.printStackTrace();
//               }
//               model2 = new DefaultTableModel(colNames, 0);
//               select();
//            }
//         }
//      });
//
//      add(serch);
      add(num);
      add(name);
      add(price);

      jBtnSaveRow = new JButton();
      jBtnSaveRow.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {


            System.out.println(e.getActionCommand());
            DefaultTableModel model2 = (DefaultTableModel) table.getModel();
            int row = table.getSelectedRow();
            if (row < 0) return;
            String query = "INSERT INTO menu(menu_number, menu_name, price)"
                  + "VALUES (?,?,?)";

            try {
               Class.forName(driver);
               conn = DriverManager.getConnection(url, id, pw);
               pstmt = conn.prepareStatement(query);

               pstmt.setString(1, num.getText());
               pstmt.setString(2, name.getText());
               pstmt.setString(3, price.getText());

               int cnt = pstmt.executeUpdate();
            } catch (Exception eeee) {
               eeee.printStackTrace();
            } finally {
               try {
                  pstmt.close();
                  conn.close();
               } catch (Exception e2) {
                  e2.printStackTrace();
               }
               model2.setRowCount(0);
               select();
            }
         }
      });
      jBtnSaveRow.setBounds(182, 222, 120, 25);
      jBtnSaveRow.setText("저장");
      add(jBtnSaveRow);


      jBtnDelRow = new JButton();
      jBtnDelRow.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(java.awt.event.ActionEvent e) {
            System.out.println(e.getActionCommand());
            DefaultTableModel model2 = (DefaultTableModel) table.getModel();
            int row = table.getSelectedRow();
            if(row < 0) return;
            String query = "DELETE FROM menu WHERE menu_name = ?";

            try {
               Class.forName(driver);
               conn = DriverManager.getConnection(url, id, pw);
               pstmt = conn.prepareStatement(query);

               pstmt.setString(1, (String) model2.getValueAt(row, 1));
               int cnt = pstmt.executeUpdate();
            } catch(Exception eeee) {
               eeee.printStackTrace();
            } finally {
               try {
                  pstmt.close();
                  conn.close();
               } catch (Exception e2) {

               }
               model2.removeRow(row);
            }
         }
      });
      jBtnDelRow.setBounds(new Rectangle(320, 222, 120, 25));
      jBtnDelRow.setText("삭제");
      add(jBtnDelRow);
   }


   public static void main(String[] args) {

      JdbcJtable01 panel = new JdbcJtable01();
      JFrame win = new JFrame();

      win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      win.add(panel);
      win.setSize(540, 400);
      win.setVisible(true);
   }
}