package pos.salescheck.component.saleslist;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import database.OjdbcConnection;

public class TotalPanel extends JPanel {

	String year;
	String month;
	String day;
	String hap;

	public static JLabel text = new JLabel();

	public TotalPanel() {
		setBounds(800, 592, 310, 45);
		text.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		add(text);
	}

	// 연 매출 메뉴에서 YearComboBox 의 값을 가져옴
	public TotalPanel(String year) {
		this.year = year;

		// 해당 년의 합계
		String sql = "SELECT to_char(sum(p.price), '999,999,999') as total "
				+ "FROM sales s INNER JOIN PAYMENT P "
				+ "USING (sales_number) "
				+ "WHERE to_char(s.saledate, 'YYYY') = ? "
				+ "GROUP BY to_char(s.saledate, 'YYYY')"; 
		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			pstmt.setString(1, year);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					text.setText(rs.getString("total")+"원");
				} 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 연 매출 메뉴에서 YearComboBox, MonthComboBox 의 값을 가져옴
	public TotalPanel(String year, String month) {
		this.year = year;
		this.month = month;
		hap = year + month;

		// 해당 월의 합계 sql문
		String sql = "SELECT to_char(sum(p.price), '999,999,999') as total "
				+ "FROM sales s INNER JOIN PAYMENT P "
				+ "USING (sales_number) "
				+ "WHERE to_char(s.saledate, 'YYYYMM') = ? "
				+ "GROUP BY to_char(s.saledate, 'YYYYMM')"; 

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {

			pstmt.setString(1, hap);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					text.setText(rs.getString("total")+"원");
				} 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 연 매출 메뉴에서 YearComboBox, MonthComboBox, DayComboBox 의 값을 가져옴
	public TotalPanel(String year, String month, String day) {
		this.year = year;
		this.month = month;
		this.day = day;
		hap = year + month + day;

		// 해당 일의 합계 sql문
		String sql = "SELECT to_char(sum(p.price), '999,999,999') as total "
				+ "FROM sales s INNER JOIN PAYMENT P "
				+ "USING (sales_number) "
				+ "WHERE to_char(s.saledate, 'YYYYMMDD') = ? "
				+ "GROUP BY to_char(s.saledate, 'YYYYMMDD')"; 

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {
			pstmt.setString(1, hap);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					text.setText(rs.getString("total")+"원");
				} 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
