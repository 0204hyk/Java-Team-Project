package pos.salescheck.component;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DateComboBox extends JComboBox{
	
	
	Calendar ymd = Calendar.getInstance(); // 현재 날짜/시간 등 정보 얻기
	int toyear = ymd.get(Calendar.YEAR);
	int tomonth = ymd.get(Calendar.MONTH);
	int today = ymd.get(Calendar.DAY_OF_MONTH);
	ArrayList<String> year;
	ArrayList<String> month;
	ArrayList<String> day;
	JComboBox<String> comboYear, comboMonth, comboDay;
	ArrayList<String> year2;
	ArrayList<String> month2;
	ArrayList<String> day2;
	JComboBox<String> comboYear2, comboMonth2, comboDay2;
	
	public DateComboBox() {
		
		// 년도 콤보박스 
				year = new ArrayList<>();
				for (int i = toyear; i <= toyear +10; i++) {
					year.add(String.valueOf(i));
				}
				comboYear = new JComboBox<String>(year.toArray(new String[year.size()]));
				comboYear.setBounds(50, 100, 100, 25);
				
				year2 = new ArrayList<>();
				for (int i = toyear; i <= toyear +10; i++) {
					year2.add(String.valueOf(i));
				}
				comboYear2 = new JComboBox<String>(year.toArray(new String[year.size()]));
				comboYear2.setBounds(150, 150, 100, 25);
				
				// 월 콤보박스
				month = new ArrayList<>();
				for (int i = 1; i <= 12; ++i) {
					month.add(String.valueOf(i));
				}
				comboMonth = new JComboBox<String>(month.toArray(new String[month.size()]));
				comboMonth.setBounds(150, 100, 100, 25);
				
				month2 = new ArrayList<>();
				for (int i = 1; i <= 12; ++i) {
					month2.add(String.valueOf(i));
				}
				comboMonth2 = new JComboBox<String>(month.toArray(new String[month.size()]));
				comboMonth2.setBounds(250, 150, 100, 25);
				
				
				// 일 콤보박스
				day = new ArrayList<>();
				for (int i = 1; i < 31; ++i) {
					day.add(String.valueOf(i));
				}
				comboDay = new JComboBox<String>(day.toArray(new String[day.size()]));
				comboDay.setBounds(250, 100, 100, 25);
				
				day2 = new ArrayList<>();
				for (int i = 1; i < 31; ++i) {
					day2.add(String.valueOf(i));
				}
				comboDay2 = new JComboBox<String>(day2.toArray(new String[day2.size()]));
				comboDay2.setBounds(350, 150, 100, 25);


	}

	
}
