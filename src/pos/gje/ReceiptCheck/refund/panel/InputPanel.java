package pos.gje.ReceiptCheck.refund.panel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import pos.ImageScaledTool;

public class InputPanel extends JPanel{
	Image image = ImageScaledTool.getScaledImage(
			"images/PosImages/영수증 조회 이미지/카드번호 & 현금 영수증 입력 란.png", 272, 48);

	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(image, 0, 0, d.width, d.height, null);
	}	
	
	public InputPanel(){
		setBounds(25, 370, 272, 48); // Panel 틀
	}	     

	
}
