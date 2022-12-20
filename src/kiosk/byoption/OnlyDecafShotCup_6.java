package kiosk.byoption;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import kiosk.tools.WithImage;

public class OnlyDecafShotCup_6 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	String menu;
	Options op = new Options(menu);

	public OnlyDecafShotCup_6(JPanel topImage, String menu) {
		this.menu = menu;
		int x = 78;
		int y = 330;
		op.decaffein(x, y);
		op.cup(x, y + 70);
		op.shot(x, y + 140);
		op.add(topImage);
		op.setVisible(true);

	}
	
	public static void main(String[] args) {
		new OnlyDecafShotCup_6(new TopImage("콜드브루 모카 프라페"), "콜드브루 모카 프라페");
		
	}

}
