package kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import database.kiosk.CheckPoint;
import kiosk.tools.WithImage;

public class UsePoint extends JFrame {

	String root = "images/KioskImages/5_4. step2 usePoint";
	WithImage wi = new WithImage(root);

	public UsePoint(String phonenumber) {

		CheckPoint cp = new CheckPoint(Step1Step2.getMemberPhone());

		JLabel phoneNum = new JLabel(phonenumber.substring(7, phonenumber.length()));
		phoneNum.setFont(new Font("맑은 고딕", Font.BOLD, 36));
		phoneNum.setForeground(Color.black);
		phoneNum.setBounds(32, 65, 86, 32);

		JLabel currentPoint = new JLabel(cp.currentPoint()+"포인트");
		currentPoint.setHorizontalAlignment(JLabel.CENTER);
		currentPoint.setFont(new Font("맑은 고딕", Font.BOLD, 34));
		currentPoint.setForeground(new Color(15, 11, 65));
		currentPoint.setBounds(0, 260, 461, 35);

		JTextArea ta = new JTextArea();
		ta.setBackground(new Color(242, 242, 242));
		ta.setBorder(null);
		ta.setBounds(185, 370, 80, 30);
		ta.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		ta.setForeground(Color.BLACK);

		add(wi.makeLabel("leftPointText.png", 33, 67, 335, 83));
		add(wi.makeLabel("usePointBox.png", 171, 368, 105, 46));

		JButton use = wi.makeButton("use.png", 290, 368, 97, 46);

		use.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt(ta.getText()) > cp.currentPoint()) {
					System.out.println("갖고 있는 포인트보다 적게 입력해주세요"); // 빨간 글씨로 띄워주기
				} else {
					dispose();
					System.out.println("통과");
					Step1Step2.pointActive();
				}

			}
		});

//		add(wi.makeLabel("pointText.png", 205, 264, 90, 28));
		JLabel check = wi.makeLabel("check.png", 61, 366, 28, 27);

		check.setVisible(false);

		JButton checkBox = wi.makeButton("checkBox.png", 64, 384, 84, 15);
		checkBox.addActionListener(new ActionListener() {
			int num = 1;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (num == 0) {
					num = 1;
					check.setVisible(false);
					ta.setText("");
				} else if (num == 1) {
					num = 0;
					check.setVisible(true);
					ta.setText("" + cp.currentPoint());
					ta.setVisible(true);
					ta.paint(ta.getGraphics());
				}

			}
		});

		int x = 57, y = 439;
		for (int i = 0; i < 12; i++) {
			add(new PhoneKeypad(root, i, ta, x, y, 106, 42));
			x += 113;
			if (i == 2 || i == 5 || i == 8) {
				x = 57;
				y += 49;
			}
		}

		add(currentPoint);
		add(phoneNum);
		add(use);
		add(check);
		add(checkBox);
		add(wi.makeLabel("currentPointText.png", 163, 215, 121, 22));
		add(wi.makeLabel("currentPointBox.png", 64, 188, 320, 132));
		add(ta);

		setLayout(null);
		setSize(461, 710); // 창 크기 이상해서 임시로 늘림
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}
public static void main(String[] args) {
	new UsePoint("01042361724");
}
}
