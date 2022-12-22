package pos.sales_summary.main;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import pos.DigitalClock;
import pos.ImagePanel;
import pos.ImageScaledTool;
import pos.sales_summary.button.SalesEscapeButton;
import pos.sales_summary.button.SalesSearchButton;
import pos.sales_summary.chart.DayChart;
import pos.sales_summary.combobox.DayComboBox;
import pos.sales_summary.combobox.MonthComboBox;
import pos.sales_summary.combobox.YearComboBox;
import pos.sales_summary.panel.TitlePanel;
import pos.sales_summary.panel.TotalPanel;
import pos.sales_summary.table.SalesDayTable;
import pos.sales_summary.title.ListImgLabel;

public class SalesDayCheckMain extends JFrame {

	// 일별 매출
	public SalesDayCheckMain() {

		// 매출요약 상단 메뉴바 생성.
		JPanel title = new ImagePanel(ImageScaledTool.getScaledImage(
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
		JTable table = new SalesDayTable();

		// 매출요약 테이블 상단 하단
		JPanel salesTitle = new TitlePanel();
		JPanel total = new TotalPanel();


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
		setUndecorated(true);     
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
