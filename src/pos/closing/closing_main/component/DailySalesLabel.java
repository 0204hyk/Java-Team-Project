package pos.closing.closing_main.component;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.JLabel;

import database.OjdbcConnection;

public class DailySalesLabel extends JLabel {
	// 총 금액 라벨
	
	String query = "SELECT sum(price) - sum(used_point) "
			+ "FROM sales_management INNER JOIN sales USING (sales_number)"
			+ "WHERE to_char(saledate, 'YYYY-MM-DD') = to_char(sysdate, 'YYYY-MM-DD')"
			+ "AND to_char(saledate, 'HH24') BETWEEN 10 AND 21 "
			+ "GROUP BY used_point";
	
	public DailySalesLabel() {
		setText("0");
		try (
			Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
		) {
			int totalSales = 0;
			while (rs.next()) {
				totalSales += rs.getInt(1);
			}
			
			DecimalFormat formatter = new DecimalFormat("###,###");
			setText(formatter.format(totalSales));					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setSize(300, 30);
		setHorizontalAlignment(JLabel.RIGHT);
		setFont(new Font("맑은 고딕", Font.BOLD, 32));
	}
}
