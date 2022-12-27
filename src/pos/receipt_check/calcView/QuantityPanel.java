package pos.receipt_check.calcView;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class QuantityPanel extends JPanel{
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("images/PosImages/계산 파트 이미지/주문 메뉴 주문 수량.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
	public QuantityPanel() {
		setBounds(30, 518, 500, 103); // Panel 틀
		setLayout(null); 
	}	     
}
