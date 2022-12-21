package kiosk.menupan;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import database.kiosk.GetImageInfo;
import kiosk.byoption.Options;
import kiosk.byoption.TotalCups;
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

	public ChoiceMenu() {

		defaults();
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
		JButton pay = wi.makeButton("pay.png", 548, 748, 78, 93);
		JButton deleteAll = wi.makeButton("deleteAll.png", 548, 854, 78, 71);

		add(pay);
		add(deleteAll);
	}

	// 메뉴 한줄씩 만들어서 리턴해주기, 리턴할때마다 한칸 밑으로..
	// 옵션 프레임에서 정보 받아와서 넘기기!
	// 메뉴명, 온도
	public void aMenu(String menu, String temparature) {
		String root = "images/KioskImages/3. 메뉴선택";
		WithImage wi = new WithImage(root);
		DecimalFormat df = new DecimalFormat("#,###");
		GetImageInfo gi = new GetImageInfo(menu);

		// 패널 생성
		JPanel menuInCart = new JPanel();
		menuInCart.setOpaque(false);
		menuInCart.setBorder(null);
		menuInCart.setLayout(null);
		menuInCart.setBounds(31, 743, 505, 41);
		menuInCart.setVisible(true);

		int x = 0, y = 0;

		// 음료 이름
		String menuName = "";
		if (temparature == null) {
			menuName = menu + " (ICE ONLY) ";
		} else {
			menuName = menu + " (" + temparature.toUpperCase() + ") ";
		}

		JLabel menuNamelb = new JLabel(menuName);
		menuNamelb.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		menuNamelb.setBounds(x + 45, y + 5, 200, 32);

		// 가격
		String price = df.format(gi.getMenuPrice() * TotalCups.cup) + "원";
		JLabel menuPricelb = new JLabel(price);
		menuPricelb.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		menuPricelb.setBounds(x + 250, y + 5, 70, 32);

		// 잔 수
		JLabel cups = new JLabel(TotalCups.cup + "잔");
		cups.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		cups.setBounds(x + 374, y + 9, 35, 22);
		cups.setHorizontalAlignment(JLabel.CENTER);

		// 더하기 버튼
		JButton plus = wi.makeButton("plus.png", x + 419, y + 11, 18, 18);
		plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (TotalCups.cup > 0) {
					TotalCups.cup = TotalCups.cup + 1;
				} else if (TotalCups.cup > 98) {
					TotalCups.cup = 99;
				}
				cups.setText(TotalCups.cup + "잔");
				menuPricelb.setText(df.format(gi.getMenuPrice() * TotalCups.cup) + "원");

			}
		});

		// 빼기
		JButton minus = wi.makeButton("minus.png", x + 344, y + 11, 18, 18);
		minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (TotalCups.cup > 1) {
					TotalCups.cup = TotalCups.cup - 1;
				} else if (TotalCups.cup < 1) {
					TotalCups.cup = 1;
				}
				cups.setText(TotalCups.cup + "잔");
				menuPricelb.setText(df.format(gi.getMenuPrice() * TotalCups.cup) + "원");
			}
		});

		// 삭제 버튼
		JButton delete = wi.makeButton("delete.png", x + 457, y + 5, 31, 31);

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});

		int num = 1;
		// 음료 순번
		menuInCart.add(wi.makeLabel(num + ".png", x + 4, y + 5, 31, 31));

		menuInCart.add(cups);
		menuInCart.add(menuNamelb);
		menuInCart.add(menuPricelb);
		menuInCart.add(plus);
		menuInCart.add(minus);
		menuInCart.add(delete);

		menuInCart.setVisible(true);
		menuInCart.invalidate();

		add(menuInCart);
		
	}

	public static void main(String[] args) {

		Options.choiceMenu = new ChoiceMenu();
	}

}
