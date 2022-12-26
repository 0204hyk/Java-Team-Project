package kiosk.paymentComplete;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import kiosk.TouchToPlaceAnOrder;
import kiosk.menupan.ChoiceMenu;
import kiosk.tools.WithImage;

public class PaymentCompleteFrame extends JFrame {
	String root = "images/KioskImages/7_1. 영수증 출력 여부, 카드, 결제완료";
	WithImage wi = new WithImage(root);
	JLabel num;
	ChoiceMenu f;
	
	public PaymentCompleteFrame(ChoiceMenu f) {
		this.f = f;
		num();
		add(wi.makeLabel("payComplete.png", 0, 0, 414, 301));
		setDisplay();
		countdown();
	}

	public void setDisplay() {
		setUndecorated(true);
		setVisible(true);
		setSize(414, 301);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		

	}

	public void num() {
		num = wi.makeLabel("10.png", 192, 197, 29, 26);
		add(num);
	}

	public void countdown() {

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			int count = 5;

			@Override
			public void run() {
				if (count >= 0) {
					num.setIcon(new ImageIcon(
							wi.readImage("images/KioskImages/7_1. 영수증 출력 여부, 카드, 결제완료/" + count + ".png", 29, 26)));
					count--;
				} else {
					timer.cancel();
					dispose();
					f.dispose();
					
					new TouchToPlaceAnOrder();
				}
			}
		};
		timer.schedule(task, 500, 500);
	}
	

	public static void main(String[] args) {

		
	}
}
