package pos.calculation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pos.calculation.categorybutton.CalcEscapeButton;
import pos.calculation.categorybutton.PaymentButton;
import pos.calculation.menubutton.CoffeeMenu;
import pos.calculation.menubutton.FrappeBlendedMenu;
import pos.calculation.menubutton.NonCoffeeMenu;
import pos.calculation.menubutton.TeaAdeMenu;
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
		JPanel nonCoffeePanel = new NonCoffeeMenu();
		JPanel coffeePanel = new CoffeeMenu();
		JPanel teaAdePanel = new TeaAdeMenu();
		JPanel frappeBiendedPanel = new FrappeBlendedMenu();
		
		coffeeCategoryBtn.setBounds(550, 110, 150, 100);
		coffeeCategoryBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nonCoffeePanel.setVisible(false);
				teaAdePanel.setVisible(false);
				frappeBiendedPanel.setVisible(false);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				coffeePanel.setVisible(true);
			}
			
		});
		
		nonCoffeeCategoryBtn.setBounds(695, 110, 150, 100);
		nonCoffeeCategoryBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				coffeePanel.setVisible(false);
				teaAdePanel.setVisible(false);
				frappeBiendedPanel.setVisible(false);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				nonCoffeePanel.setVisible(true);
			}
		});
		
		teaAdeBtn.setBounds(840, 110, 150, 100);
		teaAdeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				coffeePanel.setVisible(false);
				nonCoffeePanel.setVisible(false);
				frappeBiendedPanel.setVisible(false);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				teaAdePanel.setVisible(true);
			}
		});

		frappeBlendedBtn.setBounds(985, 110, 150, 100);
		frappeBlendedBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				coffeePanel.setVisible(false);
				nonCoffeePanel.setVisible(false);
				teaAdePanel.setVisible(false);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				frappeBiendedPanel.setVisible(true);
			}
		});


		add(titleBar);
		add(menuList);
		add(coffeeCategoryBtn);
		add(coffeePanel);
		add(nonCoffeeCategoryBtn);
		add(nonCoffeePanel);
		add(teaAdeBtn);
		add(teaAdePanel);
		add(frappeBlendedBtn);
		add(frappeBiendedPanel);
		add(menuCategory);
		add(calcEscapeBtn);
		add(paymentBtn);
		setBackground(Color.BLACK);
		setLayout(null);
		setSize(1200, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CalculationMain();
	}
}
