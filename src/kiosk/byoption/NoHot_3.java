package kiosk.byoption;

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
	}

}
