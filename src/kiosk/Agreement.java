package kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import database.kiosk.JoinMembership;
import kiosk.tools.WithImage;

public class Agreement extends JFrame {

	String root = "images/KioskImages/5_3. step1 Agreement";
	WithImage wi = new WithImage(root);
	int num = 1;

	public Agreement(String ph, int point, int currentPoint) {
		JTextArea agreement = new JTextArea(
				"[개인정보 수집·이용 동의]\r\n" + "①개인정보의 수집·이용목적\r\n\n" + "포인트 적립, 회원 관리\r\n" + "\r\n" + "②수집하려는 개인정보의 항목\r\n"
						+ "전화번호\r\n" + "\r\n" + "③개인정보의 보유 및 이용기간(근거법률)\r\n" + "10년\r\n" + "\r\n" + "거래기록\r\n"
						+ "5년(전자상거래 등에서의 소비자 보호에 관한\n 법률)\r\n" + "\r\n" + "④동의를 거부할 수 있으며, 동의 거부시 \n서비스가 제공되지 않습니다.\r\n"
						+ "※ 위 개인정보 수집이용에 동의하십니까?\r\n" + "\r\n\n" + "[개인정보 제3자 제공에 대한 별도 동의]\r\n\n"
						+ "① 개인정보를 제공받는 자 : Hy 본사\r\n" + "② 개인정보를 제공받는 자의 개인정보 이용\n 목적 : 고객 관리 및 포인트 관리\r\n"
						+ "③ 제공하는 개인정보의 항목 : 성명, 전화번호,\n생년월일\r\n" + "④ 개인정보를 제공받는 자의 개인정보 보유 및 이용 기간 : 제공 후 1년\r\n"
						+ "⑤ 동의를 거부할 수 있으며, 동의 거부시\nH서비스가 제공되지 않습니다.\r\n" + "※ 위 고유식별정보 수집이용에 동의하십니까?\r\n");

		agreement.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		agreement.setEditable(false);
		JScrollPane scrollablePane = new JScrollPane();
		scrollablePane.setViewportView(agreement);
		scrollablePane.setBounds(52, 78, 347, 390);
		scrollablePane.setBackground(null);
		scrollablePane.setBorder(null);
		scrollablePane.setHorizontalScrollBar(null);
		scrollablePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		add(scrollablePane); // 휠 스크롤이 안됨

		add(wi.makeLabel("agreementText.png", 118, 505, 263, 21));

		JButton cancel = wi.makeButton("cancel.png", 192, 583, 98, 49);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton join = wi.makeButton("join.png", 302, 583, 96, 49);
		join.setEnabled(false);
		join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new JoinMembership(ph);

				ShowPoint sp = new ShowPoint(ph.substring(7, ph.length()), point, currentPoint + point);
				sp.joinComplete(); // 환영합니다

				// 닫기 버튼
				sp.ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						sp.dispose();
						dispose();
						Step1Step2.setMemberPhone(ph);
						Step1Step2.completeJoin();

					}
				});

			}
		});

		JLabel check = wi.makeLabel("check.png", 85, 494, 31, 29);
		JButton checkBox = wi.makeButton("checkBox.png", 82, 502, 26, 26);
		check.setVisible(false);
		checkBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (num == 0) {
					check.setVisible(false);
					join.setEnabled(false);
					num = 1;
				} else if (num == 1) {
					check.setVisible(true);
					join.setEnabled(true);
					num = 0;
				}
			}
		});

		add(check);
		add(checkBox);
		add(cancel);
		add(join);

		setUndecorated(true);
		setSize(460, 700);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	public static void main(String[] args) {
		new Agreement("01042361724", 23,329);
		
	}
}
