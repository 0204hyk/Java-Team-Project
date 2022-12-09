package pos.gje.refund;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class RefundFrame extends JFrame{
	private Image background = new ImageIcon("PosImages/영수증 조회 이미지/환불 결제 고정 틀.png").getImage();//배경이미지
	
	public RefundFrame() {
		refundFrame();
	}
	
	public void refundFrame() {
		JFrame f = new JFrame();
		
		f.add(new PaymentTypePanel());
		f.add(new ReceiveAndChangePanel());
		
		f.getContentPane().setBackground(Color.white); // 배경색
		f.setSize(800, 700); // 프레임 사이즈
		f.setLayout(null); 
		f.setVisible(true); 
		f.setResizable(false); // 크기 조절 안되게
		f.setLocationRelativeTo(null); // 가운데에 뜨게
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}

	public void paint(Graphics g) {//그리는 함수
		g.drawImage(background, 0, 0, null);//background를 그려줌
	}
	
	public static void main(String[] args) {
		new RefundFrame();
	}
}
