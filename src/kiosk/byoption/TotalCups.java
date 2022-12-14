package kiosk.byoption;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TotalCups extends JLabel {
	public TotalCups() {
		super("2잔");
		setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		setForeground(Color.black);
		setBounds(356, 755, 33, 20);
	}
}
