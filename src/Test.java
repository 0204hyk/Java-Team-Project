import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import pos.kjh.LoginSelectFrame;

public class Test {
	public static void main(String[] args) {
//		new LoginSelectFrame();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(formatter.format(LocalDateTime.now()));
	}
}
