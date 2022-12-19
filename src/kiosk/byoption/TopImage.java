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

		JLabel nameKor = new JLabel(gi.getMenuNameKor()); // 커피 이름 한글
		nameKor.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		nameKor.setForeground(Color.BLACK);
		nameKor.setBounds(96, 13, 200, 30);
		nameKor.setHorizontalAlignment(SwingConstants.LEFT);
		add(nameKor);

		JLabel nameEng = new JLabel(gi.getMenuNameEng()); // 커피 이름 영문
		nameEng.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		nameEng.setForeground(new Color(151, 159, 156));
		nameEng.setBounds(98, 47, 200, 20);
		nameEng.setHorizontalAlignment(SwingConstants.LEFT);
		add(nameEng);

		JLabel price = new JLabel("￦"+df.format(gi.getMenuPrice())); // 총 금액
		price.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		price.setForeground(new Color(15, 11, 65));
		price.setBounds(99, 72, 100, 22);
		price.setHorizontalAlignment(SwingConstants.LEFT);
		add(price);

		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(192,124,328,120);
	}
}
