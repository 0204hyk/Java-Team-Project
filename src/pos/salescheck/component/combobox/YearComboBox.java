package pos.salescheck.component.combobox;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import javax.swing.JComboBox;
import pos.salescheck.component.table.SalesYearTable;

public class YearComboBox extends JComboBox  {

	// 매출요약 년도 콤보박스 생성.
	Calendar now = Calendar.getInstance();
	int year = now.get(Calendar.YEAR);

	
	public YearComboBox() {
		for (int i = year - 10; i <= year; ++i) {
			addItem(i);
		}

		setSelectedItem(year);
		setBounds(90, 100, 100, 25);
		
		// 콤보박스 값 선택 시 table 리스트 초기화
		addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				SalesYearTable table = new SalesYearTable();
				table.model.setNumRows(0);
			}
		});
	}
}
