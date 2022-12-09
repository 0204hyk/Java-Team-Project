package kiosk.cartFrame;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class CartNorthPanel extends JPanel {
	
	public CartNorthPanel() {
		panelSetting();
	}

	//북쪽 패널 세팅(메뉴, 홈버튼)
	public void panelSetting() {
		
		setLayout(new GridLayout(0,1));
		
		add(new CartNorth_NorthPanel());
		add(new CartNorth_SouthPanel());
		
		}
	
}
