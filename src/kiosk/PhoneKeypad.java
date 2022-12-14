package kiosk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import kiosk.tools.WithImage;

public class PhoneKeypad extends JButton implements ActionListener {

	int i;
	JTextArea ta;
	String root = "images/KioskImages/5_1. step1 InputPhone";

	WithImage wi = new WithImage(root);

	public PhoneKeypad(int i, JTextArea ta, int x, int y) {
		this.ta = ta;
		this.i = i;
		
		wi.makeButton(i + ".png", x, y, 96, 71);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(i);
		ta.append("" + i);
	}

}
