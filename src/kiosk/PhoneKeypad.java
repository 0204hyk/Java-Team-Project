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
	String root;

	WithImage wi = new WithImage(root);

	public PhoneKeypad(String root, int i, JTextArea ta, int x, int y, int w, int h) {
		this.root = root;
		this.ta = ta;
		this.i = i + 1;

		setIcon(new ImageIcon(wi.readImage(root + "/" + i + ".png", w, h)));
		setBounds(x, y, w, h);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setPressedIcon(new ImageIcon(wi.readImage(root + " Selected/" + i + ".png", w, h)));
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
