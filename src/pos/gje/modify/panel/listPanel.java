package pos.gje.modify.panel;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class listPanel extends JPanel{

	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("images/PosImages/상품 관리 이미지/메뉴 리스트 기본 틀.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
//	public JTextField modify() {
//		JTextField textNum = new JTextField();
//		
//		
//		return ;
//	}
	
	
	public listPanel() {
		
		
		setBounds(20, 90, 770, 310); // Panel 틀
		setLayout(null); 
	}	     
}
