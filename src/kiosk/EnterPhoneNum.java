package kiosk;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JTextArea;

import kiosk.tools.WithImage;

public class EnterPhoneNum extends JFrame {

	String root = "images/KioskImages/5_1. step1 InputPhone";
	WithImage wi = new WithImage(root);

	public EnterPhoneNum() {

		add(wi.makeLabel("frame.png", 23, 23, 400, 631));
		add(wi.makeLabel("InputText.png", 125, 80, 197, 29));
		add(wi.makeLabel("010.png", 104, 147, 49, 16));

		// 번호 입력하는 곳
		JTextArea tf = new JTextArea();
		tf.setOpaque(true);
		tf.setBackground(new Color(241, 242, 242));
		tf.setBorder(null);
		tf.setBounds(170, 140, 150, 35);
		tf.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		tf.setForeground(Color.BLACK);
		add(tf);

		// 키패드
		int x = 66, y = 213;
		JTextArea ta = tf;
		for (int i = 0; i < 12; i++) {
			add(new PhoneKeypad(i, ta, x, y));
			x += 108;
			if (i == 2 || i == 5 || i == 8) {
				x = 66;
				y += 80;

			}
		}
		
		JButton cancel = wi.makeButton("cancel.png", 66, 545, 149, 71);
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		JButton confirm = wi.makeButton("confirm.png", 229, 545, 149, 71);
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 유효한 번호인지 확인하고 db로 넘기기
				System.out.println(tf.getText());
				
			}
		});
		

		add(cancel);
		add(confirm);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);
		setSize(460, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);

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
		new EnterPhoneNum();

	}
}
