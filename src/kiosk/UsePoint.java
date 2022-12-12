package kiosk;

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

public class UsePoint extends JFrame {
	String root = "KioskImages/5_4. step2 usePoint/";

	public UsePoint() {
		JLabel phoneNum = new JLabel("1724"); // 고객 휴대폰 번호 입력 - 나중에 get으로 가져오기
		phoneNum.setFont(new Font("맑은 고딕", Font.BOLD, 36));
		phoneNum.setForeground(Color.black);
		phoneNum.setBounds(32, 65, 86, 32);
		add(phoneNum);

		JLabel currentPoint = new JLabel("395포인트"); //네자리면 위치가 바뀌어야하는데..
		currentPoint.setFont(new Font("맑은 고딕", Font.BOLD, 34));
		currentPoint.setForeground(new Color(63, 186, 145));
		currentPoint.setBounds(150, 264, 200, 35);
		currentPoint.setHorizontalTextPosition(JLabel.CENTER);
		add(currentPoint);

		add(makeLabel("leftPointText.png", 33, 67, 335, 83));
		add(makeLabel("byUnitText.png", 88, 329, 269, 16));
		add(makeLabel("checkBox.png", 63, 399, 14, 14));
		add(makeLabel("useAll.png", 85, 399, 63, 14));
		add(makeLabel("usePointBox.png", 171, 383, 105, 46));
		add(makeLabel("use.png", 303, 383, 84, 46));
		add(makeLabel("check.png", 60, 381, 28, 27)); // 체크 햇다 안했다
		add(makeLabel("currentPointText.png", 163, 214, 121, 22));
		add(makeLabel("currentPointBox.png", 63, 186, 320, 132));

		int x = 57, y = 455;
		for (int i = 0; i < 12; i++) {
			add(makeLabel(i + 1 + ".png", x, y, 106, 42));
			x += 113;
			if (i == 2 || i == 5 || i == 8) {
				x = 57;
				y += 49;
			}
		}

		setLayout(null);
		setSize(461, 710); // 창 크기 이상해서 임시로 늘림
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

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
		new UsePoint();
	}
}
