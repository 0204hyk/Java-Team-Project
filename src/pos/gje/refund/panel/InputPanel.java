package pos.gje.refund.panel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class InputPanel extends JPanel{

	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("PosImages/영수증 조회 이미지/카드번호 & 현금 영수증 입력 란.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
	public InputPanel() {
		setBounds(25, 370, 272, 48); // Panel 틀
	}	     

	
}
