package kiosk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
		this.i = i + 1;

		setIcon(new ImageIcon(wi.readImage(root + "/" + i + ".png", 96, 71)));
		setBounds(x, y, 96, 71);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setPressedIcon(new ImageIcon(wi.readImage(root + " Selected/" + i + ".png", 96, 71)));
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (i == 11) {
			ta.append("0");
		} else if (i == 10 || i == 12) {
			ta.append("");
		} else {
			ta.append("" + i);
		}

		int len = ta.getText().length();

		if (i == 12) {
			if (len > 0) {
				String text = ta.getText().substring(0, len - 1);
				ta.setText(text);
			}
		}

	}

}
