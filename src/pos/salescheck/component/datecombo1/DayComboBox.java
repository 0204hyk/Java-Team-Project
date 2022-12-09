package pos.salescheck.component.datecombo1;

import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class DayComboBox extends JComboBox {

	Calendar now = Calendar.getInstance();
	int day = now.get(Calendar.DATE);
	DefaultComboBoxModel<Integer> dayModel = new DefaultComboBoxModel<Integer>();
	
	public DayComboBox() {

		
		
		
		for (int i = 1; i <= now.getActualMaximum(Calendar.DAY_OF_MONTH); ++i) {
			dayModel.addElement(i);
		}
		setModel(dayModel);
		setSelectedItem(day);;
		setBounds(250, 100, 100, 25);

	}
	public static void main(String[] args) {

	}
}
