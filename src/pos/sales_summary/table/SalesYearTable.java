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

public class SalesYearTable extends JTable {

	private static String colTitle[] = {"날짜", "매출액"};
	public static DefaultTableModel model = new DefaultTableModel(colTitle, 0) {
		// 테이블 출력 값 선택되지 않게 설정
		public boolean isCellEditable(int i, int c) {
			return false;
		}
	};

	public static int num = 0;
	String year;

	public SalesYearTable() {
		JTable table = new JTable(model);

		//테이블 가운데 정렬
		DefaultTableCellRenderer center =  
				(DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer();
		center.setHorizontalAlignment(SwingConstants.CENTER);
		table.getTableHeader().setDefaultRenderer(center);
		DefaultTableCellRenderer renderer =
				(DefaultTableCellRenderer)table.getDefaultRenderer(Object.class);
		renderer.setHorizontalAlignment( SwingConstants.CENTER );

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

	public SalesYearTable(String year) {
		this.year = year;

		String sql = "SELECT to_char(s.saledate, 'YYYY-MM'), to_char(sum(p.price), '999,999,999') AS total " 
				+ "FROM sales s INNER JOIN PAYMENT p "
				+ "USING (sales_number) "
				+ "WHERE TO_CHAR(s.saledate, 'YYYY') = ? "
				+ "GROUP BY to_char(s.saledate, 'YYYY-MM')"
				+ "ORDER BY to_char(s.saledate, 'YYYY-MM')";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				) {

			pstmt.setString(1, year);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (model.getRowCount() == 0) {
					while(rs.next()) {
						model.addRow(new Object[] {
								rs.getString(1),
								rs.getString("total") + "원"});
					} 
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
