package pos.salescheck.component.datecombo1;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class MonthComboBox extends JComboBox {
	
	// 매출요약 월 콤보박스 생성.
	Calendar now = Calendar.getInstance();
	int month = now.get(Calendar.MONTH) + 1;
	
	public MonthComboBox() {
		for (int i = 1; i <= 12; ++i ) {
			addItem(i);
		}
		setSelectedItem(month);
		setBounds(210, 100, 100, 25);
	
	}
}
