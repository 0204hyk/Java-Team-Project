package kiosk.byoption;

import java.awt.Color;

import javax.swing.JFrame;

import kiosk.tools.WithImage;

public class NoHotMilk_4 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	Options op = new Options();

	public NoHotMilk_4() {
		
		op.decaffein(44, 315);
		op.cup(367, 315);
		op.sizes(44, 445);
		op.shot(367, 445);
		op.ice(44, 585);
		op.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new NoHotMilk_4();
	}
	
}
