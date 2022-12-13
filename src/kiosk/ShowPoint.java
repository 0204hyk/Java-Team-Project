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

public class ShowPoint extends JFrame {

	String root = "images/KioskImages/5_2. step1 point/";

	public ShowPoint() {
		// 고객 번호
		JLabel phoneNum = new JLabel("1724"); // 고객 휴대폰 번호 입력 - 나중에 get으로 가져오기
		phoneNum.setFont(new Font("맑은 고딕", Font.BOLD, 36));
		phoneNum.setForeground(Color.black);
		phoneNum.setBounds(55, 122, 85, 32);
		add(phoneNum);

		// 적립 포인트
		JLabel savePoint = new JLabel("112"); // 네자리면 위치가 바뀌어야하는데..
		savePoint.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		savePoint.setForeground(Color.BLACK);
		savePoint.setBounds(84,341,40,21);
		savePoint.setHorizontalTextPosition(JLabel.CENTER);
		add(savePoint);

		// 누적 포인트
		JLabel currentPoint = new JLabel("395"); // 네자리면 위치가 바뀌어야하는데..
		currentPoint.setFont(new Font("맑은 고딕", Font.BOLD, 33));
		currentPoint.setForeground(new Color(63, 186, 145));
		currentPoint.setBounds(152, 489, 60, 28);
//		currentPoint.setHorizontalTextPosition(JLabel.CENTER);
		add(currentPoint);

		
		// 고정 값 ----------------------------------------------------
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
		new ShowPoint();
	}
}
