package pos.salescheck.component.table;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.OjdbcConnection;
import pos.salescheck.component.saleslist.TotalLabel;


public class SalesTable extends JTable {

	private static String colTitle[] = {"날짜", "매출액"};
	public static DefaultTableModel model = new DefaultTableModel(colTitle, 0);
	
	StringBuilder sb = new StringBuilder();
	TotalLabel total = new TotalLabel();
	String year, month, day;
	
	public SalesTable() {
		
	
		
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

	
	public SalesTable(String year, String month, String day) {
		this.year = year;
		this.month = month;
		this.day = day;
		
		
		sb.append(year);
		sb.append(month);
		sb.append(day);
		
		
		String sql = "SELECT s.saleDate, to_char(sum(sales_m.total_price), '999,999,999') AS total_price "
				+ "FROM sales s INNER JOIN sales_management sales_m "
				+ "USING (sales_number) "
				+ "WHERE TO_CHAR(s.saleDate, 'YYYYMMDD') = ? GROUP BY s.saleDate";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			
				) {
				pstmt.setString(1, new String(sb));
				
			try (ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					model.addRow(new Object[] {
							rs.getDate(1),
							rs.getString("total_price")});
					total.setText(
							rs.getString("total_price"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
