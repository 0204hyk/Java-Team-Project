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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.OjdbcConnection;
import pos.salescheck.component.button.SalesSearchButton;


public class SalesTable extends JTable {

	private static String colTitle[] = {"날짜", "매출액"};
	private static DefaultTableModel model = new DefaultTableModel(colTitle, 0);


	
	StringBuilder sb = new StringBuilder();
	
	String year, month, day;

	
	
	public SalesTable() {
		
	
		
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		table.setFont(getFont().deriveFont(20f));
		table.getTableHeader().setFont(new Font("맑은 고딕", Font.PLAIN, 23));
		scroll.setBounds(0, 0, 450, 360);
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
		
		
		String sql = "SELECT s.saleDate, sales_m.total_price "
				+ "FROM sales s INNER JOIN sales_management sales_m "
				+ "USING (sales_number) WHERE TO_CHAR(s.saleDate, 'YYYYMMDD') = ?";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			
				) {
			
				pstmt.setString(1, new String(sb));
				
			try (ResultSet rs = pstmt.executeQuery()) {
				while(rs.next()) {
					model.addRow(new Object[] {
							rs.getDate(1),
							rs.getInt("total_price")});
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
