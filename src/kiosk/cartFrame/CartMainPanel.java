package kiosk.cartFrame;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;


public class CartMainPanel extends JPanel {
	
	public CartMainPanel() {
		panelSetting();
	}

	//북쪽 패널 세팅(메뉴, 홈버튼)
	public void panelSetting() {
		
		setLayout(null);
		setBackground(Color.white);
		
		addComponent();
	}
	
	//추가된 컴포넌트 모음
	public void addComponent() {
		
		CartComponent compo = new CartComponent();
		
		add(compo.logo());
		add(compo.homeButton());
		
		add(compo.priceLabel());
		add(compo.price());
		
		add(compo.pointLabel());
		add(compo.point());
		
		add(compo.totalPriceLabel());
		add(compo.totalPrice());
		
		
		add(new CartMenuPanel());
		add(new CartMainPanelComponet().imageLabel());
	}
	
}
