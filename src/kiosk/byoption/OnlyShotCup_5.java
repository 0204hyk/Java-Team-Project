package kiosk.byoption;

import java.awt.Color;

import javax.swing.JFrame;

import kiosk.tools.WithImage;

public class OnlyShotCup_5 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	Options op = new Options();

	public OnlyShotCup_5() {
		
		op.cup(44, 330);
		op.shot(300, 330);
		op.setVisible(true);
	}

	public static void main(String[] args) {

		new OnlyShotCup_5();
	}

}
