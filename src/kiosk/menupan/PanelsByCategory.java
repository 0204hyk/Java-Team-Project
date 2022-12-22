package kiosk.menupan;

import java.awt.Color;

import javax.swing.JPanel;

import database.kiosk.CheckMenuByCategories;

public class PanelsByCategory extends JPanel {


	public PanelsByCategory(int ctgNum, int num) {

		CheckMenuByCategories mc = new CheckMenuByCategories(ctgNum);
		
		int x = 0, y = 0;

//		if (num < 9) {
//			int tmp = num;
//			start = 9 + tmp;
//			num = start + tmp;
//		}

		for (int i = 0; i < num; i++) {
			add(new MakeMenuButton(ctgNum, mc.getOptionNumber().get(i), mc.getMenu().get(i), x, y));
			x += 176;
			if (i == 2 || i == 5 || i == 8) {
				x = 0;
				y += 176;
			}
		}

		setBounds(74, 212, 503, 508);
		setLayout(null);
		setBackground(Color.WHITE);
		setBorder(null);
		setVisible(false);
	}

}
