package pos.calculation.menubutton;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pos.calculation.CalculationMain;

public class CoffeeMenu extends JPanel {


	
	public CoffeeMenu() {
	
		JButton[] coffeeBtns = new JButton[12];
		for (int i = 0; i < 12; ++i) {
			coffeeBtns[i] = new JButton("");
			add(coffeeBtns[i]);
		}
		
		
		coffeeBtns[0].setText("아메리카노");
		coffeeBtns[1].setText("꿀커피");
		coffeeBtns[2].setText("카페라떼");
		coffeeBtns[3].setText("꿀라떼");
		coffeeBtns[4].setText("바닐라라떼");
		
		
		
		setLayout(new GridLayout(3, 4));
		setVisible(true);
		setBounds(570, 250, 600, 280);

	}


	
	


}
