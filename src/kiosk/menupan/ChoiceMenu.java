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

import kiosk.Step1Step2;
import kiosk.byoption.Cups;
import kiosk.tools.WithImage;

public class ChoiceMenu extends JFrame {

	String root = "images/KioskImages/3. 메뉴선택";
	WithImage wi = new WithImage(root);

	CardLayout card;

	JPanel coffeePns;

	JPanel coffeePn = new PanelsByCategory(2);
	JPanel frappePn = new PanelsByCategory(3);
	JPanel noncoffeePn = new PanelsByCategory(4);
	JPanel adePn = new PanelsByCategory(5);

	JPanel cart = new JPanel();

	ArrayList<String> menuInfo = new ArrayList<>();

	public ChoiceMenu() {

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
		coffeePns = new JPanel(card);

		int x = 22;
		int y = 130;

		JButton popular = wi.makeButton("인기메뉴.png", x, y, 110, 46);
		JButton coffee = wi.makeButton("커피.png", x + 124, y, 110, 46);
		JButton noncoffee = wi.makeButton("논커피.png", x + 248, y, 110, 46);
		JButton frappe = wi.makeButton("프라페.png", x + 372, y, 110, 46);
		JButton ade = wi.makeButton("에이드.png", x + 496, y, 110, 46);

		coffeePns.add(coffeePn);
		coffeePns.setBounds(74, 212, 503, 508);

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
				card.next(coffeePns);
			}
		});

		JButton right = wi.makeButton("right.png", 596, 448, 40, 40);
		right.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				card.previous(coffeePns);
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
		// 장바구니에 있는것들 보내기
		JButton pay = wi.makeButton("pay.png", 548, 748, 78, 93);

		pay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 총 금액의 10프로 보내기(포인트)
				new Step1Step2(getTotalAmounts(), menuInfo);

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
		for (int i = 2; i < menuInfo.size(); i += 4) {
			total += Integer.parseInt(menuInfo.get(i));

		}

		return total / 10;
	}

	public static void main(String[] args) {

		Options.choiceMenu = new ChoiceMenu();
	}

}
