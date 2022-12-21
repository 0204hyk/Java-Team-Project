package kiosk.byoption;

import java.awt.Color;

import javax.swing.JFrame;
<<<<<<< HEAD
import javax.swing.JPanel;

import kiosk.tools.WithImage;

public class NoDecaf_7 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	
	public NoDecaf_7(JPanel topImage, String menu) {
		Options op = new Options(menu, Options.choiceMenu);
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
=======

import kiosk.tools.WithImage;

public class NoDecaf_7 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	Options op = new Options();

	public NoDecaf_7() {

		op.hotAndIce(78,269);
		op.sizes(78, 339);
		op.cup(78, 409);
		op.ice(78, 479);
		op.shot(78, 549);
		op.milk(78, 620);
		op.setVisible(true);
		
	}

	public static void main(String[] args) {

		new NoDecaf_7();
	}

>>>>>>> refs/remotes/origin/main
}
