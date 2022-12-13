package pos.gje.refund;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import pos.gje.refund.panel.InputPanel;
import pos.gje.refund.panel.PaymentTypePanel;
import pos.gje.refund.panel.ReceiptPanel;
import pos.gje.refund.panel.ReceiveAndChangePanel;
import pos.gje.refund.panel.TitlePanel;

public class RefundFrame extends JFrame{
	private Image background = new ImageIcon("PosImages/영수증 조회 이미지/환불 결제 고정 틀.png").getImage();//배경이미지
	
	public RefundFrame() {
		refundFrame();
	}
	
	public void refundFrame() {
		JFrame f = new JFrame();
		
		add(f);
		
		f.getContentPane().setBackground(Color.WHITE); // 배경색
		f.setSize(800, 550); // 프레임 사이즈
		f.setUndecorated(true); // 타이틀바 없애기
		f.setLayout(null); 
		f.setVisible(true); 
		f.setResizable(false); // 크기 조절 안되게
		f.setLocationRelativeTo(null); // 가운데에 뜨게
		f.setDefaultCloseOperation(f.HIDE_ON_CLOSE);
	
	
	}

	public static void add(JFrame f) {
		f.add(new RefundButton().closeBtn(f)); // 닫기 버튼 
		f.add(new TitlePanel()); // 타이틀바
		f.add(new PaymentTypePanel()); // 결제방식
		f.add(new ReceiveAndChangePanel());  // 받은 돈 거스름 돈
		f.add(new InputPanel()); // 입력창
		f.add(new RefundButton().inputBtn()); // 입력 버튼
		f.add(new ReceiptPanel()); // 영수증 체크
		f.add(new RefundButton().checkBtn()); // 체크 버튼 
		
		
		for (int i = 0; i < 16; ++i) {
			f.add(new RefundButton().numberPad(i + 1));
			
		}
		
	}
	
	public static void main(String[] args) {
		new RefundFrame();
	}
}
