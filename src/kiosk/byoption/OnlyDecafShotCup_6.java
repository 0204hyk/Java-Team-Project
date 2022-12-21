package kiosk.byoption;

import java.awt.Color;

import javax.swing.JFrame;
<<<<<<< HEAD
import javax.swing.JPanel;

import kiosk.tools.WithImage;

public class OnlyDecafShotCup_6 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);

	public OnlyDecafShotCup_6(JPanel topImage, String menu) {
		Options op = new Options(menu, Options.choiceMenu);
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
		
=======

import kiosk.tools.WithImage;

public class OnlyDecafShotCup_6 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	Options op = new Options();

	public OnlyDecafShotCup_6() {

		op.decaffein(78, 269);
		op.cup(78, 339);
		op.shot(78, 409);
		op.setVisible(true);
		
		

	}

	public static void main(String[] args) {

		new OnlyDecafShotCup_6();
>>>>>>> refs/remotes/origin/main
	}

}
