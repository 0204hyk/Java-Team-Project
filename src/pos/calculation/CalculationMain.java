package pos.calculation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pos.calculation.button.CalcEscapeButton;
import pos.calculation.button.CoffeeMenu;
import pos.calculation.button.NonCoffeeMenu;
import pos.calculation.button.PaymentButton;
import pos.salescheck.component.title.DigitalClock;
import pos.salescheck.component.title.TitleImage;

public class CalculationMain extends JFrame {

	
	
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
		
		// 커피 카테고리 버튼
		JButton test = new JButton("커피");
		// 커피 메뉴 <- 커피를 눌렀을 때 나옴
	
		test.setBounds(550, 110, 150, 100);
		test.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CalculationMain main = new CalculationMain();
				JPanel coffeePanel = new CoffeeMenu();
				main.add(coffeePanel);
				
				
			}
		});
		
		

		
		// 논 커피 카테고리 버튼 
		JButton nonBtn = new JButton("논커피");
		nonBtn.setBounds(695, 110, 150, 100);

		// 논커피 카테고리 메뉴
		JPanel nonCoffeePanel = new NonCoffeeMenu();
		
		nonBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CalculationMain main = new CalculationMain();
				JPanel noncoffeePanel = new NonCoffeeMenu();
				main.add(noncoffeePanel);
				
				
			}
		});


		
		
	
		
		
		
		add(titleBar);
		add(menuList);
		add(test);
		add(nonBtn);
//		add(coffeePanel);
//		add(nonCoffeePanel);
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
	
	public static void main(String[] args) {
		new CalculationMain();
	}
}
