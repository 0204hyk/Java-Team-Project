package kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import kiosk.cardPut.CardPutFrame;
import kiosk.paymentComplete.PaymentCompleteFrame;
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

	static String member_phonenumber;
	Step1_EnterPhoneNum ep;

	public Step1Step2() {

		labels();
		buttons();

		setLayout(null);
		setSize(650, 950);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
	}

	public void saved() {
		// 이게 뭐지?
		String root = "images/KioskImages/5. step1 Selected";
		WithImage wi = new WithImage(root);
		join.setVisible(false);
		save.setEnabled(false);
		notsave.setEnabled(false);
		add(wi.makeLabel("join.png", 417, 248, 158, 141));
	}

	public void buttons() {
		JButton home = wi.makeButton("home.png", 542, 44, 52, 52);

		// 포인트 적립
		save = wi.makeButton("save.png", 73, 248, 158, 141);
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ep = new Step1_EnterPhoneNum();
				ep.add(wi.makeLabel("confirmPoint.png", 187, 42, 70, 20));
				ep.showPoint(); // 끝나면 나머지 두개 비활성화 시키기

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
		card = wi.makeButton("card.png", 73, 519, 158, 141);
		card.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame cp = new CardPutFrame();
				// 시간이 좀 지나면 자동으로 결제 완료

				timer = new Timer(3000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						cp.dispose();
						new PaymentCompleteFrame();
						timer.stop();
						// 적립 업데이트 해주기
					}
				});
				timer.start();
			}
		});

		// 포인트 사용
		point = wi.makeButton("point.png", 245, 519, 158, 141);
		point.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new UsePoint(Step1Step2.getMemberPhone());
				} catch (NullPointerException e1) {
					// 번호입력창 띄우기
					new Step2_PointWithNoID();
				}
			}
		});

		// 결제하기
		JButton pay = wi.makeButton("pay.png", 324, 771, 192, 67);
		pay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 결제 창으로 넘어가기
			}
		});

		// 취소
		JButton cancel = wi.makeButton("cancel.png", 113, 771, 192, 67);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 장바구니가 유지된 첫 화면으로 돌아가야 됨
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

		JLabel step1 = new JLabel("Step1. 적립");
		step1.setBounds(52, 208, 150, 30);
		step1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		add(step1);

		JLabel step2 = new JLabel("Step2. 결제 방식");
		step2.setBounds(52, 478, 150, 30);
		step2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		add(step2);

		String root = "images/KioskImages/5. step1 Selected";
		WithImage wi = new WithImage(root);

		saveActive = wi.makeLabel("save.png", 73, 248, 158, 141);
		joinActive = wi.makeLabel("join.png", 417, 248, 158, 141);
		cardActive = wi.makeLabel("card.png", 73, 519, 158, 141);
		pointActive = wi.makeLabel("point.png", 245, 519, 158, 141);
		
		setVisibleEnabled(saveActive);
		setVisibleEnabled(joinActive);
		setVisibleEnabled(cardActive);
		setVisibleEnabled(pointActive);
	}

	public void enabled(JButton bt) {
		// 받은 버튼을 제외한 버튼을 비활성화

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

	public static void main(String[] args) {
		new Step1Step2();

	}
}
