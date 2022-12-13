package pos.gje.ReceiptCheck.refund;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import pos.gje.ReceiptCheck.receiptcheck_main.ReceiptCheckFrame;
import pos.gje.ReceiptCheck.refund.component.CheckButton;
import pos.gje.ReceiptCheck.refund.component.InputButton;
import pos.gje.ReceiptCheck.refund.component.NumberPadButton;
import pos.gje.ReceiptCheck.refund.component.RefundCloseButton;
import pos.gje.ReceiptCheck.refund.panel.InputPanel;
import pos.gje.ReceiptCheck.refund.panel.PaymentTypePanel;
import pos.gje.ReceiptCheck.refund.panel.ReceiptPanel;
import pos.gje.ReceiptCheck.refund.panel.ReceiveAndChangePanel;
import pos.gje.ReceiptCheck.refund.panel.TitlePanel;

public class RefundFrame extends JFrame{
	private Image background = new ImageIcon("images/PosImages/영수증 조회 이미지/환불 결제 고정 틀.png").getImage();//배경이미지
	ReceiptCheckFrame f;
	public RefundFrame(ReceiptCheckFrame f) {
		this.f = f;
		
		getContentPane().setBackground(Color.WHITE); // 배경색
		setSize(800, 550); // 프레임 사이즈
		setUndecorated(true); // 타이틀바 없애기
		setLayout(null); 
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		
		add(new RefundCloseButton(f, this));
		add(new TitlePanel()); // 타이틀바
		add(new PaymentTypePanel()); // 결제방식
		add(new ReceiveAndChangePanel());  // 받은 돈 거스름 돈
		add(new InputPanel()); // 입력창
		add(new InputButton()); 
		add(new ReceiptPanel()); // 영수증 체크
		add(new CheckButton()); 
		
		
		for (int i = 0; i < 16; ++i) {
			add(new NumberPadButton(i + 1));
		}

	}
	
}
