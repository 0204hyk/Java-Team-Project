package pos.kjh;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class NotSelectedJPenel extends JPanel {

	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("images/PosImages/상품 관리 이미지/삭제 메뉴 선택하지 않을 때 창.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
	public NotSelectedJPenel() {
		setSize(400, 200);
		setVisible(true);
	}	
	
	
}

