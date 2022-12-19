package pos.gje.delet.panel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pos.kjh.MenuListJTable;

public class DeleteCheckPanel extends JPanel{
	
	
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("images/PosImages/상품 관리 이미지/메뉴 삭제 전 안내 멘트 창2.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
	public JLabel deleteMenu() {
		
		JLabel menuName = new JLabel();

		menuName.setText("[" + MenuListJTable.menuName + "]");
		menuName.setHorizontalAlignment(JLabel.CENTER);
		menuName.setLocation(125, 50);
		menuName.setSize(250, 50);
		
		menuName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		return menuName;
	}
	
//	public JLabel deleteQuantity() {
//		JLabel quantity = new JLabel();
//		
//		quantity.setHorizontalAlignment(JLabel.CENTER);
//		quantity.setText("" + MenuListJTable.quantity);
//		quantity.setLocation(75, 25);
//		quantity.setSize(70, 70);
//		
//		quantity.setFont(new Font("맑은 고딕", Font.BOLD, 25));
//		
//		return quantity;
//	}
	
	public DeleteCheckPanel() {
		//add(deleteQuantity());
		add(deleteMenu());
		setBounds(0, 0, 500, 251); // Panel 틀
		setLayout(null); 
	}	     
}
