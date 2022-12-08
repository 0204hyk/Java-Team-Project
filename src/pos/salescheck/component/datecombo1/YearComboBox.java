package pos.salescheck.component.datecombo1;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class YearComboBox extends JComboBox  {

	
	Calendar now = Calendar.getInstance();
	int year = now.get(Calendar.YEAR);
	DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();

	public YearComboBox() {
		for (int i = year; i <= year + 10; ++i) {
			yearModel.addElement(i);
		}
		setModel(yearModel);
		setSelectedItem(year);
		setBounds(50, 100, 100, 25);
	}
}
