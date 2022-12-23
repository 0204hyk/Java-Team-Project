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
import java.util.Arrays;
import java.util.HashSet;

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
	
	static ArrayList<String> date = new ArrayList<>(); // 판매 날짜 및 시간
	static ArrayList<String> cardNum = new ArrayList<>(); // 카드 번호 
	static ArrayList<Integer> point_payment = new ArrayList<>(); // 포인트 결제  
	static ArrayList<String> mem_number = new ArrayList<>(); //멤버십 정보
	static ArrayList<String> options = new ArrayList<>(); // 옵션 번호 
	
	
	
	
	String sales_date, sales_number, menu_name;
	int menu_qty, total_price, menu_price, point;
	
	
	public List() {	}
	
	
	public List(OutputButton out, RefundButton refund) {
		
		String query = "SELECT * FROM sales_management ORDER BY sales_number DESC"; 
		
		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
			ResultSet rs = pstmt.executeQuery();
			int num = 1; // 목록에 있는 번호 
			
			while (rs.next()) {
				// 영수증에 관한 값을 List에 저장 (현재 영수증 테이블에 값이 없엉서 멤버십 테이블로 대신함)
				point_payment.add(rs.getInt("used_point")); // 포인트 결제
				cardNum.add(rs.getString("card_number")); // 카드 번호
				date.add(rs.getString("saledate")); // 결제 날짜 
				mem_number.add(rs.getString("member_phonenumber"));
				
				// Table 목록 생성
				contents.addRow(new Object[] {
						num++, 
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
			// 선택했을 때 
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				total_price = 0;
				options.clear();
				
				int num = (int)(table.getValueAt(table.getSelectedRow(), 0)) - 1;
				
				String sales_number = (table.getValueAt(table.getSelectedRow(), 1)).toString();
				String card_number = cardNum.get(num);
				String sales_date = date.get(num);
				
				
				// 영수증 번호 전달
				menu(sales_number, num);
				
				
				out.setEnabled(true);
				refund.setEnabled(true);
				

			} 
		});
	}
	
	// 메뉴를 담는 클래스 
	public void menu (String sales_number, int num) {
		
		String query = "select menu_name, menu_qty, m.price, menu_options "
				+ "from sales s, menu m "
				+ "where sales_number = '" + sales_number + "'"
				+ "AND s.menu_number = m.menu_number"; 
		String query2 = "옵션들 추가";
		
		StringBuilder sb1 = new StringBuilder();
		
		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				// 영수증에 관한 값을 List에 저장 (현재 영수증 테이블에 값이 없엉서 멤버십 테이블로 대신함)
				ResultSetMetaData metadata = rs.getMetaData();
				while (rs.next()) {

					menu_name = rs.getString("menu_name");
					menu_qty = rs.getInt("menu_qty");
					menu_price = rs.getInt("price") * menu_qty;
					options.add(rs.getInt("menu_options") + "");
					
					
					for (int i = 0; i < options.size(); i++) {
						System.out.println(options.get(i));
						
					
						
					}
					
					
					
				
					if (menu_name.length() < 7) {
						sb1.append("  " + menu_name + "\t\t\t " + menu_qty + "\t" + menu_price + "\n"); // 메뉴 프린트
						
					}else {
						sb1.append("  " + menu_name + "\t\t " + menu_qty + "\t" + menu_price + "\n"); // 메뉴 프린트
					}
					
					total_price += menu_price; 

				}
			}
		
			int point = point_payment.get(num); 
			int card = total_price - point;
			String card_num = cardNum.get(num);
			String sale_date = date.get(num);
			String member_phonenumber = mem_number.get(num);
			
			// 환불창에 뜨게 하기
											// 총 가격, 포인트 결제, 카드 결제, 받은 금액
			refundFrame = new RefundFrame(total_price, point, card , card_num, sales_number, member_phonenumber, sb1.toString());
		
		
			// 영수증 출력하는 곳에 값 넣기 
						// 날짜, 영수증번호, 메뉴, 총 가격, 포인트결제, 카드결제
			changeTextA(sale_date, sales_number, sb1.toString(), total_price , point, card);
		
		} catch (SQLException e) {
			System.out.println(" 오류");
			e.printStackTrace();
		}

	}

	
	public void changeTextA(String date, String sales_number, String menu, int price, int point, int card) {
		JTextArea a = PrintScroll.p;
		
		a.setText(" [영수증]\n"
				+ " \n"
				+ " [매장명] 구리점\n"
				+ " [사업자] 123-12-12345\n"
				+ " [주소] 경기도 구리시 건원대로 44 태영빌딩\n"
				+ " 4층 409호\n"
				+ " [대표자] 김XX\t\t\t[TEL] 031-555-4449\n"
				+ " [매출일] " + date + "\n"
				+ " [영수증] " + sales_number + "\n"
				+ " =========================================\n"
				+ "  상 품 명\t\t\t수 량\t단 가\n"
				+ " ----------------------------------------------------------------------------\n"
				+ menu
				+ " ----------------------------------------------------------------------------\n"
				+ " \t\t\t합 계 금 액	"  + price + "\n"
				+ " ----------------------------------------------------------------------------\n"
				+ " \t\t\t받 을 금 액	"  + price + "\n"
				+ " \t\t\t포인트 결제	"  + point + "\n"
				+ " \t\t\t카 드 결 제	"  +  card + "\n"
				+ " \t\t\t받 은 금 액	"  + price + "\n"
				+ " =========================================="
				);
		
		System.out.println(options);
	}
	
	public static void main(String[] args) {
		System.out.println(options);
	}
	

}
