package pos.gje.modify.panel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {

	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("images/PosImages/상품 관리 이미지/메뉴 수정 타이틀바.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
	public TitlePanel() {
		//add(new RefundButton().closeBtn());
		setBounds(0, 0, 800, 63); // Panel 틀
		setLayout(null); 
	}	     
}
