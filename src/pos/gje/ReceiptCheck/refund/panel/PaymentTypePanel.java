package pos.gje.ReceiptCheck.refund.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import pos.ImageScaledTool;

public class PaymentTypePanel extends JPanel{
	Image image = ImageScaledTool.getScaledImage(
			"images/PosImages/영수증 조회 이미지/결제 방식에 따른 환불 금액 표시란.png", 350, 162);

	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(image, 0, 0, d.width, d.height, null);
	}	
	
	public PaymentTypePanel() {
		setBounds(25, 80, 350, 162); // Panel 틀
	}	     

}
