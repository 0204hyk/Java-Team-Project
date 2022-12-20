package pos.salescheck.component.table;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.OjdbcConnection;
import database.model.SalesAndSalesManagement;
import pos.salescheck.component.button.SalesSearchButton;
import pos.salescheck.component.saleslist.TotalLabel;


public class SalesDayTable extends JTable {

	private static String colTitle[] = {"시간", "매출액"};
	public static DefaultTableModel model = new DefaultTableModel(colTitle, 0);

	
	String year;
	String month; 
	String day;

	
	public SalesDayTable() {
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		table.setFont(getFont().deriveFont(23f));
		table.getTableHeader().setFont(new Font("맑은 고딕", Font.PLAIN, 23));
		scroll.setBounds(0, 0, 450, 360);
		table.setRowHeight(30);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
	
		add(scroll);
		setBounds(650, 230, 450, 360);
		setLayout(null);
		setVisible(true);
	}
	
	public SalesDayTable(String year, String month, String day) {
		this.year = year;
		this.month = month;
		this.day = day;
		
		String plus = year + month + day;
//		String sql = "SELECT s.saleDate, to_char(sum(sales_m.total_price), '999,999,999') AS total_price "
//				+ "FROM sales s INNER JOIN sales_management sales_m "
//				+ "USING (sales_number) "
//				+ "WHERE TO_CHAR(s.saleDate, 'YYYYMMDD') = ? GROUP BY s.saleDate";
		String sql = "SELECT to_char(saledate, 'HH24'), trim(to_char(sum(price), '999,999,999')) AS total "
				+ "FROM sales INNER JOIN payment USING(sales_number) "
				+ "WHERE to_char(saledate, 'YYYYMMDD') = ? "
				+ "AND to_char(saledate, 'HH24') = ? "
				+ "GROUP BY to_char(saledate, 'HH24') "
				+ "ORDER BY to_char(saledate, 'HH24')";
		
		
		

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			
				) {
			
			ResultSet rs = null;
			for (int i = 10; i < 22; ++i) {
				pstmt.setString(1, plus);
				pstmt.setInt(2, i);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					model.addRow(new Object[] {
							i + "시 ~ " + (i + 1) + "시", rs.getString("total") + "원" 
					});
				} else {
					model.addRow(new Object[] {
							i + "시 ~ " + (i + 1) + "시", "0 원"
					});
				}
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
