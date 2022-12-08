package pos.salescheck.component;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClock extends JFrame implements Runnable{

	private Thread thread;
	private JLabel label;

	public DigitalClock(){
		super("디지털 시계");

		setLayout(new FlowLayout());

		label = new JLabel();
		label.setFont(new Font("Serif",Font.PLAIN, 20));

		if(thread == null){
			
			//this의 의미는 Runnable이 구현된 객체를 뜻함(DigitalClock)
			thread = new Thread(this);
			thread.start();
		}
		add(label);
		setBounds(100,100,400,100);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void run(){
		while(true){
			Calendar cal = Calendar.getInstance();
			String now = cal.get(Calendar.YEAR)+"년"+
					(cal.get(Calendar.MONTH)+1)+"월"+
					cal.get(Calendar.DATE)+"일"+
					cal.get(Calendar.HOUR)+"시"+
					cal.get(Calendar.MINUTE)+"분"+
					cal.get(Calendar.SECOND)+"초";
			label.setText(now);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new DigitalClock();
	}
	
}
