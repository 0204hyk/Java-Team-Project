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

	JButton dispose;
	
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
		currentPoint.setForeground(new Color(63, 186, 145));
		currentPoint.setBounds(110, 448, 100, 28);
		currentPoint.setHorizontalAlignment(SwingConstants.RIGHT);
		add(currentPoint);

		// 고정 값 ----------------------------------------------------
		add(wi.makeLabel("nim.png", 146, 125, 25, 32));

		add(wi.makeLabel("pointText.png", 213, 450, 88, 28));
		add(wi.makeLabel("saveAfter.png", 131, 401, 200, 21));
		add(wi.makeLabel("saveSoon.png", 125, 302, 241, 21));
		add(wi.makeLabel("box.png", 74, 374, 314, 130));
		JButton dispose = wi.makeButton("dispose.png", 182,570,96,49);
		add(dispose);
		this.dispose = dispose;

		setLayout(null);
		setSize(461, 710); // 창 크기 이상해서 임시로 늘림
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public JButton disposeBt() {
		
		return dispose;
	}

	public void hello() {
		add(wi.makeLabel("hello.png", 60, 172, 278, 50));
	}

	public void welcome() {
		add(wi.makeLabel("welcome.png", 60, 172, 278, 50));
	}

	public static void main(String[] args) {
		new ShowPoint("4235", 90, 5000);
	}
}
