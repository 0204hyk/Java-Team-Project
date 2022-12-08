package pos.salescheck.component.dateyear;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class YearComboBox extends JComboBox  {

	JComboBox<Integer> yearCombo = new JComboBox<Integer>();
	DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<>();
	Calendar now = Calendar.getInstance();
	int year = now.get(Calendar.YEAR);
	
	
	public YearComboBox() {
		for (int i = year; i <= year + 10; ++i) {
			yearModel.addElement(i);
		}
		
		yearCombo.setModel(yearModel);
		yearCombo.setSelectedItem(year);
		add(yearCombo);
	}

}
