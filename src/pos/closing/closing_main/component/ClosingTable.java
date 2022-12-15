package pos.closing.closing_main.component;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import database.OjdbcConnection;

public class ClosingTable extends JTable {
	
	public ClosingTable() {		
		String [] title = {"시간", "매출"};
		String [][] value = {{"9시 ~ 10시","30000원"},
							{"10시 ~ 11시","25000원"},
							{"11시 ~ 12시", "23400원"},
							{"12시 ~ 13시", "0원"},
							{"13시 ~ 14시", "0원"},
							{"14시 ~ 15시", "0원"},
							{"15시 ~ 16시", "0원"},
							{"16시 ~ 17시", "0원"},
							{"17시 ~ 18시", "0원"},
							{"18시 ~ 19시", "0원"}};
		
		DefaultTableModel model = new DefaultTableModel(value, title);
		setModel(model);
		
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
