package kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import kiosk.tools.WithImage;

public class Step1 extends JFrame {

	String root = "images/KioskImages/5. step1";
	WithImage wi = new WithImage(root);
	JButton save;
	JButton notsave;
	JButton join;
	static String member_phonenumber;
	Step1_EnterPhoneNum ep;

	public Step1() {

		// 포인트 적립
		save = wi.makeButton("save.png", 73, 248, 158, 141);
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ep = new Step1_EnterPhoneNum(); // 대조
				ep.add(wi.makeLabel("confirmPoint.png", 187, 42, 70, 20));

			}
		});

		// 간편 가입
		join = wi.makeButton("join.png", 417, 248, 158, 141);

		join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ep = new Step1_EnterPhoneNum();
				ep.add(wi.makeLabel("joinText.png", 193, 42, 58, 20));
				ep.simpleJoin();
			}
		});

		// 포인트 적립 안함
		notsave = wi.makeButton("notsave.png", 245, 248, 158, 141);

		notsave.addActionListener(new ActionListener() {
			int num = 1;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (num == 0) {
					notsave.setIcon(new ImageIcon(wi.readImage(root + "/notsave.png", 158, 141)));
					num = 1;
					save.setEnabled(true);
					join.setEnabled(true);

				} else if (num == 1) {
					notsave.setIcon(new ImageIcon(wi.readImage(root + " Selected/notsave.png", 158, 141)));
					save.setEnabled(false);
					join.setEnabled(false);
					num = 0;
				}
			}
		});

		add(save);
		add(notsave);
		add(join);

		add(wi.makeLabel("hy.png", 52, 25, 60, 83));
		add(wi.makeButton("home.png", 542, 44, 52, 52));

		JLabel step1 = new JLabel("Step1. 적립");
		step1.setBounds(52, 208, 150, 30);
		step1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		add(step1);

		add(wi.makeLabel("card.png", 73, 519, 158, 141));
		add(wi.makeLabel("point.png", 245, 519, 158, 141));

		JLabel step2 = new JLabel("Step2. 결제 방식");
		step2.setBounds(52, 478, 150, 30);
		step2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		add(step2);

		JButton pay = wi.makeButton("pay.png", 324, 771, 192, 67);
		pay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Step2();
			}
		});

		JButton cancel = wi.makeButton("cancel.png", 113, 771, 192, 67);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 장바구니가 유지된 첫 화면으로 돌아가야 됨
			}
		});

		add(pay);
		add(cancel);

		setLayout(null);
		setSize(650, 950);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
	}

	public void saved() {
		String root = "images/KioskImages/5. step1 Selected";
		WithImage wi = new WithImage(root);
		join.setVisible(false);
		save.setEnabled(false);
		notsave.setEnabled(false);
		add(wi.makeLabel("join.png", 417, 248, 158, 141));
	}

	public static void setMemberPhone(String phonenumber) {
		member_phonenumber = phonenumber;
	}

	public static String getMemberPhone() {
		return member_phonenumber;
	}

	public static void main(String[] args) {
		new Step1();

	}
}
