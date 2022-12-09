package kiosk.cartFrame;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CartNorth_SouthPanel extends JPanel {
	Font font = new Font("맑은 고딕", Font.BOLD, 27);

	public CartNorth_SouthPanel() {
		mainLabel();
	}

	
	public void mainLabel() {
		JLabel label = new JLabel();
		
		label.setFont(font);
		label.setText("주문 정보를 확인해주세요.");
		label.setBounds(210, 250, 300, 150);
		add(label);
		
	}
	
}

