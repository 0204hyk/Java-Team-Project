package pos.gje.ReceiptCheck.refund.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import pos.ImageScaledTool;

public class ReceiveAndChangePanel extends JPanel{	
	Image image = ImageScaledTool.getScaledImage(
			"images/PosImages/영수증 조회 이미지/현금 결제 시 기입란 (직접 입력).png", 350, 109);

	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(image, 0, 0, d.width, d.height, null);
	}	
	
	public ReceiveAndChangePanel() {
		setBounds(25, 250, 350, 109); // Panel 틀
	}	
}
