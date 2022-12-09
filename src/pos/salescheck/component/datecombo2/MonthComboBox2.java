package pos.salescheck.component.datecombo2;

import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class MonthComboBox2 extends JComboBox {
	
	Calendar now = Calendar.getInstance();
	int month = now.get(Calendar.MONTH) + 1;
	public static DefaultComboBoxModel<Integer> monthModel2 = new DefaultComboBoxModel<Integer>();
	
	public MonthComboBox2() {
		for (int i = 1; i <= 12; ++i ) {
			monthModel2.addElement(i);
		}
		setModel(monthModel2);
		setBounds(500, 100, 100, 25);
	}

}
