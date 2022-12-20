package kiosk.byoption;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import kiosk.tools.WithImage;

public class NoDecaf_7 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	String menu;
	Options op = new Options(menu);
	
	public NoDecaf_7(JPanel topImage, String menu) {
		this.menu = menu;
		int x = 78;
		int y = 300;

		op.hotAndIce(x, y);
		op.sizes(x, y + 70);
		op.cup(x, y + 140);
		op.ice(x, y + 210);
		op.shot(x, y + 280);
		op.milk(x, y + 350);
		op.add(topImage);
		op.setVisible(true);

	}

	public static void main(String[] args) {
		NoDecaf_7 d = new NoDecaf_7(new TopImage("고구마 라떼"),"고구마 라떼");
	}
}
