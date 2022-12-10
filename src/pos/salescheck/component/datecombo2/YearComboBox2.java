package pos.salescheck.component.datecombo2;

import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class YearComboBox2 extends JComboBox {
	
	Calendar now = Calendar.getInstance();
	int year = now.get(Calendar.YEAR);

	
	public YearComboBox2() {
		for (int i = year; i <= year + 10; ++i) {
			addItem(i);
		}

		setSelectedItem(year);
		setBounds(410, 100, 100, 25);
		
	}

}
