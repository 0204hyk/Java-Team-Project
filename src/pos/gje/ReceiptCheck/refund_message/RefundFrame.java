package pos.gje.ReceiptCheck.refund_message;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import pos.gje.ReceiptCheck.refund_message.component.CheckButton;
import pos.gje.ReceiptCheck.refund_message.component.InputButton;
import pos.gje.ReceiptCheck.refund_message.component.NumberPadButton;
import pos.gje.ReceiptCheck.refund_message.component.RefundCloseButton;
import pos.gje.ReceiptCheck.refund_message.panel.InputPanel;
import pos.gje.ReceiptCheck.refund_message.panel.PaymentTypePanel;
import pos.gje.ReceiptCheck.refund_message.panel.ReceiptPanel;
import pos.gje.ReceiptCheck.refund_message.panel.ReceiveAndChangePanel;
import pos.gje.ReceiptCheck.refund_message.panel.TitlePanel;

public class RefundFrame extends JFrame{
	private Image background = new ImageIcon("images/PosImages/영수증 조회 이미지/환불 결제 고정 틀.png").getImage();//배경이미지
	
	public RefundFrame() {	
						
		getContentPane().setBackground(Color.WHITE); // 배경색
		setSize(800, 550); // 프레임 사이즈
		setUndecorated(true); // 타이틀바 없애기
		setLayout(null); 
		setVisible(true); 
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		
		add(new RefundCloseButton(this));
		add(new TitlePanel()); // 타이틀바
		add(new PaymentTypePanel()); // 결제방식
		add(new ReceiveAndChangePanel());  // 받은 돈 거스름 돈
		add(new InputPanel()); // 입력창
		add(new InputButton()); // 입력 버튼
		add(new ReceiptPanel()); // 영수증 체크
		add(new CheckButton()); // 체크 버튼 
		
		
		for (int i = 0; i < 16; ++i) {
			add(new NumberPadButton(i + 1));
		}	

	}
	
}
