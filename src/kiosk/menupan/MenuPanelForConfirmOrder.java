package kiosk.menupan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import kiosk.tools.WithImage;

// 최종 주문 확인에 들어갈 패널 한 줄
public class MenuPanelForConfirmOrder extends JPanel {

	DecimalFormat df = new DecimalFormat("#,###");
	public static int series = 1;
	String root = "images/KioskImages/7. 주문정보 확인";
	WithImage wi = new WithImage(root);

	public MenuPanelForConfirmOrder(ArrayList menuInfo) {

		int i;
		int x = 10, y = 15;

		for (i = 0; i < menuInfo.size(); i++) {

			JLabel menu = new JLabel(
					menuInfo.get(i + 0) + " / " + menuInfo.get(i + 1) + "잔 / " + menuInfo.get(i + 2) + "원");
			menu.setFont(new Font("맑은 고딕", Font.BOLD, 22));
			menu.setForeground(Color.BLACK);
			menu.setBounds(x + 54, y + 12, 400, 25);

			JLabel num = new JLabel("" + series);
			num.setBounds(x + 7, y + 10, 31, 31);
			num.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			num.setForeground(Color.WHITE);
			num.setHorizontalAlignment(SwingConstants.CENTER);
			num.setVerticalAlignment(SwingConstants.CENTER);

			JLabel numBg = wi.makeLabel("bg.png", x + 7, y + 10, 31, 31);
			y += 28;

			JLabel option = new JLabel("└ " + menuInfo.get(i + 3));
			option.setBounds(x + 55, y + 15, 400, 15);
			option.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			option.setForeground(new Color(145, 145, 145));

			y += 34;

			series++;

			add(num);
			add(numBg);
			add(menu);
			add(option);

			i = i + 6;
		}

		setBorder(null);
		setLayout(null);
		setVisible(true);
		setPreferredSize(new Dimension(480, 80));

	}

}
