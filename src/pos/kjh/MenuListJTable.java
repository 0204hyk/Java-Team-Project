package pos.kjh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import database.OjdbcConnection;
import pos.gje.delet.DeleteFrame;
import pos.gje.delet.component.OkBtn;

public class MenuListJTable extends JTable{

	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static String id = "hyCafe";
	private static String pw = "1234";

	private static String top[] = {"상품코드", "메뉴 이름", "금액"};;
	public static JTable table;
	public static String menuName;
	public static int quantity;
	public static JPanel panel;

	// JTable 내용 값
	public static DefaultTableModel contents = new DefaultTableModel(top, 0);


	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// JTable 선택값 삭제 메서드
	public void delete() throws IOException {

		int index = table.getSelectedRow();
		if(index < 0){
			// 아무것도 선택 안하면 뜨는 창
			new NotSelectedFrame();
		}else{
			// 삭제 메뉴 확인 창
			new DeleteFrame();


		}
	}


	// 선택된 메뉴 DB에서 삭제하는 메서드
	public static void deleteDB(String keyword) {
		String sql = "DELETE FROM menu WHERE menu_name = ?";

		try (
				Connection conn = DriverManager.getConnection(url, id, pw);
				PreparedStatement pstmt = conn.prepareStatement(sql);

				){

			pstmt.setString(1, keyword);
			ResultSet rs = pstmt.executeQuery();


			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}


	// JTable로 DB값 불러오는 메서드
	public MenuListJTable(String sqlCondition) throws SQLException {
		String sql = sqlCondition;


		try (
				Connection conn = DriverManager.getConnection(url, id, pw);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){

			while (rs.next()) {

				contents.addRow(new Object[] {
						rs.getInt("menu_number"),
						rs.getString("menu_name"),
						rs.getInt("price")
				});

			}

			table = new JTable(contents);
			JScrollPane scroll = new JScrollPane(table);
			//panel = new JPanel(new BorderLayout());
			
			//panel.add(scroll, "Center");


			table.setFont(getFont().deriveFont(20f));
			table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 23));
			table.setRowHeight(35);
			table.getColumnModel().getColumn(0).setPreferredWidth(10);
			table.getColumnModel().getColumn(1).setPreferredWidth(600);
			table.getColumnModel().getColumn(2).setPreferredWidth(90);
			scroll.setBounds(0, 0, 1100, 400);
			
			// 테이블 수정 불가하게 설정
			table.getTableHeader().setReorderingAllowed(false);
			table.getTableHeader().setResizingAllowed(false);
			
			table.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
						
					
					/*
						int[] selectedrows = table.getSelectedRows();
						menuName = "";
						for (int i = 0; i < selectedrows.length; i++)
						{
							
							//int colcnt = MenuListJTable.table.getSelectedColumnCount();
							//MenuListJTable.quantity = colcnt;
							menuName = table.getValueAt(selectedrows[i], 1).toString() + " ";
						}*/

						//	 menuName.substring(4, menuName.length());
					
					menuName = (table.getValueAt(table.getSelectedRow(), 1)).toString();
						//System.out.println(menuName);
				}
				
			});


			//			TableColumn checkBoxColumn = MenuListJTable.table.getColumnModel().getColumn(0);
			//			checkBoxColumn.setCellRenderer(new TableCell());
			//			checkBoxColumn.setCellEditor(new TableCell());

			rs.close();
			pstmt.close();
			conn.close();

			table.setLayout(null);
			setBounds(48, 190, 1100, 400);
			add(scroll);
			setLayout(null);
			setVisible(true);
		}

	}
}




//	public static int getQuantity() {
//		
//		return quantity;
//	}
//	
//	public static String getMenuName() {
//		
//		return menuName;
//	}



/*
class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{

		private final JPanel componentPanel;
		JCheckBox cb;

		public TableCell() {
			componentPanel = new JPanel(new GridBagLayout());
			componentPanel.setOpaque(false);
			cb = new JCheckBox();
			cb.setOpaque(false);

			componentPanel.add(cb);
			cb.setHorizontalAlignment(JLabel.CENTER);

			cb.addActionListener(e -> {
				int colcnt = MenuListJTable.table.getSelectedColumnCount();
				MenuListJTable.menuName = "" + MenuListJTable.table.getValueAt(MenuListJTable.table.getSelectedRow(), 2);
				MenuListJTable.quantity = colcnt;
			});

		}

		@Override
		public Object getCellEditorValue() {
			return Boolean.valueOf(cb.isSelected());
		}
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {

			return cb;
		}
		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {

			return componentPanel;
		}

	}*/






