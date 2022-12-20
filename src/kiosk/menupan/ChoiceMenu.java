package kiosk.menupan;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import kiosk.tools.WithImage;

public class ChoiceMenu extends JFrame {

	String root = "images/KioskImages/3. 메뉴선택";
	WithImage wi = new WithImage(root);

	CardLayout card = new CardLayout();
	JPanel coffeePanels = new JPanel(card);

	JPanel coffeePn = new PanelsByCategory(2);
	JPanel frappePn = new PanelsByCategory(3);
	JPanel noncoffeePn = new PanelsByCategory(4);
	JPanel adePn = new PanelsByCategory(5);

	public ChoiceMenu() {

		defaults();
		tabs();

		pay();
		cart();

		setUndecorated(true);
		setLayout(null);
		setSize(650, 950);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
	}

	public void defaults() {

		add(wi.makeLabel("hy.png", 53, 24, 60, 83));
		JButton home = wi.makeButton("home.png", 543, 44, 52, 52);

		add(home);

	}

	public void tabs() {
		int x = 22;
		int y = 130;

		JButton popular = wi.makeButton("인기메뉴.png", x, y, 110, 46);
		JButton coffee = wi.makeButton("커피.png", x + 124, y, 110, 46);
		JButton noncoffee = wi.makeButton("논커피.png", x + 248, y, 110, 46);
		JButton frappe = wi.makeButton("프라페.png", x + 372, y, 110, 46);
		JButton ade = wi.makeButton("에이드.png", x + 496, y, 110, 46);

		add(coffeePn);
		add(frappePn);
		add(noncoffeePn);
		add(adePn);

		// 해당 카테고리 커피들이 뜨도록하기
		coffee.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showCoffe();
			}
		});

		frappe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showFrappe();
			}
		});

		noncoffee.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showNonCoffee();
			}
		});

		ade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showAde();
			}
		});

		JButton left = wi.makeButton("left.png", 11, 448, 40, 40);

		left.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.next(coffeePanels);
			}
		});

		JButton right = wi.makeButton("right.png", 596, 448, 40, 40);
		right.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.previous(coffeePanels);
			}
		});

//		coffeePanels.add(coffeePanel);
//		coffeePanels.add(coffeePanel2);
//		add(coffeePanels);
//		coffeePanels.add(left);
//		coffeePanels.add(right);

		add(left);
		add(right);
		add(popular);
		add(coffee);
		add(noncoffee);
		add(frappe);
		add(ade);

	}

	public void showCoffe() {
		coffeePn.setVisible(true);
		frappePn.setVisible(false);
		noncoffeePn.setVisible(false);
		adePn.setVisible(false);
	}

	public void showFrappe() {
		coffeePn.setVisible(false);
		frappePn.setVisible(true);
		noncoffeePn.setVisible(false);
		adePn.setVisible(false);
	}

	public void showNonCoffee() {
		coffeePn.setVisible(false);
		frappePn.setVisible(false);
		noncoffeePn.setVisible(true);
		adePn.setVisible(false);
	}

	public void showAde() {
		coffeePn.setVisible(false);
		frappePn.setVisible(false);
		noncoffeePn.setVisible(false);
		adePn.setVisible(true);
	}

	public void cart() {
		// 스크롤
		JScrollPane scrollablePane = new JScrollPane();
		JLabel menuBg = wi.makeLabel("wholeMenu.png", 25,760,505,391);
		scrollablePane.setViewportView(menuBg);
		scrollablePane.setOpaque(false);
		scrollablePane.getViewport().setOpaque(false);
		scrollablePane.setBounds(25, 760, 505, 391);
//		scrollablePane.setBorder(null);
		add(scrollablePane);
		

	}

	public void pay() {
		JButton pay = wi.makeButton("pay.png", 548, 760, 78, 93);
		JButton deleteAll = wi.makeButton("deleteAll.png", 548, 866, 78, 71);

		add(pay);
		add(deleteAll);
	}

	public static void main(String[] args) {
		new ChoiceMenu();
	}
}
