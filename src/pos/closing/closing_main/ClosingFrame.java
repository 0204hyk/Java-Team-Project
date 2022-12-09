package pos.closing.closing_main;

import java.awt.Color;

import javax.swing.JFrame;

import pos.closing.ImageScaledTool;
import pos.closing.closing_main.component.DoCloseButton;
import pos.closing.closing_main.container.CashOnHandPanel;
import pos.closing.closing_main.container.DailySalesPanel;
import pos.closing.closing_main.container.PaymentMethodPanel;
import pos.closing.closing_message.ClosingMessageFrame;

public class ClosingFrame extends JFrame {
	public ClosingFrame() {
		
		PaymentMethodPanel panelA = new PaymentMethodPanel(ImageScaledTool.getScaledImage(
				"PosImages/마감 이미지/현금 & 카드 결제 금액 확인 틀.png", 400, 100));
		panelA.setLocation(120, 80);

		CashOnHandPanel panelB = new CashOnHandPanel(ImageScaledTool.getScaledImage(
				"PosImages/마감 이미지/현금 시제 기본 틀.png", 400, 430));
		panelB.setLocation(120, 230);

		
		DailySalesPanel panelC = new DailySalesPanel(ImageScaledTool.getScaledImage(
				"PosImages/마감 이미지/마감 내역 기본 틀.png", 500, 550));
		panelC.setLocation(600, 100);

		ClosingMessageFrame messageFrame = new ClosingMessageFrame();
		
		DoCloseButton closingBtn = new DoCloseButton(messageFrame);
		closingBtn.setLocation(800, 660);
		
		pack();

		add(panelA);
		add(panelB);
		add(panelC);
		add(closingBtn);
		
		setTitle("마감");
		setSize(1200, 800);
		getContentPane().setBackground(new Color(64, 64, 64));	// 프레임 백그라운드 컬러 설정
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
