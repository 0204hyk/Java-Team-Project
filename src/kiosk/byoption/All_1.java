package kiosk.byoption;

import javax.swing.JPanel;

import kiosk.menupan.ChoiceMenu;
import kiosk.tools.WithImage;

public class All_1 {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);
	
	public All_1(JPanel topImage, String menu) {
		Options op = new Options(menu);
		
		int x = 78;
		int y = 276;

		op.hotAndIce(x, y);
		op.sizes(x, y + 70);
		op.decaffein(x, y + 140);
		op.cup(x, y + 210);
		op.ice(x, y + 280);
		op.shot(x, y + 350);
		op.milk(x, y + 420);
		op.add(topImage);

		op.setVisible(true);
		
	}
	
	

	public static void main(String[] args) {
	}

}
