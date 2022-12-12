package pos.salescheck.component.datecombo2;

import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class MonthComboBox2 extends JComboBox {
	
	// 매출요약 월 콤보박스 생성.
	Calendar now = Calendar.getInstance();
	int month = now.get(Calendar.MONTH) + 1;
	
	
	public MonthComboBox2() {
		for (int i = 1; i <= 12; ++i ) {
			addItem(i);
		}
	
		setBounds(520, 100, 100, 25);
	}

}
