package kiosk.jsj;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EnterPhoneNum extends JFrame {

	public EnterPhoneNum() {

		add(phoneInputText()); //폰 번호 입력 텍스트
		add(frame()).setLocation(23, 23); // 전체 테두리
		add(phoneWholeFrame()); // 폰번호 테두리
		add(ooneo()); // 010-
		JLabel[] pf = phoneFields(); // 폰 번호 적는 곳
		add(pf[0]);
		add(pf[1]);

		// 키패드
		String root = "KioskImages/5_1. step1 InputPhone/";
		int x = 66, y = 223;
		for (int i = 0; i < 12; i++) {
			JButton bt = keypad(root + i + ".png");
			bt.setLocation(x, y);
			x += 108;
			add(bt);
			if (i == 2 || i == 5 || i == 8) {
				x = 66;
				y += 80;
			}
		}

		// 취소버튼
		add(cancel());
		
		// 확인버튼
		
		add(confirm());
		setVisible(true);
		setSize(461, 710); // 창 크기 이상해서 임시로 늘림
		setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);


	}
	
	
	
	public JLabel phoneInputText() {
		JLabel lb = new JLabel();
		
		String imageRoot = "KioskImages/5_1. step1 InputPhone/InputText.png";
		int x = 125;
		int y = 80;
		int w = 197;
		int h = 29;

		lb.setIcon(new ImageIcon((readImage(imageRoot, w, h))));
		lb.setBounds(x, y, w, h);
		
		
		return lb;
		
	}

	public JLabel[] phoneFields() {
		JLabel[] phoneField = new JLabel[2];

		phoneField[0] = phoneNumBackGround(170, 140); // 배경 이미지 입힘
		JTextField tf1 = new JTextField();
		tf1.setBackground(null);
		tf1.setBorder(null);
		phoneField[0].add(tf1);

		phoneField[1] = phoneNumBackGround(269, 140);
		JTextField tf2 = new JTextField();
		tf2.setBackground(null);
		tf2.setBorder(null);
		phoneField[1].add(tf2);

		return phoneField;

	}

	public JLabel cancel() {
		JLabel lb = new JLabel();

		String imageRoot = "KioskImages/5_1. step1 InputPhone/cancel.png";
		int x = 66;
		int y = 545;
		int w = 149;
		int h = 71;

		lb.setIcon(new ImageIcon((readImage(imageRoot, w, h))));
		lb.setBounds(x, y, w, h);

		return lb;
	}

	public JLabel confirm() {
		JLabel lb = new JLabel();

		String imageRoot = "KioskImages/5_1. step1 InputPhone/confirm.png";
		int x = 229;
		int y = 545;
		int w = 149;
		int h = 71;

		lb.setIcon(new ImageIcon((readImage(imageRoot, w, h))));
		lb.setBounds(x, y, w, h);

		return lb;
	}

	public JLabel phoneWholeFrame() {

		String imageRoot = "KioskImages/5_1. step1 InputPhone/phoneFrame.png";
		int w = 286;
		int h = 60;
		int x = 79;
		int y = 125;
		JLabel phoneFrame = new JLabel();
		phoneFrame.setIcon(new ImageIcon((readImage(imageRoot, w, h))));
		phoneFrame.setBounds(x, y, w, h);

		return phoneFrame;
	}

	public JLabel ooneo() {

		String imageRoot = "KioskImages/5_1. step1 InputPhone/010.png";
		int w = 59;
		int h = 24;
		int x = 103;
		int y = 143;
		JLabel phoneFrame = new JLabel();
		phoneFrame.setIcon(new ImageIcon((readImage(imageRoot, w, h))));
		phoneFrame.setBounds(x, y, w, h);

		return phoneFrame;
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

	public JLabel frame() {

		JLabel frame = new JLabel();
		try {
			BufferedImage image = ImageIO.read(new File("KioskImages/5_1. step1 InputPhone/frame.png"));
			Image scaled = image.getScaledInstance(400, 631, Image.SCALE_SMOOTH);
			frame.setIcon(new ImageIcon(scaled));
			frame.setSize(400, 631);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return frame;
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
