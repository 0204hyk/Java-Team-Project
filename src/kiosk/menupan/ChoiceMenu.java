package kiosk.menupan;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import database.kiosk.CheckMenuByCategories;
import kiosk.Step1Step2;
import kiosk.byoption.Cups;
import kiosk.tools.WithImage;

public class ChoiceMenu extends JFrame {

	String root = "images/KioskImages/3. 메뉴선택";
	WithImage wi = new WithImage(root);
	
	int category = 0;
	
	ChoiceMenu f;
	
	CardLayout card;

	JPanel cardPanel;

	JPanel coffeePn = PanelsByCategory(2);
	JPanel frappePn = PanelsByCategory(3);
	JPanel noncoffeePn = PanelsByCategory(4);
	JPanel adePn = PanelsByCategory(5);

	JPanel coffeePn2 = PanelsByCategory2(2);
	JPanel frappePn2 = PanelsByCategory2(3);
	JPanel noncoffeePn2 = PanelsByCategory2(4);
	JPanel adePn2 = PanelsByCategory2(5);

	JPanel cart = new JPanel();

	ArrayList<String> menuInfo = new ArrayList<>();

	public ChoiceMenu() {
		this.f = this;
		cart();

		add(wi.makeLabel("hy.png", 53, 24, 60, 83));

		tabs();
		pay();

		setUndecorated(true);
		setLayout(null);
		setSize(650, 950);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);

