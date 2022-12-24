package kiosk;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import kiosk.cartFrame.CartMainFrame;
import kiosk.tools.WithImage;

public class Step1Step2 extends JFrame {

	static String root = "images/KioskImages/5. step1";
	static WithImage wi = new WithImage(root);
	static JButton save;
	static JButton notsave;
	static JButton join;
	static JButton card;
	static JButton point;
	static JLabel saveActive;
	static JLabel joinActive;
	static JLabel cardActive;
	static JLabel pointActive;
	Timer timer;

	public static int payMethod = 1;
	int totalPoint;
	
	static String member_phonenumber;
	Step1_EnterPhoneNum ep;
	ArrayList<String> menuInfo = new ArrayList<>();

	// 총 금액의 10% 받아옴
	public Step1Step2(int point, ArrayList menuInfo) {
		this.menuInfo = menuInfo;

		totalPoint = point;
		labels();
		buttons();

		setLayout(null);
		setSize(650, 950);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
	}

	public void buttons() {
		JButton home = wi.makeButton("home.png", 542, 44, 52, 52);

		// 포인트 적립
		save = wi.makeButton("save.png", 88, 248, 158, 141);
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ep = new Step1_EnterPhoneNum(totalPoint);
				ep.add(wi.makeLabel("confirmPoint.png", 187, 42, 70, 20));
				ep.showPoint();
				

			}
		});

		// 간편 가입
		join = wi.makeButton("join.png", 420, 248, 158, 141);
		join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ep = new Step1_EnterPhoneNum(totalPoint);
				ep.add(wi.makeLabel("joinText.png", 193, 42, 58, 20));
				ep.simpleJoin();
			}
		});

		// 포인트 적립 안함
		notsave = wi.makeButton("notsave.png", 254, 248, 158, 141);
		notsave.addActionListener(new ActionListener() {
			int num = 1;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (num == 0) {
					notsave.setIcon(new ImageIcon(wi.readImage(root + "/notsave.png", 158, 141)));
					save.setEnabled(true);
					join.setEnabled(true);
					step2Disabled();
					num = 1;

				} else if (num == 1) {
					notsave.setIcon(new ImageIcon(wi.readImage(root + " Selected/notsave.png", 158, 141)));
					save.setEnabled(false);
					join.setEnabled(false);
					step2Abled();
					num = 0;

				}
			}
		});

		// 카드 사용
		card = wi.makeButton("card.png", 89, 519, 158, 141);
		card.addActionListener(new ActionListener() {
			int num = 1;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (num == 0) {
					cardActive.setVisible(false);
					card.setVisible(true);
					point.setEnabled(true);
					num = 1;
				} else if (num == 1) {
					cardActive.setVisible(true);
					point.setEnabled(false);
					num = 0;

				}

			}
		});


		// 포인트 사용
		point = wi.makeButton("point.png", 254, 519, 158, 141);
		point.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new UsePoint(Step1Step2.getMemberPhone());
					
				} catch (NullPointerException e1) {
					// 번호입력창 띄우기
					Step2_PointWithNoID sp = new Step2_PointWithNoID();
					sp.add(wi.makeLabel("confirmPoint.png", 187, 42, 70, 20));
				}
			}
		});

		// 결제하기
		JButton pay = wi.makeButton("pay.png", 324, 771, 192, 67);
		pay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CartMainFrame(menuInfo, totalPoint, Step1Step2.getMemberPhone(), payMethod);
				dispose();
				// 결제 창으로 넘어가기
			}
		});

		// 취소
		JButton cancel = wi.makeButton("cancel.png", 113, 771, 192, 67);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 장바구니가 유지된 첫 화면으로 돌아가야 됨
				dispose();
			}
		});

		step2Disabled();
		add(home);
		add(save);
		add(notsave);
		add(join);
		add(card);
		add(point);
		add(pay);
		add(cancel);
	}

	public void labels() {

		add(wi.makeLabel("hy.png", 52, 25, 60, 83));

		add(wi.makeLabel("step1.png", 89, 201, 240, 22));
		add(wi.makeLabel("step2.png", 89, 473, 119, 22));

		String root = "images/KioskImages/5. step1 Selected";
		WithImage wi = new WithImage(root);

		saveActive = wi.makeLabel("save.png", 88, 248, 158, 141);
		joinActive = wi.makeLabel("join.png", 420, 248, 158, 141);
		cardActive = wi.makeLabel("card.png", 89, 519, 158, 141);
		pointActive = wi.makeLabel("point.png", 254, 519, 158, 141);

		setVisibleEnabled(saveActive);
		setVisibleEnabled(joinActive);
		setVisibleEnabled(cardActive);
		setVisibleEnabled(pointActive);
	}

	public void setVisibleEnabled(JLabel lb) {
		add(lb);
		lb.setVisible(false);

	}

	public static void completeUsingPoint() {
		save.setVisible(false);
		saveActive.setVisible(true);
		notsave.setEnabled(false);
		join.setEnabled(false);
		step2Abled();

	}

	public static void completeJoin() {
		save.setEnabled(false);
		notsave.setEnabled(false);
		join.setVisible(false);
		joinActive.setVisible(true);
		step2Abled();

	}

	public void cardActive() {
		card.setVisible(false);
		cardActive.setVisible(true);
	}

	public static void pointActive() {
		point.setVisible(false);
		pointActive.setVisible(true);
	}

	public void step2Disabled() {
		card.setEnabled(false);
		point.setEnabled(false);

	}

	public static void step2Abled() {
		card.setEnabled(true);
		point.setEnabled(true);

	}

	public static void setMemberPhone(String phonenumber) {
		member_phonenumber = phonenumber;
	}

	public static String getMemberPhone() {
		return member_phonenumber;
	}
	
	public void setUsingOnlyPoint() {
		payMethod = 3;
	}
	
	public static void setUsingPoint() {
		payMethod = 2;
	}
	public int getPayMethod() {
		return payMethod;
	}
	
	
	public static void main(String[] args) {
	}
}
