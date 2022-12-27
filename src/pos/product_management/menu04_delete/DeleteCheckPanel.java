package pos.product_management.menu04_delete;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pos.product_management.menu01_main.component.MenuListJTable;
import pos.util.ImageScaledTool;

public class DeleteCheckPanel extends JPanel{
	
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon(
				ImageScaledTool.getScaledImage("images/PosImages/상품 관리 이미지/메뉴 삭제 전 안내 멘트 창2.png", 500, 250));
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
	public JLabel deleteMenu() {
		
		JLabel menuName = new JLabel();

		menuName.setText("[" + MenuListJTable.menuName + "]");
		menuName.setHorizontalAlignment(JLabel.CENTER);
		menuName.setLocation(75, 40);
		menuName.setSize(350, 50);
		
		menuName.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		return menuName;
	}

	
	public DeleteCheckPanel() {
		add(deleteMenu());
		setBounds(0, 0, 500, 250); // Panel 틀
		setLayout(null); 
	}	     
}
