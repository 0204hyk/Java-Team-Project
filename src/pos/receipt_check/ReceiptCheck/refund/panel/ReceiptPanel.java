package pos.receipt_check.ReceiptCheck.refund.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import pos.ImageScaledTool;

public class ReceiptPanel extends JPanel{
	Image image = ImageScaledTool.getScaledImage(
			"images/PosImages/영수증 조회 이미지/영수증 출력 여부 체크 멘트.png", 294, 48);

	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(image, 0, 0, d.width, d.height, null);
	}	
	
	public ReceiptPanel() {
		setBounds(81, 430, 294, 48); // Panel 틀
	}	     

}
