package pos.salescheck.component.datecombo1;

import java.awt.Dimension;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class DayComboBox extends JComboBox {

	// 매출요약 일 콤보박스 생성.
	Calendar now = Calendar.getInstance();
	int day = now.get(Calendar.DATE);
	
	
	public DayComboBox() {
		
		for (int i = 1; i <= now.getActualMaximum(Calendar.DAY_OF_MONTH); ++i) {
			addItem(i);
		}
		
		setSelectedItem(day);;
		setBounds(320, 100, 100, 25);
	}

}
