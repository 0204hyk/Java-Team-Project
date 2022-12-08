package pos.salescheck.component.dateyear;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JComboBox;

public class YearComboBox extends JComboBox  {

	Calendar ymd = Calendar.getInstance();
	int toyear = ymd.get(Calendar.YEAR);
	ArrayList<String> year;
	String[] comboYear;
	
	public YearComboBox() {
		year = new ArrayList<>();
		for (int i = toyear; i <= toyear +10; i++) {
			year.add(String.valueOf(i));
		}
		//add(new JComboBox(year));
	}

}
