package pos.product_management.menu03_modify.message_frame;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ModifyWarningPanel extends JPanel{

	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("images/PosImages/상품 관리 이미지/메뉴 선택 경고창.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
	public ModifyWarningPanel() {
		setBounds(0, 0, 400, 200); // Panel 틀
		setLayout(null); 
	}	     
}
