package kiosk.byoption;

<<<<<<< HEAD
import javax.swing.JPanel;

import kiosk.menupan.ChoiceMenu;
import kiosk.tools.WithImage;

public class All_1 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	
	public All_1(JPanel topImage, String menu) {
		Options op = new Options(menu, Options.choiceMenu);
		
		int x = 78;
		int y = 276;

		op.hotAndIce(x, y);
		op.sizes(x, y + 70);
		op.decaffein(x, y + 140);
		op.cup(x, y + 210);
		op.ice(x, y + 280);
		op.shot(x, y + 350);
		op.milk(x, y + 420);
		op.add(topImage);

		op.setVisible(true);
		
	}
	
	

	public static void main(String[] args) {
=======
import java.awt.Color;

import javax.swing.JFrame;

import kiosk.tools.WithImage;

public class All_1 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	Options op = new Options();

	public All_1() {
		
		op.hotAndIce(78,269);
		op.sizes(78,339);
		op.decaffein(78, 409);
		
		op.cup(78,479);
		op.ice(78,549);
		op.shot(78,620);
		op.milk(78,691);
		op.setVisible(true);
	}

	public static void main(String[] args) {

		new All_1();
>>>>>>> refs/remotes/origin/main
	}

}
