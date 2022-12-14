package pos.calculation.popup;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import pos.WithImage;

public class OptionMenu extends JFrame {

	WithImage wi = new WithImage("images/PosImages/계산 파트 이미지/");

	public OptionMenu() {

		// 옵션
		int x = 0;
		int y = 0;
		String text = "";
		for (int i = 0; i < 20; ++i) {
			if (i == 0) {
				text = "ICE";
			} else if (i == 1) {
				text = "HOT";
			} else if (i == 5) {
				text = "두유";
			} else if (i == 6) {
				text = "<HTML>저지방<br>우유</HTML>";
			} else if (i == 7) {
				text = "휘핑 크림";
			} else if (i == 10) {
				text = "시럽";
			} else if (i == 11) {
				text = "<HTML>라이트<br>시럽</HTML>";
			} else if (i == 12) {
				text = "<HTML>바닐라<br>시럽</HTML>";
			} else if (i == 13) {
				text = "<HTML>헤이즐넛<br>시럽</HTML>";
			} else {
				text = "";
			}

			JButton bt = new JButton(text);
			bt.setFont(new Font("맑은 고딕", Font.BOLD, 16));
			bt.setHorizontalAlignment(JButton.LEFT);
			bt.setVerticalAlignment(JButton.TOP);
			bt.setBounds(x, y, 120, 100);
			bt.setFocusPainted(false);
			bt.setContentAreaFilled(false);

			x += 120;
			if (i == 4 || i == 9 || i == 14) {
				x = 0;
				y += 100;
			}
			add(bt);

		}
		// 완료 버튼
		add(wi.makeButton("옵션창 완료 버튼", 477, 397, 132, 203));
		
		// 옵션 입력 부분
		JLabel bg = new JLabel();
		bg.setOpaque(true);
		bg.setBackground(Color.white);
		bg.setBounds(0, 400, 600, 203);
		add(bg);


		setLayout(null);
		setSize(600, 630);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new OptionMenu();
	}
}
