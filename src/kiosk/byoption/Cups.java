package kiosk.byoption;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Cups extends JLabel {

	public int cup = 1;

	public Cups() {
		
		setText(cup + "잔");
		setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		setForeground(Color.black);
		setHorizontalAlignment(JLabel.CENTER);
		setBounds(462, 170, 60, 30);
	}

	public void minus() {
		cup--;
	}

	public void plus() {
		cup++;
	}

	public int getCup() {
		return cup;
	}

	public void setCup(int cup) {
		this.cup = cup;
	}

}
