package pos.gje.ReceiptCheck.receiptcheck_main;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pos.DigitalClock;
import pos.ImageScaledTool;
import pos.closing.closing_main.container.ClosingImagePanel;
import pos.gje.ReceiptCheck.receiptcheck_main.component.OutputButton;
import pos.gje.ReceiptCheck.receiptcheck_main.component.ReceiptCheckEscapeButton;
import pos.gje.ReceiptCheck.receiptcheck_main.component.ReceiptCheckTextArea;
import pos.gje.ReceiptCheck.receiptcheck_main.component.RefundButton;
import pos.gje.ReceiptCheck.receiptcheck_main.panel.ReceiptListPanel;
import pos.gje.ReceiptCheck.refund.RefundFrame;

public class ReceiptCheckFrame extends JFrame{
	public ReceiptCheckFrame() {		
		setTitle("영수증 조회");
		
		// 상단 메뉴바 설정
		JPanel titlePanel = new ClosingImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/상단 메뉴바.png", 1200, 60));
		titlePanel.setBounds(0 ,0, 1200, 60);
		// 현재 시간 출력
		JLabel clock = new DigitalClock();
		clock.setBounds(375, 10, 400, 30);
		titlePanel.add(clock);
		
		add(titlePanel);
		
		// 영수증 목록 (Panel)
		add(new ReceiptListPanel());
		
		// 버튼
		RefundFrame refundFrame = new RefundFrame(this);
		add(new RefundButton(this, refundFrame));
		add(new OutputButton());
		
		// 영수증 출력 
		add(new ReceiptCheckTextArea());
		
		// 돌아가기 버튼
		ReceiptCheckEscapeButton escapeBtn = new ReceiptCheckEscapeButton(this);
		escapeBtn.setLocation(75, 650);
		add(escapeBtn);
		
		getContentPane().setBackground(new Color(64, 64, 64)); // 배경색
		setSize(1200, 800); // 프레임 사이즈
		setLayout(null); 
		setVisible(true); 
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
	}
	
}
