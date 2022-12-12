package pos.calculation.menubutton;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FrappeBlendedMenu extends JPanel {

	public FrappeBlendedMenu() {
		
		JButton[] coffeeBtns = new JButton[13];
		for (int i = 1; i <= 12; ++i) {
			add(coffeeBtns[i] = new JButton());	
		}
		coffeeBtns[1].setText("버블팝 프라페");
		coffeeBtns[2].setText("민트초코 프라페");
		coffeeBtns[3].setText("피스타치오 아몬드 프라페");

	
		setLayout(new GridLayout(3, 4));
		setBounds(570, 250, 600, 280);
		
	}
	
}
