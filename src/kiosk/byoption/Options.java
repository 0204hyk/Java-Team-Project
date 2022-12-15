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

	public void hotAndIce(int x, int y) {

		add(wi.makeLabel("hot, ice.png", x, y, 90, 14));
		JButton hot = wi.makeButton("hot.png", x - 10, y + 25, 79, 73);
		JButton ice = wi.makeButton("ice.png", x + 78, y + 25, 79, 73);
		add(hot);
		add(ice);
		new GroupButtons(hot, ice, "hot", "ice", 79, 73);
	}

	public void decaffein(int x, int y) {

		add(wi.makeLabel("changeDecaffein.png", x, y, 114, 17));
		JButton noDecaffein = wi.makeButton("noDecaffein.png", x - 10, y + 25, 79, 73);
		JButton toDecaffein = wi.makeButton("toDecaffein.png", x + 78, y + 25, 79, 73);
		add(noDecaffein);
		add(toDecaffein);
		new GroupButtons(noDecaffein, toDecaffein, "noDecaffein", "toDecaffein", 79, 73);
	}

	public void cup(int x, int y) {
		add(wi.makeLabel("selectCup.png", x, y, 59, 17));
		JButton useDisposal = wi.makeButton("useDisposal.png", x - 10, y + 25, 79, 73);
		JButton useTumbler = wi.makeButton("useTumbler.png", x + 78, y + 25, 79, 73);
		add(useDisposal);
		add(useTumbler);
		new GroupButtons(useDisposal, useTumbler, "useDisposal", "useTumbler", 79, 73);
	}

	public void sizes(int x, int y) {
		add(wi.makeLabel("selectSize.png", x, y, 97, 17));
		JButton S = wi.makeButton("S.png", x - 10, y + 25, 79, 73);
		JButton M = wi.makeButton("M.png", x + 78, y + 25, 79, 73);
		JButton L = wi.makeButton("L.png", x + 166, y + 25, 79, 73);
		add(S);
		add(M);
		add(L);
		new GroupButtons(S, M, L, "S", "M", "L", 79, 73);
	}

	public void shot(int x, int y) {
		add(wi.makeLabel("selectShot.png", x, y, 61, 18));
		JButton noShot = wi.makeButton("noShot.png", x - 10, y + 25, 79, 73);
		JButton oneShot = wi.makeButton("oneShot.png", x + 78, y + 25, 79, 73);
		JButton twoShot = wi.makeButton("twoShot.png", x + 166, y + 25, 79, 73);
		add(noShot);
		add(oneShot);
		add(twoShot);
		new GroupButtons(noShot, oneShot, twoShot, "noShot", "oneShot", "twoShot", 79, 73);
	}

	public void ice(int x, int y) {
		add(wi.makeLabel("selectIce.png", x,y, 77, 17));
		JButton normalIce = wi.makeButton("normalIce.png", x -10, y +25, 79, 73);
		JButton lessIce = wi.makeButton("lessIce.png", x + 78, y + 25, 79, 73);
		JButton noIce = wi.makeButton("noIce.png", x + 166, y + 25, 79, 73);
		add(normalIce);
		add(lessIce);
		add(noIce);
		new GroupButtons(normalIce, lessIce, noIce, "normalIce", "lessIce", "noIce", 79, 73);
	}

	public void milk(int x, int y) {
		add(wi.makeLabel("selectMilk.png", x,y, 74, 16));
		JButton basicMilk = wi.makeButton("basicMilk.png", x-10,y+25, 79, 73);
		JButton toSoy = wi.makeButton("toSoy.png", x + 78, y + 25, 79, 73);
		JButton toLowfat = wi.makeButton("toLowfat.png", x + 166, y + 25, 79, 73);
		add(basicMilk);
		add(toSoy);
		add(toLowfat);
		new GroupButtons(basicMilk, toSoy, toLowfat, "basicMilk", "toSoy", "toLowfat", 79, 73);
	}

	public static void main(String[] args) {
	}
}
