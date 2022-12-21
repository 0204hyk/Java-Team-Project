package kiosk.byoption;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TotalAmounts extends JLabel {
	public TotalAmounts() {

		super("7600원");

		setFont(new Font("맑은 고딕", Font.BOLD, 27));
		setForeground(Color.black);
		setBounds(475, 749, 98, 30);
	}
}
