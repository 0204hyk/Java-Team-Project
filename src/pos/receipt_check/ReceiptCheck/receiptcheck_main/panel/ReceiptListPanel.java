package pos.receipt_check.ReceiptCheck.receiptcheck_main.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import database.OjdbcConnection;
import pos.receipt_check.ReceiptCheck.receiptcheck_main.ReceiptCheckFrame;
import pos.receipt_check.ReceiptCheck.receiptcheck_main.component.ReceiptBtn;

public class ReceiptListPanel extends JPanel {

	// 패널 배경 넣기
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon("images/PosImages/영수증 조회 이미지/날짜별 영수증 리스트 기본 틀.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
	public ReceiptListPanel(ReceiptCheckFrame f) {
		
		
		String query = "SELECT * FROM membership ";
		
	      try (Connection conn = OjdbcConnection.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(query);
	      ) {

	    	  ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					ResultSetMetaData rsmd = rs.getMetaData();
					// 열의 개수
					int colCount = rsmd.getColumnCount();

					for (int i = 0; i < colCount; ++i){
						add(new ReceiptBtn(i + 1, f));
					}
					// i = DB에 저장된 개수 	
					setBounds(75, 95, 500, 550); // Panel 틀
					setLayout(null);
					setVisible(true);
					
				}
	         
	      } catch (SQLException e) {
	         System.out.println(" 오류");
	         e.printStackTrace();
	      }  
	}	       
}
