package kiosk.byoption;

import javax.swing.JPanel;

import kiosk.tools.WithImage;

public class NoHot_3 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	Options op = new Options();

	public NoHot_3(JPanel topImage) {
		int x = 78;
		int y = 310;

		op.sizes(x, y);
		op.decaffein(x, y + 70);
		op.cup(x, y + 140);
		op.ice(x, y + 210);
		op.shot(x, y + 280);
		op.milk(x, y + 350);
		op.add(topImage);
		op.setVisible(true);
	}

	public static void main(String[] args) {
		new NoHot_3(new TopImage("콜드브루"));
	}

}
