package kiosk.menupan;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import kiosk.byoption.Options;
import kiosk.tools.WithImage;

public class ChoiceMenu extends JFrame {

	String root = "images/KioskImages/3. 메뉴선택";
	WithImage wi = new WithImage(root);

	CardLayout card;
	JPanel coffeePns;

	JPanel coffeePn = new PanelsByCategory(2, 9);
	JPanel coffeePn1 = new PanelsByCategory(2, 1);
	JPanel frappePn = new PanelsByCategory(3, 9);
	JPanel noncoffeePn = new PanelsByCategory(4, 5);
	JPanel adePn = new PanelsByCategory(5, 3);
	
	static public AMenu one;
	public AMenu two;
	public AMenu three;
	public AMenu four;
	public AMenu five;
	public AMenu six;
	public AMenu seven;
	public AMenu eight;
	
	public ChoiceMenu() {
		
		defaults();
		tabs();
		pay();
		
		
		one = new AMenu(1,"에스프레소","HOT");
		two = new AMenu(2,"에스프레소","HOT");
		three = new AMenu(3,"에스프레소","HOT");
//		four = new AMenu("에스프레소","HOT");
//		five = new AMenu("에스프레소","HOT");
//		six = new AMenu("에스프레소","HOT");
//		seven = new AMenu("에스프레소","HOT");
//		eight = new AMenu("에스프레소","HOT");
		
		add(one);
		add(two);
		add(three);
//		add(four);
//		add(five);
//		add(six);
//		add(seven);
//		add(eight);
		
		
		setUndecorated(true);
		setLayout(null);
		setSize(650, 950);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void defaults() {

		add(wi.makeLabel("hy.png", 53, 24, 60, 83));
		JButton home = wi.makeButton("home.png", 543, 44, 52, 52);

		add(home);

	}

	public void tabs() {
		// 카테고리 탭
		card = new CardLayout();
		coffeePns = new JPanel(card);

//		coffeePn1 = new PanelsByCategory(2, 1);

		int x = 22;
		int y = 130;

		JButton popular = wi.makeButton("인기메뉴.png", x, y, 110, 46);
		JButton coffee = wi.makeButton("커피.png", x + 124, y, 110, 46);
		JButton noncoffee = wi.makeButton("논커피.png", x + 248, y, 110, 46);
		JButton frappe = wi.makeButton("프라페.png", x + 372, y, 110, 46);
		JButton ade = wi.makeButton("에이드.png", x + 496, y, 110, 46);

		coffeePns.add(coffeePn);
//		coffeePns.add(coffeePn1);
		coffeePns.setBounds(74, 212, 503, 508);

//		add(coffeePns);
		add(coffeePn);
		add(frappePn);
		add(noncoffeePn);
		add(adePn);
		
		// 해당 카테고리 커피들이 뜨도록 하기
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
				card.next(coffeePn);
			}
		});

		JButton right = wi.makeButton("right.png", 596, 448, 40, 40);
		right.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.previous(coffeePn);
			}
		});

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

	
	public void pay() {
		JButton pay = wi.makeButton("pay.png", 548, 748, 78, 93);
		JButton deleteAll = wi.makeButton("deleteAll.png", 548, 854, 78, 71);

		add(pay);
		add(deleteAll);
	}
	
	public void cart() {
		

		
	}
	
	
	
	public static void main(String[] args) {
		
		Options.choiceMenu = new ChoiceMenu();
	}

}
