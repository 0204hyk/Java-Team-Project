package kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import database.kiosk.CheckPhoneNum;
import database.kiosk.CheckPoint;
import database.kiosk.SavePoint;
import kiosk.tools.WithImage;

public class Step1_EnterPhoneNum extends JFrame {

	String root = "images/KioskImages/5_1. step1 Inputphone";
	WithImage wi = new WithImage(root);

	public Step1_EnterPhoneNum() {

		add(wi.makeLabel("InputText.png", 125, 95, 197, 29));
		add(wi.makeLabel("010.png", 133, 147, 46, 21));

		// 번호 입력하는 곳
		JTextArea tf = new JTextArea();
		tf.setOpaque(true);
		tf.setBackground(Color.WHITE);
		tf.setBorder(null);
		tf.setBounds(181, 136, 131, 33);
		tf.setFont(new Font("맑은 고딕", Font.BOLD, 28));
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

		// 휴대폰 번호 찾음 -> 적립 예정 포인트 보여주기
		// 휴대폰 번호 없음 -> 없다고 하기

		JButton confirm = wi.makeButton("confirm.png", 229, 545, 149, 71);
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String ph = "010" + tf.getText();
				int point = 100;
				int currentPoint = new CheckPoint(ph).currentPoint();

				if (Pattern.matches("01[016-9]\\d{4}\\d{4}", ph)) {
					// 회원정보 정상적으로 확인
					if (new CheckPhoneNum(ph).check()) {

					} else {
						JFrame jf = new JFrame();
						String root = "images/KioskImages/5_1. step1 없는 회원";
						WithImage wi = new WithImage(root);

						jf.add(wi.makeLabel("text.png", 38, 51, 237, 19));
						JButton close = wi.makeButton("close.png", 247, 138, 89, 38);
						close.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								tf.setText("");
								jf.dispose();
							}
						});
						jf.add(close);

						jf.setUndecorated(true);
						jf.setLayout(null);
						jf.setSize(379, 213);
						jf.setLocationRelativeTo(null);
						jf.getContentPane().setBackground(new Color(250, 250, 250));
						jf.setVisible(true);
					}

				} else {
					// 번호가 이상할때

				}
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
		new Step1_EnterPhoneNum();

	}
}
