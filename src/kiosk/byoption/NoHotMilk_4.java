package kiosk.byoption;

import java.awt.Color;

import javax.swing.JFrame;

import kiosk.tools.WithImage;

public class NoHotMilk_4 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	Options op = new Options();

	public NoHotMilk_4() {
		
		op.sizes(78,269);
		op.decaffein(78, 339);
		op.cup(78,409);
		op.ice(78,479);
		op.shot(78,549);
		op.setVisible(true);
		

	}
	
	public static void main(String[] args) {
		
		new NoHotMilk_4();
	}
	
}
