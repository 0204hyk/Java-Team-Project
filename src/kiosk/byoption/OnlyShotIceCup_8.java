package kiosk.byoption;


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
	}

}
