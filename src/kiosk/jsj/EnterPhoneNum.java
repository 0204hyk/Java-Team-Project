package kiosk.jsj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EnterPhoneNum extends JFrame {

	String root = "KioskImages/5_1. step1 InputPhone/";

	public EnterPhoneNum() {

		add(makeLabel("frame.png", 23, 23, 400, 631));
		add(makeLabel("InputText.png", 125, 80, 197, 29));
//		add(makeLabel("phoneFrame.png", 79, 125, 286, 60));
		add(makeLabel("010.png", 104, 147, 49, 16));
		add(makeLabel("cancel.png", 66, 545, 149, 71));
		add(makeLabel("confirm.png", 229, 545, 149, 71));
        // 번호 입력하는 곳
		JLabel[] pf = phoneFields(); add(pf[0]); add(pf[1]);
		// 키패드
		int x = 66, y = 213;
		for (int i = 0; i < 12; i++) {
			add(makeLabel(i + ".png", x, y, 96, 71));
			x += 108;
			if (i == 2 || i == 5 || i == 8) {
				x = 66;
				y += 80;
			}
		}
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

	public JLabel[] phoneFields() {
		JLabel[] phoneField = new JLabel[2];

		phoneField[0] = phoneNumBackGround(170, 140);
		JTextField tf1 = new JTextField();
		tf1.setOpaque(true);
		tf1.setBackground(new Color(241, 242, 242));
		tf1.setBorder(null);
		tf1.setBounds(10, 2, 65, 24);
		tf1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		tf1.setForeground(Color.BLACK);
		
		phoneField[0].setLayout(null);
		phoneField[0].add(tf1);

		phoneField[1] = phoneNumBackGround(269, 140);
		JTextField tf2 = new JTextField();
		tf2.setOpaque(true);
		tf2.setBackground(new Color(241, 242, 242));
		tf2.setBorder(null);
		tf2.setBounds(10, 2, 65, 24);
		tf2.setFont(new Font("맑은 고딕", Font.PLAIN, 21));
		phoneField[1].setLayout(null);
		phoneField[1].add(tf2);

		return phoneField;

	}

	public JLabel phoneNumBackGround(int x, int y) {

		JLabel pn = new JLabel();

		String imageRoot = "KioskImages/5_1. step1 InputPhone/numField.png";
		int w = 83;
		int h = 30;

		pn.setIcon(new ImageIcon((readImage(imageRoot, w, h))));
		pn.setBounds(x, y, w, h);

		return pn;

	}
	
	public static void main(String[] args) {
		new EnterPhoneNum();

	}
}
