package kiosk.tools;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import kiosk.menupan.Options;

public class GroupButtons {

	String root = "images/KioskImages/4. detailedOption/";
	String rootSelected = "images/KioskImages/4. detailedOption Selected/";
	

	public GroupButtons(JButton a, JButton b, String a1, String b1, int w, int h) {
		
		a.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				a.setIcon(new ImageIcon(readImage(rootSelected + a1 + ".png", w, h)));
				b.setIcon(new ImageIcon(readImage(root + b1 + ".png", w, h)));
			}
		});

		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				b.setIcon(new ImageIcon(readImage(rootSelected + b1 + ".png", w, h)));
				a.setIcon(new ImageIcon(readImage(root + a1 + ".png", w, h)));
			}
		});
	}

	public GroupButtons(JButton a, JButton b, JButton c, String a1, String b1, String c1, int w, int h) {
		
		a.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				a.setIcon(new ImageIcon(readImage(rootSelected + a1 + ".png", w, h)));
				b.setIcon(new ImageIcon(readImage(root + b1 + ".png", w, h)));
				c.setIcon(new ImageIcon(readImage(root + c1 + ".png", w, h)));
			}
		});

		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				b.setIcon(new ImageIcon(readImage(rootSelected + b1 + ".png", w, h)));
				a.setIcon(new ImageIcon(readImage(root + a1 + ".png", w, h)));
				c.setIcon(new ImageIcon(readImage(root + c1 + ".png", w, h)));
			}
		});
		
		c.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				c.setIcon(new ImageIcon(readImage(rootSelected + c1 + ".png", w, h)));
				a.setIcon(new ImageIcon(readImage(root + a1 + ".png", w, h)));
				b.setIcon(new ImageIcon(readImage(root + b1 + ".png", w, h)));
			}
		});
		
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
