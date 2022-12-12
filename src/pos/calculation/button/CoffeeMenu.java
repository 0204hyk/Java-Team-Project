package pos.calculation.button;


import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CoffeeMenu extends JPanel {


	public CoffeeMenu() {
		

		
		JButton[] coffeeBtns = new JButton[13];
		for (int i = 1; i <= 12; ++i) {
			add(coffeeBtns[i] = new JButton());	
		}
		coffeeBtns[1].setText("아메리카노");
		coffeeBtns[2].setText("꿀커피");
		coffeeBtns[3].setText("카페라떼");
		coffeeBtns[4].setText("꿀라떼");
		coffeeBtns[5].setText("바닐라라떼");
		
	
		setLayout(new GridLayout(3, 4));
		setBounds(570, 250, 600, 280);

	}


}
