package kiosk.byoption;

import java.awt.Color;
import java.awt.Font;
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
		nameKor.setBounds(88, 13, 260, 30);
		nameKor.setHorizontalAlignment(SwingConstants.LEFT);
		add(nameKor);

		// 커피 이름 영문
		JLabel nameEng = new JLabel(gi.getMenuNameEng());
		nameEng.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		nameEng.setForeground(new Color(151, 159, 156));
		nameEng.setBounds(90, 40, 230, 20);
		nameEng.setHorizontalAlignment(SwingConstants.LEFT);
		add(nameEng);

		// 커피 금액
		JLabel price = new JLabel("￦" + df.format(gi.getMenuPrice()));
		price.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		price.setForeground(new Color(15, 11, 65));
		price.setBounds(91, 72, 100, 22);
		price.setHorizontalAlignment(SwingConstants.LEFT);
		add(price);

		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(65, 130, 350, 120);
	}
	
	public static void main(String[] args) {
		new OnlyShotCup_5(new TopImage("초콜릿 쿠키 젤라또 프라페"));
	}
}
