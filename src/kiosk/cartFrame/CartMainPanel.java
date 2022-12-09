package kiosk.cartFrame;

import java.awt.Color;

import javax.swing.JPanel;


public class CartMainPanel extends JPanel {
	
	CartComponent compo = new CartComponent();
	
	public CartMainPanel() {
		panelSetting();
	}

	//북쪽 패널 세팅(메뉴, 홈버튼)
	public void panelSetting() {
		
		setLayout(null);
		add(compo.logo());
		add(compo.homeButton());
		add(compo.mainLabel());
		setBackground(Color.white);
		
		}
	
}
