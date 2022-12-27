package pos.receipt_check.ReceiptCheck.receiptcheck_main.component;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import database.OjdbcConnection;
import pos.receipt_check.ReceiptCheck.receiptcheck_main.ReceiptCheckFrame;

public class ReceiptBtn extends JButton implements ActionListener{
	int num;
	String text;
	List<String> numList = new ArrayList<>();
	List<String> numList2 = new ArrayList<>();
	List<String> numList3 = new ArrayList<>();
	ReceiptCheckFrame f;
	//public static int colCount;
	
	public ReceiptBtn(int num, ReceiptCheckFrame f) {
		this.num = num;
		this.f = f;

		String query = "SELECT * FROM membership ";
		
	      try (Connection conn = OjdbcConnection.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(query);
	      ) {

	    	  ResultSet rs = pstmt.executeQuery();
				
				// 4. 받아온 결과를 사용한다 (SELECT의 경우 ResultSet 타입 인스턴스에 들어있다)
				while (rs.next()) {
//					System.out.printf("%s\t%d\t%s<br>",
//							rs.getString("member_phonenumber"), 
//							rs.getInt("member_point"),
//							rs.getString("member_join"));
					
	
					numList.add(rs.getString("member_phonenumber"));
					numList2.add(rs.getString("member_point"));
					numList3.add(rs.getString("member_join"));
				}
	      } catch (SQLException e) {
	         System.out.println(" 오류");
	         e.printStackTrace();
	      }
	      int x = 2;
	      int y = 50;
	      
	      y = y * num;
	      
	      setText(num + "    " + numList.get(num));
	      setFont(new Font("맑은 고딕", Font.PLAIN, 25));	
	      setBounds(x, y, 300, 50);  setHorizontalAlignment(SwingConstants.LEFT);
	      setVisible(true);
	      setContentAreaFilled(false);
	      setBorderPainted(false);
	      setOpaque(false);
	      addActionListener(this);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// JLabel 바꾸기 
		// 
		System.out.println(num + " 클릭");
		System.out.println(numList.get(num));
		changeTextA(numList.get(num), numList2.get(num), numList3.get(num)); // 영수증에 들어가야 하는 값 전달
		
	}
	
	// 버튼에 대한 값을 받아온다 
	public void changeTextA(String num, String point, String date) {
		JTextArea a = PrintScroll.p;
		
		a.setText("[영수증]\n"
				+ "\n"
				+ "[매장명] 구리점\n"
				+ "[사업자] 123-12-12345\n"
				+ "[주소] 경기도 구리시 건원대로 44 태영빌딩\n"
				+ "4층 409호\n"
				+ "[대표자] 김XX		[TEL] 031-555-4449\n"
				+ "[매출일] " + date + "\n"
				+ "[영수증] " + num + "\n"
				+ "====================================\n"
				+ " 상 품 명\t\t수 량\t단 가\n"
				+ "-----------------------------------------------------------------\n"
				+ num + "\t\t" + num + "\t" + num + "\n"
				+ "-----------------------------------------------------------------\n"
				+ "\t\t합 계 금 액   "  + point + "\n"
				+ "------------------------------------------------------------------\n"
				+ "\t\t받 을 금 액   "  + point + "\n"
				+ "\t\t받 은 금 액   "  + point + "\n"
				+ "\t\t받 은 카 드   " + point + "\n"
				+ "\t\t받 은 카 드   " + point + "\n"
				+ "\t\t받 은 카 드   " + point + "\n"
				
				+ "====================================="
				);
	}
	
	
}
