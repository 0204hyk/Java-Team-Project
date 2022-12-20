package kiosk.byoption;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TotalCups extends JLabel {

	public static int cup = 1;

	public TotalCups() {
		setText(cup+"잔");
		setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		setForeground(Color.black);
		setHorizontalAlignment(JLabel.CENTER);
		setBounds(462, 170, 60, 30);
	}


}
