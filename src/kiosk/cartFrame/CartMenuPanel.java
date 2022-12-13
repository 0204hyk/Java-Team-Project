package kiosk.cartFrame;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class CartMenuPanel extends JPanel{

	JPanel menuPanel = new JPanel();
	
	public CartMenuPanel() {
		panelComponents();
		setDisplay();
	}
	
	public void setDisplay() {
		setLayout(new GridLayout(1,5,0,0));
		setBounds(80,240, 490, 370);
		
	}
	
	
	public void panelComponents() {
		CartMainPanelComponet compo = new CartMainPanelComponet();
		menuPanel.setLayout(new FlowLayout(0, 10, 10));
		
		menuPanel.add(compo.number());
		menuPanel.add(compo.menu());
		menuPanel.add(compo.option());
		add(menuPanel);
	}
	
	
}
