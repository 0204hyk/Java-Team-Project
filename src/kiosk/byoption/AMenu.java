package kiosk.byoption;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.kiosk.GetImageInfo;
import kiosk.tools.WithImage;

public class AMenu extends JPanel {
	String root = "images/KioskImages/3. 메뉴선택";
	WithImage wi = new WithImage(root);
	DecimalFormat df = new DecimalFormat("#,###");
	int num = 1;

	// 장바구니에 한 줄씩 들어갈 패널
	
	public AMenu(String menu, String temparature) {
		// 음료 순번
		add(wi.makeLabel(num + ".png", 10, 10, 31, 31));

		// 음료 이름과 가격
		GetImageInfo gi = new GetImageInfo(menu);
		
		String text = menu + " (" + temparature + ") " + gi.getMenuPrice() + "원";
		JLabel menuInfo = new JLabel(text);
		menuInfo.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		menuInfo.setBounds(50, 9, 288, 32);

		// 가격 합산해서 적기?
		
		// 잔 수
		JLabel cups = new JLabel(TotalCups.cup + "잔");
		cups.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		cups.setBounds(373, 12, 35, 22);
		cups.setHorizontalAlignment(JLabel.CENTER);

		// 마이너스, 플러스 버튼
		JButton minus = wi.makeButton("minus.png", 344, 15, 18, 18);
		minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (TotalCups.cup > 1) {
					TotalCups.cup = TotalCups.cup - 1;
					cups.setText(TotalCups.cup + "잔");
				} else if (TotalCups.cup < 1) {
					TotalCups.cup = 1;
				}
			}
		});

		JButton plus = wi.makeButton("plus.png", 419, 15, 18, 18);
		plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (TotalCups.cup > 0) {
					TotalCups.cup = TotalCups.cup + 1;
					cups.setText(TotalCups.cup + "잔");
				} else if (TotalCups.cup > 98) {
					TotalCups.cup = 99;
				}

			}
		});

		// 삭제 버튼
		JButton delete = wi.makeButton("delete.png", 457, 7, 31, 31);

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				if (num != 1) {
					num = num - 1;
				}
			}
		});

		add(menuInfo);
		add(cups);
		add(minus);
		add(plus);
		add(delete);

		setBounds(5, 5, 493, 31);
		setLayout(null);
		setBorder(null);
		setBackground(Color.WHITE);
	}

	public void setNum(int num) {
		this.num = num;
	}
}
