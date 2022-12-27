package kiosk.cartframe;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class CartMenuPanel extends JPanel{

	JPanel menuPanel = new JPanel();
	
	public CartMenuPanel() {
		panelComponents();
		setDisplay();
	}
	
	//패널설정
	public void setDisplay() {
		setLayout(new GridLayout(1,5,0,0));
		setBounds(80,240, 490, 370);
		setBackground(Color.white);
		setOpaque(false);
		
	}
	
	//컴포넌트 설정
	public void panelComponents() {
		
		menuPanel.setLayout(new FlowLayout(0, 15, 10));
		menuPanel.setBackground(Color.white);
		menuPanel.setOpaque(false);
		
		
		CartMainPanelComponet compo = new CartMainPanelComponet();
		menuPanel.add(compo.number());
		menuPanel.add(compo.menu());
		menuPanel.add(compo.option());
		add(menuPanel);
	}
	
	
}
