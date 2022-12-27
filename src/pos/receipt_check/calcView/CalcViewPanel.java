package pos.receipt_check.calcView;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import pos.receipt_check.calcView.component.MenuListButton;
import pos.receipt_check.calcView.component.PriceLabel;
import pos.receipt_check.calcView.component.QuantityLabel;

public class CalcViewPanel extends JPanel {
		
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("images/PosImages/계산 파트 이미지/주문 메뉴 리스트.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
	public CalcViewPanel() {
		
		setBounds(30, 110, 500, 375); // Panel 틀
		
		add(new MenuListButton());
		add(new QuantityLabel());
		add(new PriceLabel());
		
		setLayout(null); 
	}	   
}
