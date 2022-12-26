package kiosk.menupan;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTest {

	
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		
		
		Date date = now.getTime();

		System.out.println(myDateFormat.format(date));
		
		
	}
}
