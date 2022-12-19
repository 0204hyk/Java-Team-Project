package kiosk.byoption;

import javax.swing.JPanel;

import kiosk.tools.WithImage;

public class NoMilk_2 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	Options op = new Options();

	public NoMilk_2(JPanel topImage) {
		int x = 78;
		int y = 295;

		op.hotAndIce(x, y);
		op.sizes(x, y + 70);
		op.decaffein(x, y + 140);
		op.cup(x, y + 210);
		op.ice(x, y + 280);
		op.shot(x, y + 350);
		op.add(topImage);
		op.setVisible(true);
	}

	public static void main(String[] args) {

		new NoMilk_2(new TopImage("아메리카노"));
	}

}
