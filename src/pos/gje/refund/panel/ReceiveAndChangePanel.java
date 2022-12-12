package pos.gje.refund.panel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ReceiveAndChangePanel extends JPanel{
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("PosImages/영수증 조회 이미지/현금 결제 시 기입란 (직접 입력).png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
	public ReceiveAndChangePanel() {
		setBounds(25, 250, 350, 109); // Panel 틀
	}	
}
