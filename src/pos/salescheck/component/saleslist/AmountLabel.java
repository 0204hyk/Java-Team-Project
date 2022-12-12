package pos.salescheck.component.saleslist;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class AmountLabel extends JLabel {

	public AmountLabel() {
		
		setText("5,482,100원");
		setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		setBounds(850, 410, 500, 500);
		
	}
}
