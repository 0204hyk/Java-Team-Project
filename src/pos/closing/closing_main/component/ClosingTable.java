package pos.closing.closing_main.component;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import database.OjdbcConnection;

public class ClosingTable extends JTable {

	String [] title = {"시간", "매출"};
	DefaultTableModel model = new DefaultTableModel(title, 0);
		
	public ClosingTable() {		
		String query = "SELECT TO_CHAR(saledate, 'HH24'), TO_CHAR(SUM(price), '999,999,999')"
				+ "FROM sales INNER JOIN payment USING(sales_number)"
				+ "WHERE TO_CHAR(saledate, 'YYYY-MM-DD') = TO_CHAR(sysdate, 'YYYY-MM-DD')"
				+ "AND TO_CHAR(saledate, 'HH24') = 11"
				+ "GROUP BY TO_CHAR(saledate, 'HH24')"
				+ "ORDER BY TO_CHAR(saledate, 'HH24')";
		setModel(model);
		
		try (
			Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);		
			ResultSet rs = pstmt.executeQuery();
		) {
//			for (int i = 9; i < 20; ++i) {
//				pstmt.setInt(1, i);
//			}

			while(rs.next()) {
				model.addRow(new Object[] 
						{rs.getString("TO_CHAR(saledate, 'HH24')"), rs.getString("SUM(price)")});				
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} 

		model.addRow(new Object[] {1, 2});
		
		// 정렬할 테이블의 컬럼모델 가져오기
		TableColumnModel tcm = getColumnModel();

		// 컬럼 가운데 정렬 
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		tcm.getColumn(0).setCellRenderer(dtcr);
		tcm.getColumn(1).setCellRenderer(dtcr);
		
		setRowHeight(50);	// 컬럼 높이 설정
		setFont(new Font("맑은 고딕", Font.BOLD, 15));
		getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 20));	// 컬럼 헤드 폰트
		getTableHeader().setBackground(new Color(217, 217, 217));	// 컬럼 헤드 배경색
		getTableHeader().setReorderingAllowed(false); // 컬럼 헤드 이동 안되게 하기
		
		setLayout(null);

	}

}
