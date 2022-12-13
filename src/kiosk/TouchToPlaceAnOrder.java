package kiosk;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TouchToPlaceAnOrder extends JFrame {

	String root = "images/KioskImages/2_1. touchScreen";

	public TouchToPlaceAnOrder() {
		add(makeLabel("hy.png", 53, 23, 60, 83));
		add(makeButton("home.png", 543, 43, 52, 52));
		add(makeLabel("touchScreen.png", 38, 752, 573, 83));
		add(makeButton("poster2.png", 0, 0, 650, 920));

		setLayout(null);
		setSize(650, 950);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);

	}

	public JButton makeButton(String detailedRoot, int x, int y, int w, int h) {
		JButton bt = new JButton();

		bt.setIcon(new ImageIcon(readImage(root + "/" + detailedRoot, w, h)));
		bt.setBounds(x, y, w, h);
		bt.setBorderPainted(false);
		bt.setContentAreaFilled(false);
		bt.setPressedIcon(new ImageIcon(readImage(root + " Selected/" + detailedRoot, w, h)));

		return bt;
	}

	public JLabel makeLabel(String detailedRoot, int x, int y, int w, int h) {
		JLabel lb = new JLabel();

		lb.setIcon(new ImageIcon(readImage(root + "/" + detailedRoot, w, h)));
		lb.setBounds(x, y, w, h);

		return lb;
	}

	public Image readImage(String root, int w, int h) {

		BufferedImage image;
		Image scaled = null;
		try {
			image = ImageIO.read(new File(root));
			scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return scaled;
	}

	public static void main(String[] args) {
		new TouchToPlaceAnOrder();

	}
}
