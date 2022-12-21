package kiosk.byoption;

<<<<<<< HEAD
import javax.swing.JPanel;

import kiosk.tools.WithImage;

public class OnlyShotIceCup_8 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);

	public OnlyShotIceCup_8(JPanel topImage, String menu) {
		Options op = new Options(menu, Options.choiceMenu);
		int x = 78;
		int y = 330;

		op.sizes(x, y);
		op.shot(x, y + 70);
		op.cup(x, y + 140);
		op.add(topImage);
		op.setVisible(true);

	}

	public static void main(String[] args) {
		new OnlyShotIceCup_8(new TopImage("레몬 에이드"), "레몬 에이드");
=======
import java.awt.Color;

import javax.swing.JFrame;

import kiosk.tools.WithImage;

public class OnlyShotIceCup_8 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	Options op = new Options();

	public OnlyShotIceCup_8() {

		op.sizes(78, 269);
		op.shot(78, 339);
		op.cup(78, 409);
		op.setVisible(true);
		
	}

	public static void main(String[] args) {

		new OnlyShotIceCup_8();
>>>>>>> refs/remotes/origin/main
	}

}
