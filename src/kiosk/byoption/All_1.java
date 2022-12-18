package kiosk.byoption;

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
	}

}
