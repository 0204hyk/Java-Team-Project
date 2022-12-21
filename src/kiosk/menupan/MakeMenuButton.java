package kiosk.menupan;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import database.kiosk.GetImageInfo;
import kiosk.byoption.All_1;
import kiosk.byoption.NoDecaf_7;
import kiosk.byoption.NoHotMilk_4;
import kiosk.byoption.NoHot_3;
import kiosk.byoption.NoMilk_2;
import kiosk.byoption.OnlyDecafShotCup_6;
import kiosk.byoption.OnlyShotCup_5;
import kiosk.byoption.OnlyShotIceCup_8;
import kiosk.byoption.Options;
import kiosk.byoption.TopImage;
import kiosk.byoption.TotalCups;
import kiosk.tools.WithImage;

public class MakeMenuButton extends JButton implements ActionListener {
	DecimalFormat df = new DecimalFormat("#,###");

	String menu;
	int ctgNum;
	Options frame;

	public MakeMenuButton(int ctgNum, int optionNum, String menu, int x, int y) {
		this.ctgNum = ctgNum;
		this.menu = menu;

		String root = "";

		if (ctgNum == 2) {
			root = "images/KioskImages/menu/coffee ";
		} else if (ctgNum == 3) {
			root = "images/KioskImages/menu/frappe ";
		} else if (ctgNum == 4) {
			root = "images/KioskImages/menu/noncoffee ";
		} else if (ctgNum == 5) {
			root = "images/KioskImages/menu/ade ";
		}

		WithImage wi = new WithImage(root);
		GetImageInfo gi = new GetImageInfo(menu);

		JLabel price = new JLabel("￦" + df.format(gi.getMenuPrice()));
		price.setBounds(48, 131, 57, 16);
		price.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		price.setForeground(new Color(15, 11, 65));
		price.setHorizontalAlignment(JLabel.CENTER);
		add(price);

		setLayout(null);
		setIcon(new ImageIcon(wi.readImage(root + "unselected/" + menu + ".png", 155, 155)));
		setBounds(x, y, 155, 155);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setPressedIcon(new ImageIcon(wi.readImage(root + "selected/" + menu + ".png", 155, 155)));
		setVisible(true);
		addActionListener(this);

	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		TotalCups.cup = 1; // 장바구니에서 수량을 올리면 그 숫자부터 시작하기 때문에 초기화 시켜놓기
		if (ctgNum == 1) {
			new All_1(new TopImage(menu), menu);
		} else if (ctgNum == 2) {
			new NoMilk_2(new TopImage(menu), menu);
		} else if (ctgNum == 3) {
			new NoHot_3(new TopImage(menu), menu);
		} else if (ctgNum == 4) {
			new NoHotMilk_4(new TopImage(menu), menu);
		} else if (ctgNum == 5) {
			new OnlyShotCup_5(new TopImage(menu), menu);
		} else if (ctgNum == 6) {
			new OnlyDecafShotCup_6(new TopImage(menu), menu);
		} else if (ctgNum == 7) {
			new NoDecaf_7(new TopImage(menu), menu);
		} else if (ctgNum == 8) {
			new OnlyShotIceCup_8(new TopImage(menu), menu);
		}
	}

}
