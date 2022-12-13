package pos.gje.modify.panel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pos.gje.modify.ModifyButton;

public class CheckPanel extends JPanel{
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("images/PosImages/상품 관리 이미지/수정 완료 안내 멘트 창.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
	public CheckPanel() {
		//add(new ModifyButton().okBtn(f));
		setBounds(0, 0, 400, 200); // Panel 틀
		setLayout(null); 
	}	     
}
