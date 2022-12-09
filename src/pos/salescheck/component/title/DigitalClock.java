package pos.salescheck.component.title;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClock extends JLabel implements Runnable{

	private Thread thread;

	public DigitalClock(){
		setLayout(new FlowLayout());
		if(thread == null){
			thread = new Thread(this);
			thread.start();
		}
	}

	@Override
	public void run() {
		while(true){
			Calendar cal = Calendar.getInstance();
			String now = cal.get(Calendar.YEAR)+"년 "+
					(cal.get(Calendar.MONTH)+1)+"월 "+
					cal.get(Calendar.DATE)+"일 "+
					cal.get(Calendar.HOUR)+"시 "+
					cal.get(Calendar.MINUTE)+"분 "+
					cal.get(Calendar.SECOND)+"초";
			setText(now);
			setHorizontalAlignment(CENTER);
			setForeground(Color.WHITE);
			setFont(new Font("맑은 고딕", Font.PLAIN, 20));
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}

}
