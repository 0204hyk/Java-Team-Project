package kiosk.byoption;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

import kiosk.tools.GroupButtons;
import kiosk.tools.WithImage;

public class Options extends JFrame {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);

	public Options() {

		defaults();
		
		setUndecorated(true);
		setLayout(null);
		setSize(650, 950);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		
	}

	public void defaults() {
		add(new TopImage());
		add(new TotalAmounts());
		add(new TotalCups());

		add(wi.makeLabel("hy.png", 53, 24, 60, 83));
		add(wi.makeButton("home.png", 543, 44, 52, 52));

		add(wi.makeButton("minus.png", 311, 755, 18, 18));
		add(wi.makeButton("plus.png", 410, 755, 18, 18));

		add(wi.makeButton("put.png", 204, 819, 192, 68));
		add(wi.makeButton("pay.png", 415, 819, 192, 68));

	}

	public void hotAndIce() {
		add(wi.makeLabel("hot, ice.png", 46, 313, 90, 14));
		JButton hot = wi.makeButton("hot.png", 34, 336, 79, 73);
		JButton ice = wi.makeButton("ice.png", 123, 336, 79, 73);
		add(hot);
		add(ice);
		new GroupButtons(hot, ice, "hot", "ice", 79, 73);
	}

	public void decaffein() {

		add(wi.makeLabel("changeDecaffein.png", 251, 309, 114, 17));
		JButton noDecaffein = wi.makeButton("noDecaffein.png", 238, 337, 79, 73);
		JButton toDecaffein = wi.makeButton("toDecaffein.png", 327, 337, 79, 73);
		add(noDecaffein);
		add(toDecaffein);
		new GroupButtons(noDecaffein, toDecaffein, "noDecaffein", "toDecaffein", 79, 73);
	}

	public void cup() {
		add(wi.makeLabel("selectCup.png", 453, 312, 59, 17));
		JButton useDisposal = wi.makeButton("useDisposal.png", 446, 337, 79, 73);
		JButton useTumbler = wi.makeButton("useTumbler.png", 535, 336, 79, 73);
		add(useDisposal);
		add(useTumbler);
		new GroupButtons(useDisposal, useTumbler, "useDisposal", "useTumbler", 79, 73);
	}

	public void sizes() {
		add(wi.makeLabel("selectSize.png", 44, 446, 97, 17));
		JButton S = wi.makeButton("S.png", 35, 471, 79, 73);
		JButton M = wi.makeButton("M.png", 124, 471, 79, 73);
		JButton L = wi.makeButton("L.png", 214, 471, 79, 73);
		add(S);
		add(M);
		add(L);
		new GroupButtons(S, M, L, "S", "M", "L", 79, 73);
	}

	public void shot() {
		add(wi.makeLabel("selectShot.png", 368, 445, 61, 18));
		JButton noShot = wi.makeButton("noShot.png", 356, 471, 79, 73);
		JButton oneShot = wi.makeButton("oneShot.png", 445, 471, 79, 73);
		JButton twoShot = wi.makeButton("twoShot.png", 535, 471, 79, 73);
		add(noShot);
		add(oneShot);
		add(twoShot);
		new GroupButtons(noShot, oneShot, twoShot, "noShot", "oneShot", "twoShot", 79, 73);
	}

	public void ice() {
		add(wi.makeLabel("selectIce.png", 45, 589, 77, 17));
		JButton normalIce = wi.makeButton("normalIce.png", 35, 619, 79, 73);
		JButton lessIce = wi.makeButton("lessIce.png", 124, 619, 79, 73);
		JButton noIce = wi.makeButton("noIce.png", 215, 619, 79, 73);
		add(normalIce);
		add(lessIce);
		add(noIce);
		new GroupButtons(normalIce, lessIce, noIce, "normalIce", "lessIce", "noIce", 79, 73);
	}

	public void milk() {
		add(wi.makeLabel("selectMilk.png", 367, 592, 74, 16));
		JButton basicMilk = wi.makeButton("basicMilk.png", 357, 619, 79, 73);
		JButton toSoy = wi.makeButton("toSoy.png", 447, 619, 79, 73);
		JButton toLowfat = wi.makeButton("toLowfat.png", 536, 619, 79, 73);
		add(basicMilk);
		add(toSoy);
		add(toLowfat);
		new GroupButtons(basicMilk, toSoy, toLowfat, "basicMilk", "toSoy", "toLowfat", 79, 73);
	}

	public static void main(String[] args) {
	}
}
