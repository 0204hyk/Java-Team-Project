package pos.salescheck.component.datecombo1;

import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class MonthComboBox extends JComboBox {
	
	Calendar now = Calendar.getInstance();
	int month = now.get(Calendar.MONTH) + 1;
	
	
	public MonthComboBox() {
		for (int i = 1; i <= 12; ++i ) {
			addItem(i);
		}
	
		setSelectedItem(month);
		setBounds(170, 100, 100, 25);
	}
}
