package pos.calculation.menubutton;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TeaAdeMenu extends JPanel {

	public TeaAdeMenu() {
		
		JButton[] teaAdeBtns = new JButton[12];
		for (int i = 0; i < 12; ++i) {
			teaAdeBtns[i] = new JButton("");
			teaAdeBtns[i].setBackground(Color.white);
			add(teaAdeBtns[i]);
		}
		
		teaAdeBtns[0].setText("인크레드불 화이트");
		

		setLayout(new GridLayout(3, 4));
		setVisible(true);
		setBounds(570, 250, 600, 280);
		
	}
}
