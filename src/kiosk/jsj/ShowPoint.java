package kiosk.jsj;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ShowPoint extends JFrame {

	String root = "KioskImages/5_2. step1 point/";

	public ShowPoint() {
		add(makeLabel("frame.png", 23, 23, 400, 631));
		add(makeLabel("nim.png", 146, 125, 25, 32));
		add(makeLabel("hello.png", 60, 172, 278, 50));
		add(makeLabel("pointText.png", 213, 490, 88, 28));
		add(makeLabel("saveAfter.png", 131, 441, 200, 21));
		add(makeLabel("saveSoon.png", 125, 342, 241, 21));
		add(makeLabel("box.png", 74, 414, 314, 130));

		setLayout(null);
		setSize(461, 710); // 창 크기 이상해서 임시로 늘림
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
	}

	public JLabel makeLabel(String detailedRoot, int x, int y, int w, int h) {
		JLabel lb = new JLabel();

		lb.setIcon(new ImageIcon(readImage(root + detailedRoot, w, h)));
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
		new ShowPoint();
	}
}
