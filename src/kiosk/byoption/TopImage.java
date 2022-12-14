package kiosk.byoption;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import kiosk.tools.WithImage;

public class TopImage extends JPanel {
	String root = "images/KioskImages/menu/ade/";
	WithImage wi = new WithImage(root);

	public TopImage() {

		add(wi.makeLabel("자몽 에이드.png", 20, 0, 110, 130)); // 커피 사진

		JLabel nameKor = new JLabel("자몽 에이드"); // 커피 이름 한글
		nameKor.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		nameKor.setForeground(Color.BLACK);
		nameKor.setBounds(15, 125, 120, 25);
		nameKor.setHorizontalAlignment(SwingConstants.CENTER);
		add(nameKor);

		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(250, 120, 127, 178);
	}
}
