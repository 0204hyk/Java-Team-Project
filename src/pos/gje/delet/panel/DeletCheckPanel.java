package pos.gje.delet.panel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DeletCheckPanel extends JPanel{

	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("images/PosImages/상품 관리 이미지/메뉴 삭제 전 안내 멘트 창.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
	public DeletCheckPanel() {
		setBounds(0, 0, 500, 250); // Panel 틀
		setLayout(null); 
	}	     
}
