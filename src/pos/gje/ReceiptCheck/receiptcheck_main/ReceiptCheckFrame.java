package pos.gje.ReceiptCheck.receiptcheck_main;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import pos.DigitalClock;
import pos.ImagePanel;
import pos.ImageScaledTool;
import pos.gje.ReceiptCheck.receiptcheck_main.component.OutputButton;
import pos.gje.ReceiptCheck.receiptcheck_main.component.PrintScroll;
import pos.gje.ReceiptCheck.receiptcheck_main.component.PrintTextArea;
import pos.gje.ReceiptCheck.receiptcheck_main.component.ReceiptCheckEscapeButton;
import pos.gje.ReceiptCheck.receiptcheck_main.component.RefundButton;
import pos.gje.ReceiptCheck.refund.RefundFrame;

public class ReceiptCheckFrame extends JFrame{
	
	public static JTextArea printTextArea = new PrintTextArea();
	//JScrollPane s = new JScrollPane();
	
	
	public ReceiptCheckFrame() {		
		
		// 상단 메뉴바 설정
		JPanel titlePanel = new ImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/상단 메뉴바.png", 1200, 60));
		titlePanel.setBounds(0 ,0, 1200, 60);
		
		// 현재 시간 출력
		JLabel clock = new DigitalClock();
		clock.setBounds(375, 10, 400, 30);
		titlePanel.add(clock);
		
		add(titlePanel);
	
		
		
		RefundFrame refundFrame = new RefundFrame(this);
		RefundButton refundButton = new RefundButton(this, refundFrame);
		OutputButton outfutButton = new OutputButton();
		
		// 영수증 목록 (Panel)
		add(new List(outfutButton, refundButton).scroll);
		
		// 버튼
		add(refundButton);
		add(outfutButton);
		
		// 영수증 출력 
		add(new PrintScroll());
		
		// 돌아가기 버튼
		ReceiptCheckEscapeButton escapeBtn = new ReceiptCheckEscapeButton(this);
		escapeBtn.setLocation(75, 670);
		add(escapeBtn);
		
		setTitle("영수증 조회");
		setSize(1200, 800); // 프레임 사이즈
		getContentPane().setBackground(new Color(64, 64, 64)); // 배경색
		setLayout(null); 
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		setVisible(true); // 보이게
		setDefaultCloseOperation(EXIT_ON_CLOSE);  
	}
	
	public static void main(String[] args) {
		new ReceiptCheckFrame();
	}
	
	
}
