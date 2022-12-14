package kiosk.byoption;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import kiosk.tools.GroupButtons;

public class All extends JFrame {

	String root = "images/KioskImages/4. detailedOption";

	public All() {

		JLabel totalCups = new JLabel("2잔"); // 잔 수
		totalCups.setFont(new Font("맑은 고딕", Font.PLAIN, 19));
		totalCups.setForeground(Color.black);
		totalCups.setBounds(356, 755, 33, 20);
		add(totalCups);

		JLabel amounts = new JLabel("7600원"); // 총 가격
		amounts.setFont(new Font("맑은 고딕", Font.BOLD, 27));
		amounts.setForeground(Color.black);
		amounts.setBounds(475, 749, 98, 30);
		add(amounts);

		add(makeLabel("menu/coffee/바닐라 라떼 Vanilla Latte.png", 230, 140, 112, 130)); // 커피 사진

		JLabel nameKor = new JLabel("바닐라 라떼"); // 커피 이름 한글
		nameKor.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		nameKor.setForeground(Color.black);
		nameKor.setBounds(313, 202, 150, 35);
		add(nameKor);

		JLabel nameEng = new JLabel("Vanilla Latte"); // // 커피 이름 영문
		nameEng.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		nameEng.setForeground(new Color(151, 160, 157));
		nameEng.setBounds(314, 226, 150, 25);
		add(nameEng);

		// 고정 값 -----------------------------------------------------------------
		add(makeLabel("hy.png", 53, 24, 60, 83));
		add(makeButton("home.png", 543, 44, 52, 52));

		add(makeLabel("hot, ice.png", 46, 313, 90, 14));
		JButton hot = makeButton("hot.png", 34, 336, 79, 73);
		JButton ice = makeButton("ice.png", 123, 336, 79, 73);
		add(hot);
		add(ice);
		new GroupButtons(hot, ice, "hot", "ice", 79, 73);

		add(makeLabel("changeDecaffein.png", 251, 309, 114, 17));
		JButton noDecaffein = makeButton("noDecaffein.png", 238, 337, 79, 73);
		JButton toDecaffein = makeButton("toDecaffein.png", 327, 337, 79, 73);
		add(noDecaffein);
		add(toDecaffein);
		new GroupButtons(noDecaffein, toDecaffein, "noDecaffein", "toDecaffein", 79, 73);

		add(makeLabel("selectCup.png", 453, 312, 59, 17));
		JButton useDisposal = makeButton("useDisposal.png", 446, 337, 79, 73);
		JButton useTumbler = makeButton("useTumbler.png", 535, 336, 79, 73);
		add(useDisposal); add(useTumbler);
		new GroupButtons(useDisposal, useTumbler, "useDisposal", "useTumbler", 79, 73);

		add(makeLabel("selectSize.png", 44, 446, 97, 17));
		JButton S = makeButton("S.png", 35, 471, 79, 73);
		JButton M = makeButton("M.png", 124, 471, 79, 73);
		JButton L = makeButton("L.png", 214, 471, 79, 73);
		add(S); add(M); add(L);
		new GroupButtons(S, M, L, "S", "M", "L", 79, 73);

		add(makeLabel("selectShot.png", 368, 445, 61, 18));
		JButton noShot = makeButton("noShot.png", 356, 471, 79, 73);
		JButton oneShot = makeButton("oneShot.png", 445, 471, 79, 73);
		JButton twoShot = makeButton("twoShot.png", 535, 471, 79, 73);
		add(noShot); add(oneShot); add(twoShot);
		new GroupButtons(noShot, oneShot, twoShot, "noShot", "oneShot", "twoShot", 79, 73);
		
		add(makeLabel("selectIce.png", 45, 589, 77, 17));
		JButton normalIce = makeButton("normalIce.png", 35, 619, 79, 73);
		JButton lessIce = makeButton("lessIce.png", 124, 619, 79, 73);
		JButton noIce = makeButton("noIce.png", 215, 619, 79, 73);
		add(normalIce); add(lessIce); add(noIce);
		new GroupButtons(normalIce, lessIce, noIce, "normalIce", "lessIce", "noIce", 79, 73);

		add(makeLabel("selectMilk.png", 367, 592, 74, 16));
		JButton basicMilk = makeButton("basicMilk.png", 357, 619, 79, 73);
		JButton toSoy = makeButton("toSoy.png", 447, 619, 79, 73);
		JButton toLowfat = makeButton("toLowfat.png", 536, 619, 79, 73);
		add(basicMilk); add(toSoy); add(toLowfat);
		new GroupButtons(basicMilk, toSoy, toLowfat, "basicMilk", "toSoy", "toLowfat", 79, 73);

		add(makeButton("minus.png", 311, 755, 18, 18));
		add(makeButton("plus.png", 410, 755, 18, 18));

		add(makeButton("put.png", 204, 819, 192, 68));
		add(makeButton("pay.png", 415, 819, 192, 68));

		setUndecorated(true);
		setLayout(null);
		setSize(650, 950);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);

	}

	public JLabel makeLabel(String detailedRoot, int x, int y, int w, int h) {
		JLabel lb = new JLabel();

		lb.setIcon(new ImageIcon(readImage(root + "/" + detailedRoot, w, h)));
		lb.setBounds(x, y, w, h);

		return lb;
	}

	public JButton makeButton(String detailedRoot, int x, int y, int w, int h) {
		JButton bt = new JButton();

		bt.setIcon(new ImageIcon(readImage(root + "/" + detailedRoot, w, h)));
		bt.setBounds(x, y, w, h);
		bt.setBorderPainted(false);
		bt.setContentAreaFilled(false);
		bt.setPressedIcon(new ImageIcon(readImage(root + " Selected/" + detailedRoot, w, h)));

		return bt;
	}

	public Image readImage(String root, int w, int h) {

		BufferedImage image;
		Image scaled = null;
		try {
			image = ImageIO.read(new File(root));
			scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return scaled;
	}

	public static void main(String[] args) {
		new All();
//		new NoDecafAndMilk();
//		new NoHot();
//		new NoHotAndMilk();
//		new NoHotAndDecaf();
//		new NoMilk();
	}
}
