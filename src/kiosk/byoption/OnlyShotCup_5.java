package kiosk.byoption;


import java.awt.Color;

import javax.swing.JFrame;

import kiosk.tools.WithImage;

public class OnlyShotCup_5 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	Options op = new Options();

	public OnlyShotCup_5() {
		
		op.cup(78, 269);
		op.shot(78, 339);
		op.setVisible(true);
		
	}

	public static void main(String[] args) {

		new OnlyShotCup_5();
	}

}
