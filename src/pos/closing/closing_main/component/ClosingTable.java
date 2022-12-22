package pos.closing.closing_main.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import database.OjdbcConnection;

public class ClosingTable extends JTable {

	String [] column = {"시간", "매출"};
	DefaultTableModel model = new DefaultTableModel(column, 0) {
        public boolean isCellEditable(int i, int c) {
            return false;
        }
	};
	String query = "SELECT to_char(saledate, 'HH24'), trim(to_char(sum(price), '999,999,999'))"
			+ "FROM sales INNER JOIN payment USING(sales_number)"
			+ "WHERE to_char(saledate, 'YYYY-MM-DD') = to_char(sysdate, 'YYYY-MM-DD')"
			+ "AND to_char(saledate, 'HH24') = ?"
			+ "GROUP BY to_char(saledate, 'HH24')"
			+ "ORDER BY to_char(saledate, 'HH24')";
		
	public ClosingTable() {
		
		setModel(model);
		
		try (
			Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);		
		) {
			
			ResultSet rs = null;
			
			for (int i = 10; i < 22; ++i) {
				pstmt.setInt(1, i);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					model.addRow(new Object[] 
							{i + "시 ~ " + (i + 1) + "시", rs.getString(2) + " 원"});				
				} else {
					model.addRow(new Object[] {i + "시 ~ " + (i + 1) + "시", "0 원"});
				}
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		// 정렬할 테이블의 컬럼모델 가져오기
		TableColumnModel tcm = getColumnModel();
		
		// 컬럼 가운데 정렬 
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		tcm.getColumn(0).setCellRenderer(dtcr);
		tcm.getColumn(1).setCellRenderer(dtcr);
		
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	// 행 한개만 선택 가능
		setRowHeight(48);	// 컬럼 높이 설정
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
		getTableHeader().setPreferredSize(new Dimension(0, 50));	// 컬럼 헤드 높이 설정
		getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 25));	// 컬럼 헤드 폰트
		getTableHeader().setBackground(new Color(217, 217, 217));	// 컬럼 헤드 배경색
		getTableHeader().setResizingAllowed(false);		// 컬럼 헤드 마우스 드래그로 크기 조정 안되게 하기 (컬럼 사이즈 고정)
		getTableHeader().setReorderingAllowed(false); // 컬럼 헤드 이동 안되게 하기
		
		
		setLayout(null);

	}

}
