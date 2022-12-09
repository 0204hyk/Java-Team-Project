package pos.gje.ReceiptCheck;

import java.awt.Color;

import javax.swing.JFrame;

import pos.gje.ReceiptCheck.panel.ReceiptListPanel;
import pos.gje.refund.PaymentTypePanel;
import pos.gje.refund.ReceiveAndChangePanel;

public class ReceiptCheckFrame extends JFrame{

	public ReceiptCheckFrame() {}
	
//	public static void refundFrame() {
//		JFrame f = new JFrame();
//		
//		f.add(new PaymentTypePanel());
//		f.add(new ReceiveAndChangePanel());
//		
//		f.getContentPane().setBackground(Color.white); // 배경색
//		f.setSize(800, 700); // 프레임 사이즈
//		f.setLayout(null); 
//		f.setVisible(true); 
//		f.setResizable(false); // 크기 조절 안되게
//		f.setLocationRelativeTo(null); // 가운데에 뜨게
//		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
//	}
	
	
	public static void mainFrame() {
		JFrame f = new JFrame("POS");
		
		// 영수증 목록 (Panel)
		f.add(new ReceiptListPanel());
		
		// 버튼 
		f.add(new ReceiptCheckButton().refundBtn());
		f.add(new ReceiptCheckButton().outfutBtn());
		
		// 영수증 출력 
		f.add(new ReceiptCheckTextArea());
		
		f.getContentPane().setBackground(new Color(64, 64, 64)); // 배경색
		f.setSize(1200, 800); // 프레임 사이즈
		f.setLayout(null); 
		f.setVisible(true); 
		f.setResizable(false); // 크기 조절 안되게
		f.setLocationRelativeTo(null); // 가운데에 뜨게
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE); 
		
	}
	
	public static void main(String[] args) {
		new ReceiptCheckFrame().mainFrame();
	}
	
}
