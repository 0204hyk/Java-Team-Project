package pos.calculation.menubutton;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NonCoffeeMenu extends JPanel {

	
	public NonCoffeeMenu() {

		
		JButton[] nonCoffeeBtns = new JButton[12];
		for (int i = 0; i < 12; ++i) {
			nonCoffeeBtns[i] = new JButton("");
			nonCoffeeBtns[i].setBackground(Color.WHITE);
			add(nonCoffeeBtns[i]);	
		
		}

		nonCoffeeBtns[0].setText("초코라떼");
		nonCoffeeBtns[0].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
				
			}
		});
		nonCoffeeBtns[1].setText("고구마라떼");
		
		
		setBorder(null);
		setLayout(new GridLayout(3, 4));
		setVisible(true);
		setBounds(570, 250, 600, 280);
	}
}
