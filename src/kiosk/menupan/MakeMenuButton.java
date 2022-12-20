package kiosk.menupan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import kiosk.tools.WithImage;

public class MakeMenuButton extends JButton implements ActionListener {

	public MakeMenuButton(int ctgNum, int optionNum, String menu, int x, int y) {
		// 카테 고리 & 커피 이름 받아 버튼으로 돌려주기

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

		setIcon(new ImageIcon(wi.readImage(root + "unselected/" + menu + ".png", 155, 155)));
		setBounds(x, y, 155, 155);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setPressedIcon(new ImageIcon(wi.readImage(root + "selected/" + menu + ".png", 155, 155)));
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//옵션받아서 새페이지열기
	}

}
