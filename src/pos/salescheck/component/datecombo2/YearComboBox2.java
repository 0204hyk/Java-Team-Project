package pos.salescheck.component.datecombo2;

import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class YearComboBox2 extends JComboBox {
	
	Calendar now = Calendar.getInstance();
	int year = now.get(Calendar.YEAR);
	DefaultComboBoxModel<Integer> yearModel2 = new DefaultComboBoxModel<Integer>();
	
	public YearComboBox2() {
		for (int i = year; i <= year + 10; ++i) {
			yearModel2.addElement(i);
		}
		setModel(yearModel2);
		setSelectedItem(year);
		setBounds(150, 150, 100, 25);
		
	}

}
