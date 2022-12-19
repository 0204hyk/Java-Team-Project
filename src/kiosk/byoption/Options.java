package kiosk.byoption;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import kiosk.tools.GroupButtons;
import kiosk.tools.WithImage;

public class Options extends JFrame {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);

	String hotAndIce;
	String decaffein;
	String cup;
	String sizes;
	String shot;
	String ice;
	String milk;

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
		TotalCups tc = new TotalCups();
		add(tc);

		add(wi.makeLabel("hy.png", 53, 24, 60, 83));
		add(wi.makeButton("home.png", 543, 44, 52, 52));

		JButton minus = wi.makeButton("minus.png", 420, 170, 32, 32);

		minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (tc.cup > 1) {
					tc.setCup(tc.cup - 1);
				} else if (tc.cup < 1) {
					tc.setCup(tc.cup);
				}
			}
		});

		JButton plus = wi.makeButton("plus.png", 533, 170, 32, 32);

		plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tc.cup > 0) {
				tc.setCup(tc.cup + 1);
				} else if (tc.cup > 98) {
					tc.setCup(tc.cup);
				}

			}
		});

		JButton put = wi.makeButton("put.png", 333, 817, 192, 68);

		put.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println(hotAndIce);
				System.out.println(decaffein);
				System.out.println(cup);
				System.out.println(sizes);
				System.out.println(shot);
				System.out.println(ice);
				System.out.println(milk);
			}
		});

		JButton cancel = wi.makeButton("cancel.png", 124, 815, 192, 68);

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		add(minus);
		add(plus);
		add(put);
		add(cancel);
	}

	public void hotAndIce(int x, int y) {

		add(wi.makeLabel("hot, ice.png", x, y, 45, 16));
		JButton hot = wi.makeButton("hot.png", x + 173, y - 20, 78, 54);
		JButton ice = wi.makeButton("ice.png", x + 257, y - 20, 78, 54);
		add(hot);
		add(ice);

		hot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hotAndIce = "Hot";
			}
		});

		ice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hotAndIce = "Ice";
			}
		});

		new GroupButtons(hot, ice, "hot", "ice", 78, 54);
	}

	public void decaffein(int x, int y) {

		add(wi.makeLabel("changeDecaffein.png", x, y, 119, 17));
		JButton noDecaffein = wi.makeButton("noDecaffein.png", x + 173, y - 20, 78, 54);
		JButton toDecaffein = wi.makeButton("toDecaffein.png", x + 257, y - 20, 78, 54);
		add(noDecaffein);
		add(toDecaffein);
		new GroupButtons(noDecaffein, toDecaffein, "noDecaffein", "toDecaffein", 78, 54);

		noDecaffein.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				decaffein = "NoDecaffein";

			}
		});

		toDecaffein.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				decaffein = "Decaffein";// TODO Auto-generated method stub

			}
		});

	}

	public void cup(int x, int y) {
		add(wi.makeLabel("selectCup.png", x, y, 66, 17));
		JButton useDisposal = wi.makeButton("useDisposal.png", x + 173, y - 20, 78, 54);
		JButton useTumbler = wi.makeButton("useTumbler.png", x + 257, y - 20, 78, 54);
		add(useDisposal);
		add(useTumbler);
		new GroupButtons(useDisposal, useTumbler, "useDisposal", "useTumbler", 78, 54);

		useDisposal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cup = "Disposal";
			}
		});

		useTumbler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cup = "Tumbler";
			}
		});
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

		S.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				sizes = "S";
			}
		});

		M.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sizes = "M";
			}
		});

		L.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sizes = "L";
			}
		});
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

		noShot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				shot = "NoShot";
			}
		});

		oneShot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				shot = "OneShot";
			}
		});

		twoShot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				shot = "TwoShot";
			}
		});
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

		normalIce.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ice = "Normal";
			}
		});

		lessIce.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ice = "Less";
			}
		});

		noIce.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ice = "None";
			}
		});
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

		basicMilk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				milk = "Basic";
			}
		});

		toSoy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				milk = "Soy";
			}
		});

		toLowfat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				milk = "Lowfat";
			}
		});
	}
}
