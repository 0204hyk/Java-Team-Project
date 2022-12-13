package kiosk;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import kiosk.menuFrame.MenuFrame;

public class TouchToPlaceAnOrder extends JFrame {

	String root = "images/KioskImages/2_1. touchScreen";
	JButton pic;
	Timer tm;
	int x = 0;

	String[] list = { root + "/poster1.png", root + "/poster2.png", root + "/poster3.png", root + "/poster4.png",
			root + "/poster5.png" };

	public TouchToPlaceAnOrder() {
		
		add(makeLabel("hy.png", 53, 23, 60, 83));
		add(makeButton("home.png", 543, 43, 52, 52));
		add(makeLabel("touchScreen.png", 38, 752, 573, 83));

		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);

		pic = new JButton();
		pic.setBounds(0, 0, 650, 920);

		SetImageSize(4);

		tm = new Timer(3000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SetImageSize(x);
				x += 1;
				if (x >= list.length)
					x = 0;
			}
		});

		pic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuFrame();
				
			}
		});
		
		pic.setBorderPainted(false);
		pic.setContentAreaFilled(false);
		
		add(pic);
		tm.start();
		
		setLayout(null);
		setSize(650, 950);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void SetImageSize(int i) {
		ImageIcon icon = new ImageIcon(list[i]);
		Image newImg = icon.getImage().getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);
		pic.setIcon(newImc);
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
