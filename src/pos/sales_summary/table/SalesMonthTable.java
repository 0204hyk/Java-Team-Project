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

public class SalesMonthTable extends JTable {

	private static String colTitle[] = {"날짜", "매출액"};
	public static DefaultTableModel model = new DefaultTableModel(colTitle, 0) {
		// 테이블 출력 값 선택되지 않게 설정
		public boolean isCellEditable(int i, int c) {
			return false;
		}
	};

	String year;
	String month; 

	public SalesMonthTable() {
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

		table.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 25));
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
		String sql = "SELECT to_char(saledate, 'YYYY-MM-DD'), to_char(sum(price) - sum(used_point), '999,999,999') as price "
				+ "FROM sales INNER JOIN sales_management USING(sales_number) "
				+ "WHERE to_char(saledate, 'YYYYMM') = ? "
				+ "GROUP BY to_char(saledate, 'YYYY-MM-DD')";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {

			pstmt.setString(1, plus);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (model.getRowCount() == 0) {
					while(rs.next()) {
						model.addRow(new Object[] {
								rs.getString(1),
								rs.getString("price") + "원"});
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

