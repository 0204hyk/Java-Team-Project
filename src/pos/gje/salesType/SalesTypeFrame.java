package pos.gje.salesType;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pos.DigitalClock;
import pos.ImageScaledTool;
import pos.closing.closing_main.container.ClosingImagePanel;
import pos.gje.salesType.component.DayBtn;
import pos.gje.salesType.component.MonthBtn;
import pos.gje.salesType.component.SalesTypeEscapeBtn;
import pos.gje.salesType.component.YearBtn;

public class SalesTypeFrame extends JFrame{
	
	public SalesTypeFrame() {
		// 상단 메뉴바 설정
		JPanel titlePanel = new ClosingImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/상단 메뉴바.png", 1200, 60));
		titlePanel.setBounds(0 ,0, 1200, 60);
		// 현재 시간 출력
		JLabel clock = new DigitalClock();
		clock.setBounds(375, 10, 400, 30);
		titlePanel.add(clock);
		
		add(new SalesTypeEscapeBtn(this));
		add(titlePanel);
		add(new DayBtn());
		add(new MonthBtn());
		add(new YearBtn());
		
		setUndecorated(true); // 타이틀바 없애기
		setSize(1200, 800); // 프레임 사이즈
		setLayout(null); 
		setVisible(true); 
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	
	public static void main(String[] args) {
		new SalesTypeFrame();
	}

}
