package kiosk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Agreement extends JFrame {

	String root = "images/KioskImages/5_3. step1 Agreement";

	public Agreement() {
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
		scrollablePane.setBounds(52, 77, 347, 390);
		scrollablePane.setBackground(null);
		scrollablePane.setBorder(null);
		scrollablePane.setHorizontalScrollBar(null);
		scrollablePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		add(scrollablePane); // 휠 스크롤이 안됨

		add(makeLabel("frame.png", 30, 30, 400, 631));
		add(makeLabel("agreementText.png", 118, 505, 263, 21));
		add(makeButton("checkBox.png", 82, 502, 26, 26));
		add(makeLabel("check.png", 79, 476, 43, 42));
		add(makeButton("cancel.png", 95,573,127,60));
		add(makeButton("join.png", 237, 573, 127, 60));

		setUndecorated(true);
		setSize(460, 700);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public JLabel makeLabel(String detailedRoot, int x, int y, int w, int h) {
		JLabel lb = new JLabel();

		lb.setIcon(new ImageIcon(readImage(root + "/" + detailedRoot, w, h)));
		lb.setBounds(x, y, w, h);

		return lb;
	}

	public JButton makeButton(String detailedRoot, int x, int y, int w, int h) {
		JButton bt = new JButton();

		bt.setIcon(new ImageIcon(readImage(root + "/" + detailedRoot, w, h)));
		bt.setBounds(x, y, w, h);
		bt.setBorderPainted(false);
		bt.setContentAreaFilled(false);
		bt.setPressedIcon(new ImageIcon(readImage(root + " Selected/" + detailedRoot, w, h)));
		return bt;
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
		new Agreement();
	}

}