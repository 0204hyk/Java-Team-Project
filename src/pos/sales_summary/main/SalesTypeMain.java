package pos.sales_summary.main;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pos.DigitalClock;
import pos.ImagePanel;
import pos.ImageScaledTool;
import pos.sales_summary.button.DayButton;
import pos.sales_summary.button.MonthButton;
import pos.sales_summary.button.SalesTypeEscapeButton;
import pos.sales_summary.button.YearButton;

public class SalesTypeMain extends JFrame{
	
	public SalesTypeMain() {
		// 상단 메뉴바 설정
		JPanel titlePanel = new ImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/상단 메뉴바.png", 1200, 60));
		titlePanel.setBounds(0 ,0, 1200, 60);
		// 현재 시간 출력
		JLabel clock = new DigitalClock();
		clock.setBounds(375, 10, 400, 30);
		titlePanel.add(clock);
		
		add(new SalesTypeEscapeButton(this));
		add(titlePanel);
		add(new DayButton());
		add(new MonthButton());
		add(new YearButton());
		getContentPane().setBackground(new Color(64, 64, 64));	// 프레임 백그라운드 컬러 설정
		setUndecorated(true); // 타이틀바 없애기
		setSize(1200, 800); // 프레임 사이즈
		setLayout(null); 
		setVisible(true); 
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new SalesTypeMain();
	}

}
