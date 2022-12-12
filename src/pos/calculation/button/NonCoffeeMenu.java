package pos.calculation.button;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NonCoffeeMenu extends JPanel {

	
	public NonCoffeeMenu() {

		
		JButton[] nonCoffeeBtns = new JButton[13];
		for (int i = 1; i <= 12; ++i) {
			add(nonCoffeeBtns[i] = new JButton());	
		}
		nonCoffeeBtns[1].setText("초코라떼");
		nonCoffeeBtns[2].setText("고구마라떼");
		
		
		setVisible(false);
		setLayout(new GridLayout(3, 4));
		setBounds(570, 250, 600, 280);
	}
}
