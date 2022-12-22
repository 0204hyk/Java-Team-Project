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
import javax.swing.JLabel;
import javax.swing.JTextArea;

import database.kiosk.CheckPhoneNum;
import database.kiosk.CheckPoint;
import kiosk.tools.WithImage;

public class Step2_PointWithNoID extends JFrame {

	String root = "images/KioskImages/5_1. step1 Inputphone";
	WithImage wi = new WithImage(root);

	String phonenumber;

	public Step2_PointWithNoID() {

		add(wi.makeLabel("phoneNum.png", 71, 94, 87, 14));
		add(wi.makeLabel("010.png", 70, 126, 46, 21));
		JLabel notValidNum = wi.makeLabel("notValidNum.png", 70, 169, 177, 14);
		add(notValidNum);
		notValidNum.setVisible(false);

		// 번호 입력하는 곳
		JTextArea ta = new JTextArea();
		ta.setOpaque(true);
		ta.setBackground(Color.WHITE);
		ta.setBorder(null);
		ta.setBounds(119, 115, 140, 33);
		ta.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		ta.setForeground(Color.BLACK);
		add(ta);

		// 키패드
		int x = 66, y = 213;
		for (int i = 0; i < 12; i++) {
			add(new PhoneKeypad(root, i, ta, x, y, 96, 71));
			x += 108;
			if (i == 2 || i == 5 || i == 8) {
				x = 66;
				y += 80;

			}
		}

		JButton cancel = wi.makeButton("cancel.png", 170, 562, 98, 49);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// 휴대폰 번호 찾음 -> 적립 예정 포인트 보여주기
		// 휴대폰 번호 없음 -> 없다고 하기

		JButton confirm = wi.makeButton("confirm.png", 280, 562, 96, 49);
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String ph = "010" + ta.getText();

				// 유효한 휴대폰 번호인지 확인
				if (Pattern.matches("01[016-9]\\d{4}\\d{4}", ph)) {
					if (new CheckPhoneNum(ph).check()) {
						Step1Step2.setMemberPhone(ph);
						dispose();
						new UsePoint(ph);
					} else {
						// 없다고하기
						JFrame jf = new JFrame();
						String root = "images/KioskImages/5_1. step1 없는 회원";
						WithImage wi = new WithImage(root);

						jf.add(wi.makeLabel("text.png", 38, 51, 237, 19));
						JButton close = wi.makeButton("close.png", 247, 138, 89, 38);
						close.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								ta.setText("");
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
					notValidNum.setVisible(true);

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

	public static void main(String[] args) {

	}
}
