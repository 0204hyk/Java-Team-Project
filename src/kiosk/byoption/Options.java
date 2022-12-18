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
		add(new TotalCups());

		add(wi.makeLabel("hy.png", 53, 24, 60, 83));
		add(wi.makeButton("home.png", 543, 44, 52, 52));

		add(wi.makeButton("minus.png", 457, 763, 18, 18));
		add(wi.makeButton("plus.png", 556, 763, 18, 18));

		add(wi.makeButton("put.png", 415, 813, 192, 68));

	}

	public void hotAndIce(int x, int y) {

		add(wi.makeLabel("hot, ice.png", x, y, 45, 16));
		JButton hot = wi.makeButton("hot.png", x + 173, y - 20, 78, 54);
		JButton ice = wi.makeButton("ice.png", x + 257, y - 20, 78, 54);
		add(hot);
		add(ice);
		new GroupButtons(hot, ice, "hot", "ice", 78, 54);
	}

	public void decaffein(int x, int y) {

		add(wi.makeLabel("changeDecaffein.png", x, y, 119, 17));
		JButton noDecaffein = wi.makeButton("noDecaffein.png", x + 173, y - 20, 78, 54);
		JButton toDecaffein = wi.makeButton("toDecaffein.png", x + 257, y - 20, 78, 54);
		add(noDecaffein);
		add(toDecaffein);
		new GroupButtons(noDecaffein, toDecaffein, "noDecaffein", "toDecaffein", 78, 54);
	}

	public void cup(int x, int y) {
		add(wi.makeLabel("selectCup.png", x, y, 66, 17));
		JButton useDisposal = wi.makeButton("useDisposal.png", x + 173, y - 20, 78, 54);
		JButton useTumbler = wi.makeButton("useTumbler.png", x + 257, y - 20, 78, 54);
		add(useDisposal);
		add(useTumbler);
		new GroupButtons(useDisposal, useTumbler, "useDisposal", "useTumbler", 78, 54);
	}

	public void sizes(int x, int y) {
		add(wi.makeLabel("selectSize.png", x, y, 103, 17));
		JButton S = wi.makeButton("S.png", x + 173, y - 20, 78, 54);
		JButton M = wi.makeButton("M.png", x + 257, y - 20, 78, 54);
		JButton L = wi.makeButton("L.png", x + 343, y - 20, 78, 54);
		add(S);
		add(M);
		add(L);
		new GroupButtons(S, M, L, "S", "M", "L", 78, 54);
	}

	public void shot(int x, int y) {
		add(wi.makeLabel("selectShot.png", x, y, 68, 18));
		JButton noShot = wi.makeButton("noShot.png", x + 173, y - 20, 78, 54);
		JButton oneShot = wi.makeButton("oneShot.png", x + 257, y - 20, 78, 54);
		JButton twoShot = wi.makeButton("twoShot.png", x + 343, y - 20, 78, 54);
		add(noShot);
		add(oneShot);
		add(twoShot);
		new GroupButtons(noShot, oneShot, twoShot, "noShot", "oneShot", "twoShot", 78, 54);
	}

	public void ice(int x, int y) {
		add(wi.makeLabel("selectIce.png", x, y, 83, 17));
		JButton normalIce = wi.makeButton("normalIce.png", x + 173, y - 20, 78, 54);
		JButton lessIce = wi.makeButton("lessIce.png", x + 257, y - 20, 78, 54);
		JButton noIce = wi.makeButton("noIce.png", x + 343, y - 20, 78, 54);
		add(normalIce);
		add(lessIce);
		add(noIce);
		new GroupButtons(normalIce, lessIce, noIce, "normalIce", "lessIce", "noIce", 78, 54);
	}

	public void milk(int x, int y) {
		add(wi.makeLabel("selectMilk.png", x, y, 85, 16));
		JButton basicMilk = wi.makeButton("basicMilk.png", x + 173, y - 20, 78, 54);
		JButton toSoy = wi.makeButton("toSoy.png", x + 257, y - 20, 78, 54);
		JButton toLowfat = wi.makeButton("toLowfat.png", x + 343, y - 20, 78, 54);
		add(basicMilk);
		add(toSoy);
		add(toLowfat);
		new GroupButtons(basicMilk, toSoy, toLowfat, "basicMilk", "toSoy", "toLowfat", 78, 54);
	}
}
