package kiosk.byoption;

import javax.swing.JPanel;

import kiosk.tools.WithImage;

public class NoMilk_2 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
<<<<<<< HEAD

	public NoMilk_2(JPanel topImage, String menu) {
		Options op = new Options(menu, Options.choiceMenu);
		
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

		new NoMilk_2(new TopImage("아메리카노"), "아메리카노");
=======
	Options op = new Options();

	public NoMilk_2(JPanel jp) {

		op.hotAndIce(78, 269);
		op.sizes(78, 339);
		op.decaffein(78, 409);
		op.cup(78, 479);
		op.ice(78, 549);
		op.shot(78, 620);
		op.add(jp);
		op.setVisible(true);
	}

	public static void main(String[] args) {

		new NoMilk_2(new TopImage("카페라떼"));
>>>>>>> refs/remotes/origin/main
	}

}
