package kiosk.tools;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class WithImage {

	String root = "";

	public WithImage(String root) {

		this.root = root;
	}

	public JLabel makeLabel(String detailedRoot, int x, int y, int w, int h) {
		JLabel lb = new JLabel();

		lb.setIcon(new ImageIcon(readImage(root + "/" + detailedRoot, w, h)));
		lb.setBounds(x, y, w, h);

		return lb;
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
}
