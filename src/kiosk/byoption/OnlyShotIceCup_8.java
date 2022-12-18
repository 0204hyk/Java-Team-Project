package kiosk.byoption;

import java.awt.Color;

import javax.swing.JFrame;

import kiosk.tools.WithImage;

public class OnlyShotIceCup_8 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	Options op = new Options();

	public OnlyShotIceCup_8() {

		op.sizes(44, 315);
		op.shot(367, 315);
		op.cup(44, 445);
		op.setVisible(true);
	}

	public static void main(String[] args) {

		new OnlyShotIceCup_8();
	}

}
