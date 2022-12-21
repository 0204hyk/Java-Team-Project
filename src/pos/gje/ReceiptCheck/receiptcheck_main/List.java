package pos.gje.ReceiptCheck.receiptcheck_main;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import database.OjdbcConnection;
import pos.gje.ReceiptCheck.receiptcheck_main.component.OutputButton;
import pos.gje.ReceiptCheck.receiptcheck_main.component.PrintScroll;
import pos.gje.ReceiptCheck.receiptcheck_main.component.RefundButton;
import pos.gje.ReceiptCheck.refund.RefundFrame;

// 리스트
public class List {
	
	static private String[] top = {" ", "영수증번호"};
	public static DefaultTableModel contents = new DefaultTableModel(top, 0){ // 테이블 안에 들어가는 데이터 값을 채워넣음
		public boolean isCellEditable(int row, int column){
			return false;
		}
	};  //셀 수정 못하게 하는 부분
	public static JTable table = new JTable(contents); 
	public static JScrollPane scroll;
	public static RefundFrame refundFrame;

	static ArrayList<String> number = new ArrayList<>();
	static ArrayList<String> cardNum = new ArrayList<>();
	static ArrayList<String> date = new ArrayList<>();

	public List() {	}
	
	public List(OutputButton out, RefundButton refund) {
		
		String query = "SELECT * FROM sales_management"; 
		
		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
			ResultSet rs = pstmt.executeQuery();
			int num = 1;
			while (rs.next()) {
				// 영수증에 관한 값을 List에 저장 (현재 영수증 테이블에 값이 없엉서 멤버십 테이블로 대신함)
				number.add(rs.getString("sales_number"));
				cardNum.add(rs.getString("card_number"));
				date.add(rs.getString("saledate"));
				
				contents.addRow(new Object[] {
						num++, // 
						rs.getString("sales_number") 
				});
			}
			
		} catch (SQLException e) {
			System.out.println(" 오류");
			e.printStackTrace();
		}
		
		
		// 만든 테이블 스크롤에 붙이기
		scroll = new JScrollPane(table);
		scroll.setBounds(75, 95, 500, 550);
		
		// 크기 조정 
		table.getColumn(" ").setPreferredWidth(20);
		table.getColumn("영수증번호").setPreferredWidth(450);

		// 수정 안되게 만들기
		table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

        // 높이
        table.setRowHeight(25);
        
        // 글꼴 설정 
		table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 23)); 
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		// 하나만 선택되게 설정 
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 선택한 Row의 순서를 int 타입으로 변경 
				//(table 은 1부터 시작하기 때문에 - 1 을 해줘야 List에 담긴 값을 정확히 불러올 수 있다.
				int num = (int)(table.getValueAt(table.getSelectedRow(), 0)) - 1;
				String sales_number = (table.getValueAt(table.getSelectedRow(), 1)).toString();
				String card_number = cardNum.get(num);
				String sales_date = date.get(num);
				
				
				
				// 환불창에 뜨게 만들기
				refundFrame = new RefundFrame("", sales_number, "", sales_number);
				
				// 영수증을 프린틑하는 메소드에 값을 넣는다 
				//changeTextA(sales_number, "");
				out.setEnabled(true);
				refund.setEnabled(true);
				
				// 영수증 번호 전달
				receiptInfo(sales_number, num);

			}
		});
	}
	
	// 영수증번호 (pk/fk) 를 WHERE에 써서 정보를 담아야 한다. 
	public void receiptInfo (String sales_number, int num) {
		String query = "select menu_name, menu_qty, m.price "
				+ "from sales s, menu m "
				+ "where sales_number = '" + sales_number + "'"
				+ "AND s.menu_number = m.menu_number"; 
		
		StringBuilder sb1 = new StringBuilder();
		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
			//pstmt.setString(0, sales_number); // 영수증 번호에 관한 정보들 

			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				// 영수증에 관한 값을 List에 저장 (현재 영수증 테이블에 값이 없엉서 멤버십 테이블로 대신함)
				// 각각의 메뉴들은 모두 저장 try (ResultSet rs = pstmt.executeQuery();)
				
				
				/*
				 	for (int i = 1; i <= metadata.getColumnCount(); ++i) { // metadata.getColumnCount(); = 개수
							
						1. 메뉴 이름 
						2. 옵션들
						3. 개수
						4. 가격 
					}
				 
				*/
				
				ResultSetMetaData metadata = rs.getMetaData();
				while (rs.next()) {
					sb1.append(rs.getString("menu_name")
							+ "\t" 
							+ rs.getInt("menu_qty")
							+ "\t" 
							+ rs.getInt("price")
							+ "\n");
				}
			}
		} catch (SQLException e) {
			System.out.println(" 오류");
			e.printStackTrace();
		}
		
		// 영수증 번호에 해당하는 정보들 환불창에 넣기 
		refundFrame = new RefundFrame(sales_number, sales_number, sales_number, sales_number);
		
		// 영수증 출력하는 곳에 값 넣기 
		changeTextA("", sales_number, sb1.toString(), sales_number, sales_number);
		
	}

	
	public void changeTextA(String date, String sales_number, String menu, String price, String point) {
		JTextArea a = PrintScroll.p;
		
		a.setText("[영수증]\n"
				+ "\n"
				+ "[매장명] 구리점\n"
				+ "[사업자] 123-12-12345\n"
				+ "[주소] 경기도 구리시 건원대로 44 태영빌딩\n"
				+ "4층 409호\n"
				+ "[대표자] 김XX		[TEL] 031-555-4449\n"
				+ "[매출일] " + date + "\n"
				+ "[영수증] " + sales_number + "\n"
				+ "=====================================\n"
				+ " 상 품 명\t\t수 량\t단 가\n"
				+ "--------------------------------------------------------------------\n"
				+ menu
				+ "--------------------------------------------------------------------\n"
				+ "\t\t합 계 금 액   "  + price + "\n"
				+ "--------------------------------------------------------------------\n"
				+ "\t\t받 을 	금 액   "  + price + "\n"
				+ "\t\t받 은 	금 액   "  + price + "\n"
				+ "\t\t받 은 	카 드   " + sales_number + "\n"
				+ "\t\t포인트 결 제   " + sales_number + "\n"
				+ "\t\t받 은 카 드   " + sales_number + "\n"
				+ "====================================="
				);
	}
	
	public static void main(String[] args) {
	
	}
}
