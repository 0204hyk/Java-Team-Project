package pos.salescheck.component.datecombo1;

import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class MonthComboBox extends JComboBox {
	
	Calendar now = Calendar.getInstance();
	int month = now.get(Calendar.MONTH) + 1;
	public static DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();
	
	public MonthComboBox() {
		for (int i = 1; i <= 12; ++i ) {
			monthModel.addElement(i);
		}
		setModel(monthModel);
		setSelectedItem(month);
		setBounds(150, 100, 100, 25);
	}
}
