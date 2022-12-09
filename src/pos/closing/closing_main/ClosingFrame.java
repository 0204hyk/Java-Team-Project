package pos.closing.closing_main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import pos.closing.ImageScaledTool;
import pos.closing.closing_main.component.ClosingButton;
import pos.closing.closing_main.container.CashOnHandPanel;
import pos.closing.closing_main.container.DailySalesPanel;
import pos.closing.closing_main.container.PaymentMethodPanel;
import pos.closing.closing_message.ClosingMessageFrame;

public class ClosingFrame extends JFrame {
	public ClosingFrame() {
		
		PaymentMethodPanel panelA = new PaymentMethodPanel(ImageScaledTool.getScaledImage(
				"PosImages/마감 이미지/현금 & 카드 결제 금액 확인 틀.png", 400, 100));
		CashOnHandPanel panelB = new CashOnHandPanel(ImageScaledTool.getScaledImage(
				"PosImages/마감 이미지/현금 시제 기본 틀.png", 400, 430));
		DailySalesPanel panelC = new DailySalesPanel(ImageScaledTool.getScaledImage(
				"PosImages/마감 이미지/마감 내역 기본 틀.png", 500, 550));
		ClosingMessageFrame messageFrame = new ClosingMessageFrame();
		ClosingButton closingBtn = new ClosingButton(messageFrame);
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
