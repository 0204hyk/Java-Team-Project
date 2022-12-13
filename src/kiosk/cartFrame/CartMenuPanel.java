package kiosk.cartFrame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class CartMenuPanel extends JPanel{

	JPanel menuPanel = new JPanel();
	/*static JPanel menuPanel = new JPanel() {
		
		Image image = new ImageIcon
				("images/KioskImages/7_주문정보_확인/cartMainPanelScaled.png").getImage();
		public void paint(Graphics g) {
			g.drawImage(image,0,0,null);
		
		}
	};*/
	
	public CartMenuPanel() {
		panelComponents();
		setDisplay();
	}
	
	public void setDisplay() {
		setLayout(new GridLayout(1,5,0,0));
		setBounds(80,240, 490, 370);
		setBackground(Color.white);
		setOpaque(false);
		
	}
	
	
	public void panelComponents() {
		CartMainPanelComponet compo = new CartMainPanelComponet();
		menuPanel.setLayout(new FlowLayout(0, 15, 10));
		menuPanel.setBackground(Color.white);
		menuPanel.setOpaque(false);
		
		
		menuPanel.add(compo.number());
		menuPanel.add(compo.menu());
		menuPanel.add(compo.option());
		add(menuPanel);
	}
	
	
}
