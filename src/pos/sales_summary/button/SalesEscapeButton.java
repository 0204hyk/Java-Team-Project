package pos.sales_summary.button;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import pos.sales_summary.chart.DayChart;
import pos.sales_summary.chart.MonthChart;
import pos.sales_summary.chart.YearChart;
import pos.sales_summary.main.SalesDayCheckMain;
import pos.sales_summary.main.SalesMonthCheckMain;
import pos.sales_summary.main.SalesYearCheckMain;
import pos.sales_summary.panel.TitlePanel;
import pos.sales_summary.panel.TotalPanel;
import pos.sales_summary.table.SalesDayTable;
import pos.sales_summary.table.SalesMonthTable;
import pos.sales_summary.table.SalesYearTable;
import pos.util.ImageScaledTool;

public class SalesEscapeButton extends JButton {

	SalesDayCheckMain dayFrame;
	SalesMonthCheckMain monthFrame;
	SalesYearCheckMain yearFrame;

	ImageScaledTool tool = new ImageScaledTool();

	// 년 매출 Frame
	public SalesEscapeButton(SalesYearCheckMain yearFrame) {
		this.yearFrame = yearFrame;
		// 매출요약 < 버튼 이미지 설정
		setIcon(new ImageIcon(tool.getScaledImage(
				"Images/PosImages/매출 요약 이미지/돌아가기 버튼.png", 180, 80)));

		// 매출요약 < 버튼 눌렀을 때
		setPressedIcon(new ImageIcon(tool.getScaledImage(
				"Images/PosImages/매출 요약 이미지/돌아가기 버튼 클릭.png", 180, 80)));

		// < 버튼 위치 지정
		setBounds(940, 670, 180, 80);
		setBorder(null);
		setContentAreaFilled(false);	// 버튼 배경 지우기
		setBorderPainted(false);	// 버튼 테두리 지우기
		setFocusable(false);

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 버튼 클릭 시 기존 TitlePanel 값 초기화.
				TitlePanel panel = new TitlePanel();
				panel.text.setText("");

				// 버튼 클릭 시 기존 SalesYearTable 값 초기화.
				SalesYearTable table = new SalesYearTable();
				table.model.setNumRows(0);

				// 버튼 클릭 시 기존 TotalPanel 총 금액 값 초기화.
				TotalPanel total = new TotalPanel();
				total.text.setText("");
				
				YearChart yearChart = new YearChart();
				yearChart.dataset.clear();
				
				yearFrame.dispose();
			}
		});
	}

	// 월 매출 Frame
	public SalesEscapeButton(SalesMonthCheckMain monthFrame) {
		this.monthFrame = monthFrame;
		// 매출요약 < 버튼 이미지 설정
		setIcon(new ImageIcon(tool.getScaledImage(
				"Images/PosImages/매출 요약 이미지/돌아가기 버튼.png", 180, 80)));

		// 매출요약 < 버튼 눌렀을 때
		setPressedIcon(new ImageIcon(tool.getScaledImage(
				"Images/PosImages/매출 요약 이미지/돌아가기 버튼 클릭.png", 180, 80)));

		// < 버튼 위치 지정
		setBounds(940, 670, 180, 80);
		setBorder(null);
		setContentAreaFilled(false);	// 버튼 배경 지우기
		setBorderPainted(false);	// 버튼 테두리 지우기
		setFocusable(false);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// 버튼 클릭 시 기존 TitlePanel 값 초기화.
				TitlePanel panel = new TitlePanel();
				panel.text.setText("");

				// 버튼 클릭 시 기존 SalesMonthTable 값 초기화.
				SalesMonthTable table = new SalesMonthTable();
				table.model.setNumRows(0);

				// 버튼 클릭 시 기존 TotalPanel 총 금액 값 초기화.
				TotalPanel total = new TotalPanel();
				total.text.setText("");
				
				// 버튼 클릭 시 기존 Chart 초기화.
				MonthChart monthChart = new MonthChart();
				monthChart.dataset.clear();
				
				monthFrame.dispose();
			}
		});
	}

	// 일 매출 Frame
	public SalesEscapeButton(SalesDayCheckMain dayFrame) {
		this.dayFrame = dayFrame;
		// 매출요약 < 버튼 이미지 설정
		setIcon(new ImageIcon(tool.getScaledImage(
				"Images/PosImages/매출 요약 이미지/돌아가기 버튼.png", 180, 80)));

		// 매출요약 < 버튼 눌렀을 때
		setPressedIcon(new ImageIcon(tool.getScaledImage(
				"Images/PosImages/매출 요약 이미지/돌아가기 버튼 클릭.png", 180, 80)));

		// < 버튼 위치 지정
		setBounds(940, 670, 180, 80);
		setBorder(null);
		setContentAreaFilled(false);	// 버튼 배경 지우기
		setBorderPainted(false);	// 버튼 테두리 지우기
		setFocusable(false);
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 버튼 클릭 시 기존 TitlePanel 값 초기화.
				TitlePanel panel = new TitlePanel();
				panel.text.setText("");

				// 버튼 클릭 시 기존 SalesDayTable 값 초기화.
				SalesDayTable table = new SalesDayTable();
				table.model.setNumRows(0);

				// 버튼 클릭 시 기존 TotalPanel 총 금액 값 초기화.
				TotalPanel total = new TotalPanel();
				total.text.setText("");
				
				// 버튼 클릭 시 기존 Chart 초기화.
				DayChart dayChart = new DayChart();
				dayChart.dataset.clear();
				
				dayFrame.dispose();
			}
		});
	}
}
