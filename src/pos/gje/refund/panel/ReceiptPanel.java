package pos.gje.refund.panel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ReceiptPanel extends JPanel{
	
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("images/PosImages/영수증 조회 이미지/영수증 출력 여부 체크 멘트.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
	public ReceiptPanel() {
		setBounds(81, 430, 294, 48); // Panel 틀
	}	     

}
