package pos.product_management.menu04_delete.message_frame;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class OkPanel extends JPanel {

	
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("images/PosImages/상품 관리 이미지/삭제 완료 멘트 안내 창.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
	public OkPanel() {
		setBounds(0, 0, 400, 200); // Panel 틀
		setLayout(null); 
	}	     
}
