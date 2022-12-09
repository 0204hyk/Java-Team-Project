package kiosk.cartFrame;

import java.awt.Color;
import java.awt.Component;

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
		add(compo.priceLabel());
		add(compo.price());
		add(compo.pointLabel());
		add(compo.point());
		add(compo.totalPriceLabel());
		add(compo.totalPrice());
		add(compo.payButton());
		add(compo.cancelButton());
		
		add(new CartMenuPanel());
		setBackground(Color.white);
		
		}
	
}
