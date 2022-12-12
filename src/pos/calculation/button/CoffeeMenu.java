package pos.calculation.button;


import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CoffeeMenu extends JPanel {


	public CoffeeMenu() {

		JButton btn1 = new JButton("아메리카노");
		JButton btn2 = new JButton("카푸치노");
		JButton btn3 = new JButton("아인슈페너");

		add(btn1);
		add(btn2);
		add(btn3);
		setLayout(new GridLayout(3, 4));
		setBounds(570, 250, 600, 250);

	}


}
