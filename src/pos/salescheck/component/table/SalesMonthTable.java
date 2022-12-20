package pos.salescheck.component.table;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import database.OjdbcConnection;


public class SalesMonthTable extends JTable {

	private static String colTitle[] = {"날짜", "매출액"};
	public static DefaultTableModel model = new DefaultTableModel(colTitle, 0);
	


	String year;
	String month; 

	public SalesMonthTable() {
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		// 컬럼 가운데 정렬
		DefaultTableCellRenderer renderer =  
		          (DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer();
				renderer.setHorizontalAlignment(SwingConstants.CENTER);
				table.getTableHeader().setDefaultRenderer(renderer);
		
		
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


	public SalesMonthTable(String year, String month) {
		this.year = year;
		this.month = month;

		String plus = year + month;
		String sql = 
				"SELECT to_char(s.saleDate, 'YYYY-MM-DD'), to_char(sum(p.price), '999,999,999') AS price "
						+ "FROM sales s INNER JOIN PAYMENT p "
						+ "USING (sales_number)"
						+ "WHERE TO_CHAR(s.saleDate, 'YYYYMM') = ?"
						+ "GROUP BY to_char(s.saledate, 'YYYY-MM-DD')"
						+ "ORDER BY to_char(s.saledate, 'YYYY-MM-DD')";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);

				) {

			pstmt.setString(1, plus);

			try (ResultSet rs = pstmt.executeQuery()) {
				while(rs.next()) {
					model.addRow(new Object[] {
							rs.getString(1),
							rs.getString("price") + "원"});
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

