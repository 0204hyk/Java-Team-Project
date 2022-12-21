package pos.sales_summary.button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import pos.ImageScaledTool;
import pos.sales_summary.chart.DayChart;
import pos.sales_summary.chart.MonthChart;
import pos.sales_summary.chart.YearChart;
import pos.sales_summary.combobox.DayComboBox;
import pos.sales_summary.combobox.MonthComboBox;
import pos.sales_summary.combobox.YearComboBox;
import pos.sales_summary.saleslist.TitlePanel;
import pos.sales_summary.saleslist.TotalPanel;
import pos.sales_summary.table.SalesDayTable;
import pos.sales_summary.table.SalesMonthTable;
import pos.sales_summary.table.SalesYearTable;

// 매출요약 검색 버튼

public class SalesSearchButton extends JButton {

	ImageScaledTool tool = new ImageScaledTool();
	JComboBox yearBox;
	JComboBox monthBox;
	JComboBox dayBox;
	String year;
	String month;
	String day;

	public SalesSearchButton() {

	}

	public SalesSearchButton(JComboBox yearBox) {
		this.yearBox = yearBox;
		// 매출요약 검색 버튼 이미지 설정.
		setIcon(new ImageIcon(tool.getScaledImage(
				"Images/PosImages/매출 요약 이미지/날짜 검색 버튼.png", 100, 50)));

		// 매출요약 검색 버튼 눌렀을 때 설정.
		setPressedIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/매출 요약 이미지/날짜 검색 버튼 클릭.png", 100, 50)));
		setBounds(450, 90, 100, 50);
		setBorder(null);
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 콤보박스의 값을 String으로 변환 후 변수에 저장.
				year = String.format("%02d",  yearBox.getSelectedItem());

				// String변환 값을 각 생성자에 전달
				SalesYearTable table = new SalesYearTable(year);
				YearChart chart = new YearChart(year);
				TitlePanel title = new TitlePanel(year);
				TotalPanel total = new TotalPanel(year);
			}
		});

		setContentAreaFilled(false);	// 버튼 배경 지우기
		setBorderPainted(false);	// 버튼 테두리 지우기
		setFocusable(false);	
	}

	public SalesSearchButton(JComboBox yearBox, JComboBox monthBox) {
		this.yearBox = yearBox;
		this.monthBox = monthBox;

		// 매출요약 검색 버튼 이미지 설정.
		setIcon(new ImageIcon(tool.getScaledImage(
				"Images/PosImages/매출 요약 이미지/날짜 검색 버튼.png", 100, 50)));

		// 매출요약 검색 버튼 눌렀을 때 설정.
		setPressedIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/매출 요약 이미지/날짜 검색 버튼 클릭.png", 100, 50)));
		setBounds(450, 90, 100, 50);
		setBorder(null);
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 콤보박스의 값을 String으로 변환 후 각 변수에 저장.
				year = String.format("%02d",  yearBox.getSelectedItem());
				month = String.format("%02d", monthBox.getSelectedItem());

				// String변환 값을 각 생성자에 전달
				SalesMonthTable table = new SalesMonthTable(year, month);
				MonthChart chart = new MonthChart(year, month);
				TitlePanel title = new TitlePanel(year, month);
				TotalPanel total = new TotalPanel(year, month);
			}
		});

		setContentAreaFilled(false);	// 버튼 배경 지우기
		setBorderPainted(false);	// 버튼 테두리 지우기
		setFocusable(false);	
	}


	public SalesSearchButton(JComboBox yearBox, JComboBox monthBox, JComboBox dayBox) {
		this.yearBox = yearBox;
		this.monthBox = monthBox;
		this.dayBox = dayBox;

		// 매출요약 검색 버튼 이미지 설정.
		setIcon(new ImageIcon(tool.getScaledImage(
				"Images/PosImages/매출 요약 이미지/날짜 검색 버튼.png", 100, 50)));

		// 매출요약 검색 버튼 눌렀을 때 설정.
		setPressedIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/매출 요약 이미지/날짜 검색 버튼 클릭.png", 100, 50)));


		// 검색버튼 위치 설정.

		setBounds(450, 90, 100, 50);
		setBorder(null);

		// 검색 버튼 액션
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 콤보박스의 값을 String으로 변환 후 각 변수에 저장.
				year = String.format("%02d",  yearBox.getSelectedItem());
				month = String.format("%02d", monthBox.getSelectedItem()); 
				day = String.format("%02d", dayBox.getSelectedItem());	

				// String변환 값을 각 생성자에 전달
				SalesDayTable table = new SalesDayTable(year, month, day);
				DayChart chart = new DayChart(year, month, day);
				TitlePanel title = new TitlePanel(year, month, day);
				TotalPanel total = new TotalPanel(year, month, day);
			}
		});

		setContentAreaFilled(false);	// 버튼 배경 지우기
		setBorderPainted(false);	// 버튼 테두리 지우기
		setFocusable(false);	
	}
}
