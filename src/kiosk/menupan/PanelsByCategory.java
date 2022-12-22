package kiosk.menupan;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import database.kiosk.CheckMenuByCategories;

public class PanelsByCategory extends JPanel {


	public PanelsByCategory(int ctgNum) {

		CheckMenuByCategories mc = new CheckMenuByCategories(ctgNum);
		JScrollPane scroll = new JScrollPane();
		
		int x = 0, y = 0;

		for (int i = 0; i < mc.getListSize(); i++) {
			add(new MakeMenuButton(ctgNum, mc.getOptionNumber().get(i), mc.getMenu().get(i), x, y));
			x += 176;
			if (i == 2 || i == 5 || i == 8) {
				x = 0;
				y += 176;
			}
		}
		//550
		scroll.setBounds(74, 212, 503, 308);
		scroll.getViewport().setBackground(Color.WHITE);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBorder(null);
		add(scroll);
//		setBounds(74, 212, 503, 308);
		setLayout(null);
		setBackground(Color.WHITE);
		setBorder(null);
		setVisible(false);
	}

}
