package pos.gje.refund.panel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PaymentTypePanel extends JPanel{
	
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("PosImages/영수증 조회 이미지/결제 방식에 따른 환불 금액 표시란.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
	public PaymentTypePanel() {
		setBounds(25, 80, 350, 162); // Panel 틀
	}	     

}
