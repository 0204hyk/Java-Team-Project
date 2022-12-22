package kiosk.byoption;

import java.awt.Color;
import java.awt.Font;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import database.kiosk.GetImage;
import kiosk.tools.WithImage;

public class TopImage extends JPanel {
	String root = "images/KioskImages/menu/coffee/";
	WithImage wi = new WithImage(root);

	String image = "";
	public TopImage(String menu) {

		menu = "에스프레소";
		add(wi.setMenuImage(menu)); // 커피 사진
		
		GetImage gi = new GetImage(menu);
		System.out.println(gi.getImageName());
		

		JLabel nameKor = new JLabel("카페 라떼"); // 커피 이름 한글
		nameKor.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		nameKor.setForeground(Color.BLACK);
		nameKor.setBounds(96, 13, 108, 30);
		nameKor.setHorizontalAlignment(SwingConstants.LEFT);
		add(nameKor);

		JLabel nameEng = new JLabel("Cafe Latte"); // 커피 이름 영문
		nameEng.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		nameEng.setForeground(new Color(151, 159, 156));
		nameEng.setBounds(98, 47, 64, 15);
		nameEng.setHorizontalAlignment(SwingConstants.LEFT);
		add(nameEng);

		JLabel totalAmounts = new JLabel("4000원"); // 총 금액
		totalAmounts.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		totalAmounts.setForeground(new Color(15, 11, 65));
		totalAmounts.setBounds(99, 72, 75, 22);
		totalAmounts.setHorizontalAlignment(SwingConstants.LEFT);
		add(totalAmounts);

		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(210, 100, 208, 100);
	}
}
