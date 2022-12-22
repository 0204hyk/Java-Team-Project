package kiosk.menupan;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import database.kiosk.CheckMenuByCategories;
import kiosk.tools.WithImage;

public class PanelsByCategory extends JPanel {
	String root = "images/KioskImages/3. 메뉴선택";
	WithImage wi = new WithImage(root);
	JScrollPane scroll = new JScrollPane();
	
	
	
	public PanelsByCategory() {
		
	}
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
		
		scroll.setBounds(0, 0, 503, 550);
		scroll.getViewport().setBackground(Color.WHITE);
		scroll.setBorder(null);
		add(scroll);
		setBounds(74, 212, 503, 508);
		setLayout(null);
		setBackground(Color.WHITE);
		setVisible(false);
	}

}