		setVisible(true);
	}

	public void tabs() {
		
		// 카테고리 탭
		card = new CardLayout();
		cardPanel = new JPanel(card);

		int x = 22;
		int y = 130;

		JButton popular = wi.makeButton("인기메뉴.png", x, y, 110, 46);
		JButton coffee = wi.makeButton("커피.png", x + 124, y, 110, 46);
		JButton noncoffee = wi.makeButton("논커피.png", x + 248, y, 110, 46);
		JButton frappe = wi.makeButton("프라페.png", x + 372, y, 110, 46);
		JButton ade = wi.makeButton("에이드.png", x + 496, y, 110, 46);

		cardPanel.add(coffeePn);
		cardPanel.setBounds(74, 212, 503, 508);

		add(coffeePn);
		add(frappePn);
		add(noncoffeePn);
		add(adePn);

		add(noncoffeePn2);
		add(frappePn2);
		add(coffeePn2);
		add(adePn2);

		// 해당 카테고리 커피들이 뜨도록 하기
		coffee.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showCoffe();
				category = 1;
			}
		});

		frappe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showFrappe();
				category = 2;
			}
		});

		noncoffee.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showNonCoffee();
				category = 3;
			}
		});

		ade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showAde();
				category = 4;
			}
		});

		JButton left = wi.makeButton("left.png", 11, 448, 40, 40);

		left.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (category == 1) {
					showCoffe();

				} else if (category == 2) {
					showFrappe();
				} else if (category == 3) {
					showNonCoffee();
				} else if (category == 4) {
					showAde();
				}
			}
		});

		JButton right = wi.makeButton("right.png", 596, 448, 40, 40);
		right.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (category == 1) {
					showCoffe2();

				} else if (category == 2) {
					showFrappe2();

				} else if (category == 3) {
					showNonCoffee2();

				} else if (category == 4) {
					showAde2();

				}
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

		coffeePn2.setVisible(false);
		frappePn2.setVisible(false);
		adePn2.setVisible(false);
		noncoffeePn2.setVisible(false);

	}

	public void showFrappe() {
		coffeePn.setVisible(false);
		frappePn.setVisible(true);
		noncoffeePn.setVisible(false);
		adePn.setVisible(false);

		coffeePn2.setVisible(false);
		frappePn2.setVisible(false);
		adePn2.setVisible(false);
		noncoffeePn2.setVisible(false);
	}

	public void showNonCoffee() {
		coffeePn.setVisible(false);
		frappePn.setVisible(false);
		noncoffeePn.setVisible(true);
		adePn.setVisible(false);

		coffeePn2.setVisible(false);
		frappePn2.setVisible(false);
		adePn2.setVisible(false);
		noncoffeePn2.setVisible(false);
	}

	public void showAde() {
		coffeePn.setVisible(false);
		frappePn.setVisible(false);
		noncoffeePn.setVisible(false);
		adePn.setVisible(true);

		coffeePn2.setVisible(false);
		frappePn2.setVisible(false);
		adePn2.setVisible(false);
		noncoffeePn2.setVisible(false);
	}

	public void showCoffe2() {
		coffeePn.setVisible(false);
		frappePn.setVisible(false);
		noncoffeePn.setVisible(false);
		adePn.setVisible(false);

		coffeePn2.setVisible(true);
		frappePn2.setVisible(false);
		adePn2.setVisible(false);
		noncoffeePn2.setVisible(false);

	}

	public void showFrappe2() {
		coffeePn.setVisible(false);
		frappePn.setVisible(false);
		noncoffeePn.setVisible(false);
		adePn.setVisible(false);

		coffeePn2.setVisible(false);
		frappePn2.setVisible(true);
		adePn2.setVisible(false);
		noncoffeePn2.setVisible(false);

	}

	public void showAde2() {
		coffeePn.setVisible(false);
		frappePn.setVisible(false);
		noncoffeePn.setVisible(false);
		adePn.setVisible(false);

		coffeePn2.setVisible(false);
		frappePn2.setVisible(false);
		adePn2.setVisible(true);
		noncoffeePn2.setVisible(false);

	}

	public void showNonCoffee2() {
		coffeePn.setVisible(false);
		frappePn.setVisible(false);
		noncoffeePn.setVisible(false);
		adePn.setVisible(false);

		coffeePn2.setVisible(false);
		frappePn2.setVisible(false);
		adePn2.setVisible(false);
		noncoffeePn2.setVisible(true);

	}

	public void pay() {
		// 장바구니에 있는것들 보내기
		JButton pay = wi.makeButton("pay.png", 548, 748, 78, 93);

		pay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 총 금액의 10프로 보내기(포인트)
				new Step1Step2(getTotalAmounts(), menuInfo, f);

			}
		});

		add(pay);
	}

	public void cart() {
		JScrollPane scrollCart = new JScrollPane();
		JPanel bg = new JPanel();

		scrollCart.setBorder(null);
		scrollCart.setBackground(Color.white);
		scrollCart.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollCart.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		cart.setLayout(new BoxLayout(cart, BoxLayout.Y_AXIS));
		scrollCart.setViewportView(bg);
		bg.add(cart);
		scrollCart.setBounds(23, 747, 517, 180);
		add(scrollCart);

	}

	public void makeMenu(JPanel pn, Cups totalCups, ArrayList menuInfo) {

		cart.add(pn);

		// 메뉴,잔,최종금액,옵션
		this.menuInfo.addAll(menuInfo);
	}

	public int getTotalAmounts() {

		int total = 0;
		for (int i = 2; i < menuInfo.size(); i += 5) {
			total += Integer.parseInt(menuInfo.get(i));

		}

		return total / 10;
	}

	public int getMenuPosition(String name) {
		int position = 3;
		for (int i = 3; i < menuInfo.size(); i += 4) {
			if (name == menuInfo.get(i)) {
				position = i;
			}
		}
		return position - 3;
	}

	public JPanel PanelsByCategory(int ctgNum) {
		CheckMenuByCategories mc = new CheckMenuByCategories(ctgNum);
		JPanel PBC = new JPanel();
		int x = 0, y = 0;

		for (int i = 0; i < mc.getListSize(); i++) {

			PBC.add(new MakeMenuButton(ctgNum, mc.getOptionNumber().get(i), mc.getMenu().get(i), x, y));
			x += 176;
			if (i == 2 || i == 5 || i == 8) {
				x = 0;
				y += 176;
			}
		}
		// 550

		PBC.setBounds(74, 212, 503, 508);
		PBC.setLayout(null);
		PBC.setBackground(Color.WHITE);
		PBC.setBorder(null);
		PBC.setVisible(false);
		return PBC;
	}

	public JPanel PanelsByCategory2(int ctgNum) {

		CheckMenuByCategories mc = new CheckMenuByCategories(ctgNum);
		JPanel PBC2 = new JPanel();
		int x = 0, y = 0;

		for (int i = 0; i < mc.getListSize(); i++) {

			if (mc.getListSize() < 10) {
				PBC2 = PanelsByCategory(ctgNum);
				break;

			} else {

				if (i >= 9) {

					PBC2.add(new MakeMenuButton(ctgNum, mc.getOptionNumber().get(i), mc.getMenu().get(i), x, y));
					x += 176;
					if (i == 2 || i == 5 || i == 8) {
						x = 0;
						y += 176;
					}
				}
			}

		}
		PBC2.setBounds(74, 212, 503, 508);
		PBC2.setLayout(null);
		PBC2.setBackground(Color.WHITE);
		PBC2.setBorder(null);
		PBC2.setVisible(false);
		return PBC2;
	}

	public static void main(String[] args) {

		Options.choiceMenu = new ChoiceMenu();
	}

}
