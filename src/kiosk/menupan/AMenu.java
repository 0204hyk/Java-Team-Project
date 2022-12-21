package kiosk.menupan;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.kiosk.GetImageInfo;
import kiosk.byoption.TotalCups;
import kiosk.tools.WithImage;

public class AMenu extends JPanel {
	String root = "images/KioskImages/3. 메뉴선택";
	WithImage wi = new WithImage(root);
	DecimalFormat df = new DecimalFormat("#,###");
	String menu, temparature;

	public static int yy = 695;
	int x = 0, y = 0;
	
	// 장바구니에 한 줄씩 들어감
	public AMenu(int num, String menu, String temparature) {
		this.menu = menu;
		this.temparature = temparature;

		GetImageInfo gi = new GetImageInfo(menu);
		
		// 생성할때마다 증가
		yy = 695+ (num * 48);
		
		// 음료 이름
		String menuName = "";
		if (temparature == null) {
			menuName = menu + " (ICE ONLY) ";
		} else {
			menuName = menu + " (" + temparature.toUpperCase() + ") ";
		}

		JLabel menuNamelb = new JLabel(menuName);
		menuNamelb.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		menuNamelb.setBounds(x + 45, y + 5, 200, 32);

		// 가격
		String price = df.format(gi.getMenuPrice() * TotalCups.cup) + "원";
		JLabel menuPricelb = new JLabel(price);
		menuPricelb.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		menuPricelb.setBounds(x + 250, y + 5, 70, 32);

		// 잔 수
		JLabel cups = new JLabel(TotalCups.cup + "잔");
		cups.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		cups.setBounds(x + 374, y+ 9, 35, 22);
		cups.setHorizontalAlignment(JLabel.CENTER);

		// 더하기 버튼
		JButton plus = wi.makeButton("plus.png", x + 419, y + 11, 18, 18);
		plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (TotalCups.cup > 0) {
					TotalCups.cup = TotalCups.cup + 1;
				} else if (TotalCups.cup > 98) {
					TotalCups.cup = 99;
				}
				cups.setText(TotalCups.cup + "잔");
				menuPricelb.setText(df.format(gi.getMenuPrice() * TotalCups.cup) + "원");

			}
		});

		// 빼기
		JButton minus = wi.makeButton("minus.png", x + 344, y + 11, 18, 18);
		minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (TotalCups.cup > 1) {
					TotalCups.cup = TotalCups.cup - 1;
				} else if (TotalCups.cup < 1) {
					TotalCups.cup = 1;
				}
				cups.setText(TotalCups.cup + "잔");
				menuPricelb.setText(df.format(gi.getMenuPrice() * TotalCups.cup) + "원");
			}
		});

		// 삭제 버튼
		JButton delete = wi.makeButton("delete.png", x + 457, y + 5, 31, 31);

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});

		setOpaque(false);
		setBorder(null);
		setLayout(null);

		// 음료 순번
		add(wi.makeLabel(num + ".png", x + 4, y + 5, 31, 31));
		add(cups);
		add(menuNamelb);
		add(menuPricelb);
		add(plus);
		add(minus);
		add(delete);

		
		setBounds(31, yy, 505, 41);
		setVisible(true);
		

	}
	
	public static void changeMenu(String menu, String temparature) {
		
	}

}
