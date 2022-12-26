package kiosk.menupan;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTest {

	
	public static void main(String[] args) {
<<<<<<< HEAD
		
		
//		System.out.printf("%d%d%d-01-%d%d%d",now.get(Calendar.YEAR),
//				now.get(Calendar.MONTH),now.get(Calendar.DATE),
//				now.get(Calendar.HOUR),now.get(Calendar.MINUTE),
//				now.get(Calendar.SECOND));
//		
//		
=======
		Calendar now = Calendar.getInstance();
		SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		
		
		Date date = now.getTime();

		System.out.println(myDateFormat.format(date));
		
		
>>>>>>> refs/remotes/origin/jsj
	}
}
