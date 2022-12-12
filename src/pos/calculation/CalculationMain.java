package pos.calculation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pos.calculation.button.CalcEscapeButton;
import pos.calculation.button.CoffeeMenu;
import pos.calculation.button.FrappeBlendedMenu;
import pos.calculation.button.NonCoffeeMenu;
import pos.calculation.button.PaymentButton;
import pos.calculation.button.TeaAdeMenu;
import pos.salescheck.component.title.DigitalClock;
import pos.salescheck.component.title.TitleImage;

public class CalculationMain extends JFrame {

	// 카테고리 버튼들
	private static JButton coffeeCategoryBtn = new JButton("커피");
	private static JButton nonCoffeeCategoryBtn = new JButton("논커피");
	private static JButton teaAdeBtn = new JButton("티/에이드");
	private static JButton frappeBlendedBtn = new JButton("프라페/블렌디드");


	public CalculationMain() {
		// 메뉴 상단 타이틀 구현
		JLabel calcCenterTitle = new DigitalClock();
		calcCenterTitle.setBounds(1000, 10, 400, 30);
		JPanel titleBar = new TitleImage();
		titleBar.add(calcCenterTitle);

		// 주문 리스트 구현 ----
		JLabel menuList = new CalcView();

		// 뒤로가기 버튼 구현
		JButton calcEscapeBtn = new CalcEscapeButton();

		// 결제버튼 구현
		JButton paymentBtn = new PaymentButton();

		// 메뉴 카테고리 배경 
		JLabel menuCategory = new MenuCategoryView();

		// 커피 버튼 및 카테고리들 ---
		coffeeCategoryBtn.setBounds(550, 110, 150, 100);
		coffeeCategoryBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				coffee();
			}
		});

		nonCoffeeCategoryBtn.setBounds(695, 110, 150, 100);
		nonCoffeeCategoryBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nonCoffee();
			}
		});

		teaAdeBtn.setBounds(840, 110, 150, 100);
		teaAdeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				teaAde();
			}
		});

		add(titleBar);
		add(menuList);
		add(coffeeCategoryBtn);
		add(nonCoffeeCategoryBtn);
		add(teaAdeBtn);
		add(frappeBlendedBtn);
		add(menuCategory);
		add(calcEscapeBtn);
		add(paymentBtn);
		setBackground(Color.BLACK);
		setLayout(null);
		setLocationRelativeTo(null);
		setSize(1200, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	public void coffee() {
		CalculationMain main = new CalculationMain();
		JPanel coffeePanel = new CoffeeMenu();
		JPanel nonCoffeePanel = new NonCoffeeMenu();
		JPanel teaAdePanel = new TeaAdeMenu();
		JPanel frappeBlendedPanel = new FrappeBlendedMenu();
		nonCoffeePanel.setVisible(false);
		teaAdePanel.setVisible(false);
		frappeBlendedPanel.setVisible(false);
		coffeePanel.setVisible(true);
		main.add(coffeePanel);
	}

	public void teaAde() {
		CalculationMain main = new CalculationMain();
		JPanel coffeePanel = new CoffeeMenu();
		JPanel nonCoffeePanel = new NonCoffeeMenu();
		JPanel teaAdePanel = new TeaAdeMenu();
		JPanel frappeBlendedPanel = new FrappeBlendedMenu();
		frappeBlendedPanel.setVisible(false);
		nonCoffeePanel.setVisible(false);
		coffeePanel.setVisible(false);
		teaAdePanel.setVisible(true);
		main.add(teaAdePanel);

	}

	public void nonCoffee() {

		CalculationMain main = new CalculationMain();
		JPanel nonCoffeePanel = new NonCoffeeMenu();
		nonCoffeePanel.setVisible(true);
		main.add(nonCoffeePanel);

	}

	public void frappeBlended() {
		frappeBlendedBtn.setBounds(985, 110, 150, 100);
		frappeBlendedBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CalculationMain main = new CalculationMain();
				JPanel coffeePanel = new CoffeeMenu();
				JPanel nonCoffeePanel = new NonCoffeeMenu();
				JPanel teaAdePanel = new TeaAdeMenu();
				JPanel frappeBlendedPanel = new FrappeBlendedMenu();
				//				coffeePanel.setVisible(false);
				//				nonCoffeePanel.setVisible(false);
				//				teaAdePanel.setVisible(false);
				frappeBlendedPanel.setVisible(true);
				main.add(frappeBlendedPanel);

			}
		});

	}


	public static void main(String[] args) {
		new CalculationMain();
	}
}
