package pos.gje.ReceiptCheck.receiptcheck_main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import database.OjdbcConnection;
import pos.gje.ReceiptCheck.receiptcheck_main.component.PrintScroll;

// 리스트
public class List {

	static private String[] top = {"순서", "영수증번호"};
	public static DefaultTableModel contents = new DefaultTableModel(top, 0); // 테이블 안에 들어가는 데이터 값을 채워넣음
	public static JTable table; 
	public static JScrollPane scroll;
	static ArrayList<String> number = new ArrayList<>();
	static ArrayList<String> point = new ArrayList<>();
	static ArrayList<String> date = new ArrayList<>();
	static int num = 1;
	
	public List() {
		
		String query = "SELECT * FROM membership ";
		
		try (Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				) {
			ResultSet rs = pstmt.executeQuery();
			int num = 1;
			while (rs.next()) {
				// 영수증에 관한 값을 List에 저장
				number.add(rs.getString("member_phonenumber"));
				point.add(rs.getString("member_point"));
				date.add(rs.getString("member_join"));
				
				contents.addRow(new Object[] {
						num++,
						rs.getString("member_phonenumber") 
				});
			}
		} catch (SQLException e) {
			System.out.println(" 오류");
			e.printStackTrace();
		}
		
		table = new JTable(contents);
		scroll = new JScrollPane(table);
		scroll.setBounds(75, 95, 500, 550);
		
		// 크기 조정 
		table.getColumn("순서").setPreferredWidth(20);
		table.getColumn("영수증번호").setPreferredWidth(450);

		// 수정 안되게 만들기
		table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);

	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 선택한 Row의 순서를 int 타입으로 변경 
				//(table 은 1부터 시작하기 때문에 - 1 을 해줘야 List에 담긴 값을 정확히 불러올 수 있다.
				String d = date.get((int)(table.getValueAt(table.getSelectedRow(), 0)) - 1);
				String n = (table.getValueAt(table.getSelectedRow(), 1)).toString();
				
				// 영수증을 프린틑하는 메소드에 값을 넣는다 
				changeTextA(n, d);
			}
		});
		
	}
	
	public void changeTextA(String num, String point) {
		JTextArea a = PrintScroll.p;
		
		a.setText("[영수증]\n"
				+ "\n"
				+ "[매장명] 구리점\n"
				+ "[사업자] 123-12-12345\n"
				+ "[주소] 경기도 구리시 건원대로 44 태영빌딩\n"
				+ "4층 409호\n"
				+ "[대표자] 김XX		[TEL] 031-555-4449\n"
				+ "[매출일] " + point + "\n"
				+ "[영수증] " + num + "\n"
				+ "====================================\n"
				+ " 상 품 명\t\t수 량\t단 가\n"
				+ "-----------------------------------------------------------------\n"
				+ num + "\t\t" + num + "\t" + num + "\n"
				+ "-----------------------------------------------------------------\n"
				+ "\t\t합 계 금 액   "  + num + "\n"
				+ "------------------------------------------------------------------\n"
				+ "\t\t받 을 금 액   "  + num + "\n"
				+ "\t\t받 은 금 액   "  + num + "\n"
				+ "\t\t받 은 카 드   " + num + "\n"
				+ "\t\t받 은 카 드   " + num + "\n"
				+ "\t\t받 은 카 드   " + num + "\n"
				
				+ "====================================="
				);
	}
	
}
