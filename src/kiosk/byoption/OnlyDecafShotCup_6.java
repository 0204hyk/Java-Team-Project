package kiosk.byoption;

import java.awt.Color;

import javax.swing.JFrame;

import kiosk.tools.WithImage;

public class OnlyDecafShotCup_6 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	Options op = new Options();

	public OnlyDecafShotCup_6() {

		op.decaffein(44, 315);
		op.cup(300, 315);
		op.shot(44, 445);
		op.setVisible(true);
	}

	public static void main(String[] args) {

		new OnlyDecafShotCup_6();
	}

}
