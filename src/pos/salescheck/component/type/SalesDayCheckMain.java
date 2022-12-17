package pos.salescheck.component.type;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.jfree.chart.ChartPanel;

import pos.DigitalClock;
import pos.ImageScaledTool;
import pos.closing.closing_main.container.ClosingImagePanel;
import pos.salescheck.component.button.SalesEscapeButton;
import pos.salescheck.component.button.SalesSearchButton;
import pos.salescheck.component.chart.DayChart;
import pos.salescheck.component.chart.SalesChart;
import pos.salescheck.component.datecombo1.DayComboBox;
import pos.salescheck.component.datecombo1.MonthComboBox;
import pos.salescheck.component.datecombo1.YearComboBox;
import pos.salescheck.component.saleslist.ListImgLabel;
import pos.salescheck.component.saleslist.TitleLabel;
import pos.salescheck.component.saleslist.TotalLabel;
import pos.salescheck.component.table.SalesTable;

public class SalesDayCheckMain extends JFrame {
	
	
	public SalesDayCheckMain() {
		
		// 매출요약 상단 메뉴바 생성.
		JPanel title = new ClosingImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/상단 메뉴바.png", 1200, 60));
		title.setBounds(0 ,0, 1200, 60);
		
		// 현재 시간 출력
		JLabel clock = new DigitalClock();
		clock.setBounds(375, 10, 400, 30);
		title.add(clock);
		
		// 일 매출요약 차트 구현
		DayChart chart = new DayChart();
		
		// 매출요약 콤보박스 구현
		JComboBox yearCombo = new YearComboBox();
		JComboBox monthCombo = new MonthComboBox();
		JComboBox dayCombo = new DayComboBox();
		
		// 매출요약 검색 버튼 구현
		JButton searchBtn = new SalesSearchButton(yearCombo, monthCombo, dayCombo);
	
		// 매출요약 뒤로가기 구현
		JButton escapeBtn = new SalesEscapeButton(this);
		
		// 매출요약 리스트 구현
		JLabel list = new ListImgLabel();
		JTable table = new SalesTable();
		
		// 매출요약
		JLabel salesTitle = new TitleLabel();
		JLabel total = new TotalLabel();
		
	
		add(title);
		add(yearCombo);
		add(monthCombo);
		add(dayCombo);
		add(searchBtn);
		add(escapeBtn);
		add(salesTitle);
		add(total);
		add(table);
		add(list);
		add(chart);
		setSize(1200, 800);
		getContentPane().setBackground(new Color(64, 64, 64));
		setLayout(null);
		setResizable(false);	// 사이즈 조절 불가능하게 만들기
		setLocationRelativeTo(null);	// 창 화면 가운데에 나오게하기
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}



//	public static void main(String[] args) {
//		
//		new SalesCheckMainFrame();
//		
//	}

}
