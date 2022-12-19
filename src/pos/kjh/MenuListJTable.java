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
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

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
	public DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();


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



			table.setFont(getFont().deriveFont(20f));
			table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 21));
			
			
			table.setRowHeight(35);
			table.getColumnModel().getColumn(0).setPreferredWidth(10);
			table.getColumnModel().getColumn(1).setPreferredWidth(600);
			table.getColumnModel().getColumn(2).setPreferredWidth(90);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			

			scroll.setBounds(0, 0, 1100, 400);

			// 테이블 수정 불가하게 설정
			table.getTableHeader().setReorderingAllowed(false);
			table.getTableHeader().setResizingAllowed(false);
			
			table.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					menuName = (table.getValueAt(table.getSelectedRow(), 1)).toString();
				}

			});

			
			// 테이블 내용 가운데 정렬하기
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); 
			dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로

			TableColumnModel tcm = table.getColumnModel() ; // 정렬할 테이블의 컬럼모델을 가져옴

			//전체 열에 지정
			for(int i = 0 ; i < tcm.getColumnCount() ; i++){
				tcm.getColumn(i).setCellRenderer(dtcr);
			}

			//		      //특정 열에 지정
			//		      tcm.getColumn(0).setCellRenderer(dtcr);  
			//		      tcm.getColumn(4).setCellRenderer(dtcr);

			


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
