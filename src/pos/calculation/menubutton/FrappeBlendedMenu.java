package pos.calculation.menubutton;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FrappeBlendedMenu extends JPanel {

	 
	
	public FrappeBlendedMenu() {
		
		JButton[] frappeBlendedBtns = new JButton[12];
		for (int i = 0; i < 12; ++i) {
			frappeBlendedBtns[i] = new JButton("");
			frappeBlendedBtns[i].setBackground(Color.white);
			add(frappeBlendedBtns[i]);
		}
		
		
		frappeBlendedBtns[0].setText("버블팝 프라페");
		frappeBlendedBtns[1].setText("민트초코 프라페");
		frappeBlendedBtns[2].setText("피스타치오 아몬드 프라페");

	
		setLayout(new GridLayout(3, 4));
		setVisible(true);
		setBounds(570, 250, 600, 280);
		
	}
	
}
