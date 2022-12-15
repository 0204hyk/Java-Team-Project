package pos.salescheck.component.table;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.OjdbcConnection;
import pos.salescheck.component.button.SalesSearchButton;


public class SalesTable extends JTable {

	private String colTitle[] = {"날짜", "매출액"};
	private DefaultTableModel model = new DefaultTableModel(colTitle, 0);


	String year;

	public SalesTable() {


		String sql = "SELECT s.saleDate, sales_m.total_price FROM sales s INNER JOIN sales_management sales_m USING (sales_number)";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()
				) {
			while (rs.next()) {
				model.addRow(new Object[] {rs.getDate("saleDate"),
						rs.getInt("total_price")});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	


		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		table.setFont(getFont().deriveFont(20f));
		table.getTableHeader().setFont(new Font("맑은 고딕", Font.PLAIN, 23));
		scroll.setBounds(0, 0, 450, 360);
		setBounds(650, 230, 450, 360);
		add(scroll);
		setLayout(null);
		setVisible(true);
	}
}
