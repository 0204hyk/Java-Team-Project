package pos.closing.closing_main.component;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;

import database.OjdbcConnection;

public class DailySalesLabel extends JLabel {
	// 총 금액 라벨
	
	String query = "SELECT trim(to_char(sum(price), '999,999,999')) "
			+ "FROM sales INNER JOIN payment USING (sales_number)"
			+ "WHERE to_char(saledate, 'YYYY-MM-DD') = to_char(sysdate, 'YYYY-MM-DD')"
			+ "AND to_char(saledate, 'HH24') BETWEEN 10 AND 21";
	
	public DailySalesLabel() {
		
		try (
			Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		) {
			if (rs.next()) {
<<<<<<< HEAD
				setText(rs.getString(1));
			} else {
				setText("0");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setSize(300, 30);
		setHorizontalAlignment(JLabel.RIGHT);
		setFont(new Font("맑은 고딕", Font.BOLD, 25));
=======
				if (rs.getString(1) == null) {
					setText("0");
				} else {
					setText(rs.getString(1));					
				}
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setSize(300, 30);
		setHorizontalAlignment(JLabel.RIGHT);
		setFont(new Font("맑은 고딕", Font.BOLD, 32));
>>>>>>> refs/remotes/origin/main
	}
}
