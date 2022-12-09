package kiosk.jsj;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EnterPhoneNum extends JFrame {

	public EnterPhoneNum() {

		String root = "KioskImages/5_1. step1 InputPhone/";

		int x = 66, y = 223;

		for (int i = 1; i <= 12; ++i) {
			JButton bt = keypad(root + i + ".png");
			bt.setLocation(x, y);
			x += 108;
			if (i == 3 || i == 6 || i == 9) {
				x = 66;
				y += 80;
			}
			add(bt);
		}

		setVisible(true);
		setSize(420, 651);
		setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);

	}

	public JButton keypad(String root) {

		JButton keypad = new JButton();

		try {
			BufferedImage image = ImageIO.read(new File(root));

			Image scaled = image.getScaledInstance(96, 71, Image.SCALE_SMOOTH);
			keypad.setIcon(new ImageIcon(scaled));
			keypad.setSize(96, 71);
			keypad.setBorderPainted(false);
			keypad.setFocusPainted(true);
			keypad.setContentAreaFilled(false);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return keypad;

	}

	public static void main(String[] args) {
		// 테스트용
		new EnterPhoneNum();

	}
}
