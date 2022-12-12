package pos.calculation.button;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NonCoffeeMenu extends JPanel {

	
	public NonCoffeeMenu() {
		
		
		JButton btn1 = new JButton("테스트");
		JButton btn2 = new JButton("논커피");
		JButton btn3 = new JButton("논커피입니다.");
		
		setLayout(new GridLayout(3, 4));
		setBounds(570, 250, 600, 250);
	}
}
