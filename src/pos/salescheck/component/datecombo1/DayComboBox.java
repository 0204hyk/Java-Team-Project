package pos.salescheck.component.datecombo1;

import java.awt.Dimension;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class DayComboBox extends JComboBox {

	Calendar now = Calendar.getInstance();
	int day = now.get(Calendar.DATE);
	
	
	public DayComboBox() {
		
		for (int i = 1; i <= now.getActualMaximum(Calendar.DAY_OF_MONTH); ++i) {
			addItem(i);
		}
		
		setSelectedItem(day);;
		setBounds(250, 100, 100, 25);
	}

}
