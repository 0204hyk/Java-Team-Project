package kiosk.paymentComplete;

import javax.swing.JFrame;

import kiosk.tools.WithImage;

public class paymentCompleteFrame extends JFrame {
	String root = "images/KioskImages/7_1. 영수증 출력 여부, 카드, 결제완료";
	WithImage wi = new WithImage(root);
	public paymentCompleteFrame() {
		add(wi.makeLabel("payComplete.png", 0,0,414,301));
		setDisplay();
	}
	
	public void setDisplay() {

		//setUndecorated(true); 
		setVisible(true);
		setSize(434, 320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	public static void main(String[] args) {

		new paymentCompleteFrame();
	}
	
	
	
	
}
