package pos.calculation;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		
		
		
		add(titleBar);
		add(menuList);
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
