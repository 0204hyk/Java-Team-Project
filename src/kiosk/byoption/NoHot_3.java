package kiosk.byoption;

<<<<<<< HEAD
import javax.swing.JPanel;

import kiosk.tools.WithImage;

public class NoHot_3 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);

	public NoHot_3(JPanel topImage, String menu) {
		Options op = new Options(menu, Options.choiceMenu);
		int x = 78;
		int y = 310;

		op.sizes(x, y);
		op.decaffein(x, y + 70);
		op.cup(x, y + 140);
		op.ice(x, y + 210);
		op.shot(x, y + 280);
		op.milk(x, y + 350);
		op.add(topImage);
		op.setVisible(true);
	}

	public static void main(String[] args) {
=======
import java.awt.Color;

import javax.swing.JFrame;

import kiosk.tools.WithImage;

public class NoHot_3 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	Options op = new Options();

	public NoHot_3() {

		op.sizes(78,269);
		op.decaffein(78, 339);
		op.cup(78,409);
		op.ice(78,479);
		op.shot(78,549);
		op.milk(78,620);
		op.setVisible(true);
	}

	public static void main(String[] args) {

		new NoHot_3();
>>>>>>> refs/remotes/origin/main
	}

}
