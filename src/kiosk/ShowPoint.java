package kiosk;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import kiosk.tools.WithImage;

public class ShowPoint extends JFrame {

	String root = "images/KioskImages/5_2. step1 point";
	WithImage wi = new WithImage(root);

	JButton ok;

	public ShowPoint(String phonenum, int point, int totalpoint) {
		// 고객 번호
		JLabel phoneNum = new JLabel(phonenum);
		phoneNum.setFont(new Font("맑은 고딕", Font.BOLD, 36));
		phoneNum.setForeground(Color.black);
		phoneNum.setBounds(55, 122, 85, 32);
		add(phoneNum);

		// 적립 포인트
		JLabel savePoint = new JLabel("" + point);
		savePoint.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		savePoint.setForeground(Color.BLACK);
		savePoint.setBounds(22, 301, 100, 21);
		savePoint.setHorizontalTextPosition(JLabel.CENTER);
		savePoint.setHorizontalAlignment(SwingConstants.RIGHT);
		add(savePoint);

		// 누적 포인트
		JLabel currentPoint = new JLabel("" + totalpoint);
		currentPoint.setFont(new Font("맑은 고딕", Font.BOLD, 33));
		currentPoint.setForeground(new Color(15, 11, 65));
		currentPoint.setBounds(110, 448, 100, 28);
		currentPoint.setHorizontalAlignment(SwingConstants.RIGHT);
		add(currentPoint);

		// 고정 값 ----------------------------------------------------
		add(wi.makeLabel("nim.png", 145, 125, 37, 34));
		add(wi.makeLabel("pointText.png", 213, 450, 88, 28));
		add(wi.makeLabel("saveAfter.png", 131, 401, 200, 21));
		add(wi.makeLabel("saveSoon.png", 125, 302, 241, 21));
		add(wi.makeLabel("box.png", 74, 374, 314, 130));

		JButton cancel = wi.makeButton("dispose.png", 182, 570, 96, 49);
		add(cancel);
		this.ok = cancel;

		setLayout(null);
		setSize(461, 710); // 창 크기 이상해서 임시로 늘림
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void hello() {
		add(wi.makeLabel("hello.png", 60, 172, 278, 50));
	}

	public void joinComplete() {
		add(wi.makeLabel("joinComplete.png", 57, 173, 340, 30));
	}

	public static void main(String[] args) {
		new ShowPoint("1333", 2, 1);
	}
}
