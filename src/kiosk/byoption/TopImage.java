package kiosk.byoption;

import java.awt.Color;
import java.awt.Font;
<<<<<<< HEAD
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import database.kiosk.GetImageInfo;
import kiosk.tools.WithImage;

public class TopImage extends JPanel {
	String root = "images/KioskImages/menu/coffee/";
	WithImage wi = new WithImage(root);
	DecimalFormat df = new DecimalFormat("#,###");

	String image = "";

	public TopImage(String menu) {

		// 커피 사진
		GetImageInfo gi = new GetImageInfo(menu);
		add(wi.setMenuImage(gi.getMenuImageRoot()));

		// 커피 이름 한글
		JLabel nameKor = new JLabel(gi.getMenuNameKor());
		nameKor.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		nameKor.setForeground(Color.BLACK);
		nameKor.setBounds(91, 13, 260, 30);
		nameKor.setHorizontalAlignment(SwingConstants.LEFT);
		add(nameKor);

		// 커피 이름 영문
		JLabel nameEng = new JLabel(gi.getMenuNameEng());
		nameEng.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		nameEng.setForeground(new Color(151, 159, 156));
		nameEng.setBounds(93, 40, 230, 20);
		nameEng.setHorizontalAlignment(SwingConstants.LEFT);
		add(nameEng);

		// 커피 금액
		JLabel price = new JLabel("￦" + df.format(gi.getMenuPrice()));
		price.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		price.setForeground(new Color(15, 11, 65));
		price.setBounds(94, 72, 100, 22);
		price.setHorizontalAlignment(SwingConstants.LEFT);
		add(price);

		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(65, 130, 350, 120);
	}

	public static void main(String[] args) {
		new OnlyShotCup_5(new TopImage("초콜릿 쿠키 젤라또 프라페"),"초콜릿 쿠키 젤라또 프라페");
=======

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
>>>>>>> refs/remotes/origin/main
	}
}
