package kiosk.byoption;

import javax.swing.JPanel;

import kiosk.tools.WithImage;

public class NoHotMilk_4 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	Options op = new Options();

	public NoHotMilk_4(JPanel topImage) {
		int x = 78;
		int y = 320;

		op.sizes(x, y);
		op.decaffein(x, y + 70);
		op.cup(x, y + 140);
		op.ice(x, y + 210);
		op.shot(x, y + 280);
		op.add(topImage);
		op.setVisible(true);

	}

	public static void main(String[] args) {
		new NoHotMilk_4(new TopImage("콜드브루 라떼"));
	}
}
