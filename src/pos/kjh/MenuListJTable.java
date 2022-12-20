package pos.kjh;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import database.OjdbcConnection;
import pos.gje.delet.DeleteFrame;

public class MenuListJTable extends JTable{

	private static String top[] = {"상품코드", "메뉴 이름", "금액"};;
	public static JTable table;
	public static String menuName;
	public static int quantity;
	public static JPanel panel;
	
	ProductManagementJFrame p;

	// JTable 내용 값
	public static DefaultTableModel contents = new DefaultTableModel(top, 0)
	{
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int i, int c){
	          return false;
	         }
	    };	

	// 행 선택 여부 반환
	public boolean getSelected() {
		if (table.getSelectedRow() == -1) {
		 return false;	
		}
		return true;
	}
	    
	// 선택한 행의 메뉴 넘버를 받아오기 위한 메서드
	public int getMenuNumber() {
		int row = table.getSelectedRow();
		
		return Integer.parseInt(table.getValueAt(row, 0).toString());
	}
	
	
	// JTable 선택값 삭제 메서드
	public void delete() throws IOException, SQLException {

		int index = table.getSelectedRow();
		if(index < 0){
			// 아무것도 선택 안하면 뜨는 창
			new NotSelectedFrame();
		}else{
			// 삭제 메뉴 확인 창
			table.setEnabled(false);
			new DeleteFrame();

		}
	}

	// 선택된 메뉴 DB에서 삭제하는 메서드
	public static void deleteDB(String keyword) {
		String sql = "DELETE FROM menu WHERE menu_name = ?";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);

				){

			pstmt.setString(1, keyword);
			ResultSet rs = pstmt.executeQuery();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	



	// JTable로 DB값 불러오는 메서드
	public MenuListJTable(String sqlCondition) throws SQLException {

		String sql = sqlCondition;

		try (
				Connection conn = OjdbcConnection.getConnection();
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

			table.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			
			// 헤더 높이 조절
			JTableHeader th = table.getTableHeader();
			th.setPreferredSize(new Dimension(50, 50));
			th.setBackground(new Color(217, 217, 217));
			th.setFont(new Font("맑은 고딕", Font.BOLD, 25));
			
			table.setRowHeight(35);
			table.getColumnModel().getColumn(0).setPreferredWidth(10);
			table.getColumnModel().getColumn(1).setPreferredWidth(600);
			table.getColumnModel().getColumn(2).setPreferredWidth(90);
			
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			table.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {					
					menuName = (table.getValueAt(table.getSelectedRow(), 1)).toString();
				}

			});

			scroll.setBounds(0, 0, 1100, 400);

			// 테이블 수정 불가하게 설정
			table.getTableHeader().setReorderingAllowed(false);
			table.getTableHeader().setResizingAllowed(false);
			
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



			table.setLayout(null);
			setBounds(48, 190, 1100, 400);
			add(scroll);
			setLayout(null);
			setVisible(true);
		}
	}


}
