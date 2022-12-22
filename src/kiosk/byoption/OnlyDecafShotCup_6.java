package kiosk.byoption;

import java.awt.Color;

import javax.swing.JFrame;


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
	}

}
