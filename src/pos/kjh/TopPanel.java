package pos.kjh;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel{
	
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon("PosImages/상품 관리 이미지/상단바 이미지.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	
	}

	
	public TopPanel() {
		
			Calendar cal = Calendar.getInstance();

			String time = (cal.get(Calendar.YEAR) + "년 " +
					(cal.get(Calendar.MONTH) + 1) + "월 " +
					cal.get(Calendar.DATE) + "일 " +
					cal.get(Calendar.HOUR_OF_DAY) + "시 " +
					cal.get(Calendar.MINUTE) + "분 " +
					cal.get(Calendar.SECOND) + "초");

		/*
		while(true) {//무조건 실행
			
			Calendar t=Calendar.getInstance();
			int year = t.get(Calendar.YEAR); 
			int month = t.get(Calendar.MONTH);
			int date = t.get(Calendar.DATE);
			int amPm = t.get(Calendar.AM_PM);
			int hour = t.get(Calendar.HOUR);
			int min = t.get(Calendar.MINUTE);
			int sec = t.get(Calendar.SECOND);
			String ampm = amPm == Calendar.AM ? "오후":"오전";
	
			try { //트라이 
				Thread.sleep(10);
		    } catch(Exception e) {}
		}*/

		JLabel date = new JLabel();

		date.setText(time);
		date.setFont(new Font("맑은고딕", Font.BOLD, 10));
		date.setForeground(Color.white);
		date.setFont(date.getFont().deriveFont(15.0f));
		add(date, "Center");
		
		setBounds(0, 0, 1200, 50);
	}

	public void set() {
		
	}
	


}
