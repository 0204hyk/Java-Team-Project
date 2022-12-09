package pos.closing;

import java.awt.Color;

import javax.swing.JFrame;

public class ClosingFrame extends JFrame {
	public ClosingFrame() {
		
		PaymentMethodPanel panelA = new PaymentMethodPanel();
		CashOnHandPanel panelB = new CashOnHandPanel();
		DailySalesPanel panelC = new DailySalesPanel();
		ClosingButton closingBtn = new ClosingButton();
		
//		JLabel labelA;

		add(panelA);
		add(panelB);
		add(panelC);
		add(closingBtn);
		

		setLocation(400, 100);
		setSize(1200, 800);
		getContentPane().setBackground(new Color(64, 64, 64));	// 프레임 백그라운드 컬러 설정
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ClosingFrame();
	}
}
