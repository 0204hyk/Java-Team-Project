package pos.salescheck.component.saleslist;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;

import database.OjdbcConnection;

public class TotalLabel extends JLabel {

//	String sql = "SELECT s.saleDate, to_char(sum(sales_m.total_price), '999,999,999') AS total_price "
//			+ "FROM sales s INNER JOIN sales_management sales_m "
//			+ "USING (sales_number) "
//			+ "WHERE TO_CHAR(s.saleDate, 'YYYYMMDD') = ? GROUP BY s.saleDate";
//
//	public TotalLabel() {
//		
//		try (
//				Connection conn = OjdbcConnection.getConnection();
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery();
//				) {
//				if (rs.next()) {
//					setText(rs.getString(5));
//				} else {
//					setText("0");
//				}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		setText("Test");
//		setFont(new Font("맑은 고딕", Font.PLAIN, 30));
//		setBounds(830, 560, 300, 100);
//	}

}
