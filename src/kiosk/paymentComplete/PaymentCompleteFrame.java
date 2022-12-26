package kiosk.paymentComplete;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import kiosk.TouchToPlaceAnOrder;
import kiosk.tools.WithImage;

public class PaymentCompleteFrame extends JFrame {
	String root = "images/KioskImages/7_1. 영수증 출력 여부, 카드, 결제완료";
	WithImage wi = new WithImage(root);
	JLabel num;

	public PaymentCompleteFrame() {
		num();
		add(wi.makeLabel("payComplete.png", 0, 0, 414, 301));
		setDisplay();
		countdown();
	}

	public void setDisplay() {

		setVisible(true);
		setSize(434, 320);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	public void num() {
		num = wi.makeLabel("10.png", 192, 197, 29, 26);
		add(num);
	}

	public void countdown() {

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			int count = 9;

			@Override
			public void run() {
				if (count >= 0) {
					num.setIcon(new ImageIcon(
							wi.readImage("images/KioskImages/7_1. 영수증 출력 여부, 카드, 결제완료/" + count + ".png", 29, 26)));
					count--;
				} else {
					timer.cancel();
					new TouchToPlaceAnOrder();
				}
			}
		};
		timer.schedule(task, 1000, 1000);
	}

}
