package pos.salescheck.component.datecombo2;

import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class DayComboBox2 extends JComboBox {

	Calendar now = Calendar.getInstance();
	int day = now.get(Calendar.DATE);
	DefaultComboBoxModel<Integer> dayModel2 = new DefaultComboBoxModel<Integer>();
	
	public DayComboBox2() {
		
		for (int i = 1; i <= now.getActualMaximum(Calendar.DAY_OF_MONTH); ++i) {
			dayModel2.addElement(i);
		}
		setModel(dayModel2);
		setBounds(600, 100, 100, 25);
		
	}
}
