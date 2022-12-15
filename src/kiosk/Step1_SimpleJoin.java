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
import database.kiosk.JoinMembership;
import database.kiosk.SavePoint;
import kiosk.tools.WithImage;

public class Step1_SimpleJoin extends JFrame {

	// 메뉴 금액의 10프로 가져와야함

	// 회원가입
	String root = "images/KioskImages/5_1. step1 InputPhone";
	WithImage wi = new WithImage(root);

	public Step1_SimpleJoin() {

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

		JButton confirm = wi.makeButton("confirm.png", 229, 545, 149, 71);
		// 번호가 중복일 경우 -> 그 번호로 포인트 적립 or 아니오
		// 중복이 아닌 경우 -> 회원 가입 완료를 띄우고 그 번호로 포인트 적립

		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String ph = "010" + tf.getText();
				int point = 100;
				int currentPoint = new CheckPoint(ph).currentPoint();

				if (Pattern.matches("01[016-9]\\d{4}\\d{4}", ph)) {
					// 중복인 경우
					if (new CheckPhoneNum(ph).check()) {

						System.out.println("폰 번호 중복입니다");
						WithImage wi = new WithImage("images/KioskImages/5_1_1. step1 번호 중복");
						JFrame jf = new JFrame();

						JButton confirm = wi.makeButton("confirm.png", 247, 138, 89, 38);
						confirm.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								new ShowPoint(ph.substring(7, ph.length()), point, currentPoint + point).hello();
								jf.dispose();

							}
						});

						JButton cancel = wi.makeButton("cancel.png", 148, 138, 89, 38);
						cancel.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								jf.dispose();

							}
						});

						jf.add(confirm);
						jf.add(cancel);
						jf.add(wi.makeLabel("text.png", 38, 51, 281, 44));
						jf.add(wi.makeLabel("background.png", 0, 0, 379, 213));

						jf.setUndecorated(true);
						jf.setLayout(null);
						jf.setSize(379, 213);
						jf.setLocationRelativeTo(null);
						jf.getContentPane().setBackground(new Color(250, 250, 250));
						jf.setVisible(true);

						// 휴대폰 번호가 중복이 아닌 경우 -> 바로 가입 후 포인트 적립
					} else if (!new CheckPhoneNum(ph).check()) {
						System.out.println("중복이 아닙니다");
						new JoinMembership(ph);
						new ShowPoint(ph.substring(7, ph.length()), point, currentPoint + point).welcome();
					}

				} else {
					System.out.println("유효하지 않은 번호");
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
		new Step1_SimpleJoin();

	}
}
