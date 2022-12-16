package pos.gje.ReceiptCheck.refund;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import pos.WithImage;

public class RefundFrame extends JFrame {

	String root = "images/PosImages/영수증 조회 이미지/";
	WithImage wi = new WithImage(root);

	Timer timer;

	public RefundFrame() {

		JButton exit = wi.makeButton("환불 창 닫기 버튼", 725, 20, 43, 46);

		JButton checkBox = wi.makeButton("체크박스", 215, 394, 27, 27);
		JLabel check = wi.makeLabel("체크", 222, 388, 24, 24);
		JButton confirm = wi.makeButton("확인", 493, 371, 85, 74);
		confirm.setLayout(null);
		confirm.setHorizontalTextPosition(JButton.CENTER);
		confirm.setVerticalTextPosition(JButton.BOTTOM);
		confirm.setOpaque(true);

		check.setVisible(false);

		checkBox.addActionListener(new ActionListener() {
			int num = 1;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (num == 0) {
					num = 1;
					check.setVisible(false);
				} else if (num == 1) {
					num = 0;
					check.setVisible(true);
				}
			}
		});

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		confirm.addActionListener(new ActionListener() {
			JLabel lb = wi.makeLabel("카드를 꽂아주세요", 0, 0, 401, 255);
			// 정보 확인 후 꺼져야됨
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame inputCard = new JFrame();
				inputCard.setUndecorated(true);
				inputCard.add(lb);
				inputCard.setSize(401, 255);
				inputCard.setVisible(true);
				inputCard.setLocationRelativeTo(null);

				timer = new Timer(3000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						lb = wi.makeLabel("환불 완료", 0, 0, 401, 255);
						inputCard.add(lb);
//						inputCard.dispose(); //카드 넣고 환불 완료 창 띄워기
					}
				});
				timer.start();
			}
		});

		add(exit);
		add(wi.makeLabel("상단바", 0, 0, 800, 550));
		add(wi.makeLabel("목록", 218, 143, 88, 157));
		add(wi.makeLabel("선", 218, 184, 363, 1));
		add(wi.makeLabel("영수증 출력 여부", 254, 402, 109, 14));
		add(check);
		add(checkBox);
		add(confirm);

		getContentPane().setBackground(Color.WHITE); // 배경색
		setSize(800, 550); // 프레임 사이즈
		setUndecorated(true); // 타이틀바 없애기
		setLayout(null);
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		setVisible(true);

	}

	public static void main(String[] args) {
		new RefundFrame();

	}
}
