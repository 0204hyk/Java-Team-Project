package pos.calculation.menubutton;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NonCoffeeMenu extends JPanel {

	
	public NonCoffeeMenu() {

		
		JButton[] nonCoffeeBtns = new JButton[12];
		for (int i = 0; i < 12; ++i) {
			nonCoffeeBtns[i] = new JButton("");
			add(nonCoffeeBtns[i]);	
		
		}
		
		
		
		nonCoffeeBtns[0].setText("초코라떼");
		nonCoffeeBtns[1].setText("고구마라떼");
		
		
		setLayout(new GridLayout(3, 4));
		setVisible(false);
		setBounds(570, 250, 600, 280);
	}
}
