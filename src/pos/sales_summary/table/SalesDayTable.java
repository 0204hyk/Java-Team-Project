package pos.sales_summary.table;


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

public class SalesDayTable extends JTable {

	private static String colTitle[] = {"시간", "매출액"};
	public static DefaultTableModel model = new DefaultTableModel(colTitle, 0) {
		// 테이블 출력 값 선택되지 않게 설정
		public boolean isCellEditable(int i, int c) {
			return false;
		}
	};

	String year;
	String month; 
	String day;

	public SalesDayTable() {
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		//테이블 가운데 정렬
		DefaultTableCellRenderer center =  
				(DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer();
		center.setHorizontalAlignment(SwingConstants.CENTER);
		table.getTableHeader().setDefaultRenderer(center);
		DefaultTableCellRenderer renderer =
				(DefaultTableCellRenderer)table.getDefaultRenderer(Object.class);
		renderer.setHorizontalAlignment( SwingConstants.CENTER );

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

		String sql = "SELECT to_char(saledate, 'HH24'), trim(to_char(sum(price), '999,999,999')) AS total "
				+ "FROM sales_management INNER JOIN sales USING(sales_number) "
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
