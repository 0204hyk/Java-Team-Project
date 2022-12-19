package kiosk.byoption;

import javax.swing.JPanel;

import kiosk.tools.WithImage;

public class OnlyShotCup_5 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	Options op = new Options();

	public OnlyShotCup_5(JPanel topImage) {
		int x = 78;
		int y = 330;
		op.cup(x, y);
		op.shot(x, y + 70);
		op.add(topImage);
		op.setVisible(true);

	}

	public static void main(String[] args) {
		new OnlyShotCup_5(new TopImage("그린티 프라페"));
		
	}

}
