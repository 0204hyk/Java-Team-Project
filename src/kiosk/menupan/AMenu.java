package kiosk.menupan;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.kiosk.GetImageInfo;
import kiosk.byoption.Cups;
import kiosk.tools.WithImage;

public class AMenu extends JPanel {
	String root = "images/KioskImages/3. 메뉴선택";
	WithImage wi = new WithImage(root);
	DecimalFormat df = new DecimalFormat("#,###");
	String menu, temparature, price, optionNums;

	int x = 0, y = 0;

	static int num = 0;

	// 장바구니에 한 줄씩 들어감, Options에서 만든 cup을 가져온다

	public AMenu(String menu, Cups cup, String temparature, int optionPrice, ChoiceMenu frame, String name, String optionNums) {
		this.menu = menu;
		this.temparature = temparature;
		this.optionNums = optionNums;
		
		int position = frame.getMenuPosition(name);
		GetImageInfo gi = new GetImageInfo(menu);

		num++;

		// 음료 이름
		String menuName = "";
		if (temparature == null) {
			menuName = menu + " (ICE ONLY) ";
		} else {
			menuName = menu + " (" + temparature.toUpperCase() + ") ";
		}

		JLabel menuNamelb = new JLabel(menuName);
		menuNamelb.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		menuNamelb.setBounds(x + 45, y + 5, 270, 32);

		// 가격
		price = df.format((optionPrice + gi.getMenuPrice()) * cup.getCup()) + "원";
		JLabel menuPricelb = new JLabel(price);
		menuPricelb.setHorizontalAlignment(JLabel.RIGHT);
		menuPricelb.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		menuPricelb.setBounds(x + 285, y + 5, 70, 32);

		// 잔 수
		JLabel cups = new JLabel(cup.cup + "잔");
		cups.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		cups.setBounds(x + 390, y + 9, 35, 22);
		cups.setHorizontalAlignment(JLabel.CENTER);

		// 더하기 버튼
		JButton plus = wi.makeButton("plus.png", x + 429, y + 12, 18, 18);
		plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cup.cup > 0) {
					cup.plus();
				} else if (cup.cup > 98) {
					cup.setCup(99);

				}
				cups.setText(cup.cup + "잔");
				menuPricelb.setText(df.format((optionPrice + gi.getMenuPrice()) * cup.cup) + "원");

				frame.menuInfo.set(position + 1, cup.cup + "");
				frame.menuInfo.set(position + 2, (optionPrice + gi.getMenuPrice()) * cup.cup + "");
			}
		});

		// 빼기
		JButton minus = wi.makeButton("minus.png", x + 368, y + 12, 18, 18);
		minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cup.cup > 1) {
					cup.setCup(cup.cup - 1);
				} else if (cup.cup < 1) {
					cup.setCup(1);
				}
				cups.setText(cup.cup + "잔");
				menuPricelb.setText(df.format((optionPrice + gi.getMenuPrice()) * cup.cup) + "원");

				frame.menuInfo.set(position + 1, cup.cup + "");
				frame.menuInfo.set(position + 2, (optionPrice + gi.getMenuPrice()) * cup.cup + "");
			}
		});

		// 메뉴 삭제 버튼 - 메뉴 리스트 재 업데이트 필요
		JButton delete = wi.makeButton("delete.png", x + 457, y + 5, 31, 31);


		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 4; i++) {
					frame.menuInfo.remove(position);
				}
				setVisible(false);
				num--;

			}
		});
		
		

		setBorder(null);
		setLayout(null);

		// 음료 순번 - 수정 필요
		add(wi.makeLabel(num + ".png", x + 4, y + 5, 31, 31));
		add(cups);
		add(menuNamelb);
		add(menuPricelb);
		add(plus);
		add(minus);
		add(delete);

		setVisible(true);
		setPreferredSize(new Dimension(505, 41));
	}

	public ArrayList getMenuInfo() {
		// 음료명 / 잔수 / 금액 (다음줄) 옵션 - HOT, ICE / 사이즈 / 컵 / 옵션들 리스트
		ArrayList<String> menuInfo = new ArrayList<>();

		menuInfo.add(menu);
		menuInfo.add("잔수");
		menuInfo.add(price);
		menuInfo.add(optionNums);

		return menuInfo;
	}

}
