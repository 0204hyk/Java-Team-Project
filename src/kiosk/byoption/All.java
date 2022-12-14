package kiosk.byoption;

import java.awt.Color;

import javax.swing.JFrame;

import kiosk.tools.WithImage;

public class All extends JFrame{
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	Options op = new Options();

	public All() {
		op.hotAndIce();
		op.decaffein();
		op.sizes();
		op.cup();
		op.ice();
		op.shot();
		op.milk();
		
	
	}
	
	public static void main(String[] args) {
		
		new All();
	}
	
}
