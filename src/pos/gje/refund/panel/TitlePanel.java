package pos.gje.refund.panel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import pos.gje.refund.RefundButton;

public class TitlePanel extends JPanel {
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("PosImages/영수증 조회 이미지/타이틀바.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
	public TitlePanel() {
		//add(new RefundButton().closeBtn());
		setBounds(0, 0, 800, 63); // Panel 틀
		setLayout(null); 
	}	     

}
