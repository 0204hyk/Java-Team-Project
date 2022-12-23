package pos.sales_summary.combobox;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import javax.swing.JComboBox;

import pos.sales_summary.chart.DayChart;
import pos.sales_summary.chart.MonthChart;
import pos.sales_summary.chart.YearChart;
import pos.sales_summary.panel.TitlePanel;
import pos.sales_summary.panel.TotalPanel;
import pos.sales_summary.table.SalesDayTable;
import pos.sales_summary.table.SalesMonthTable;
import pos.sales_summary.table.SalesYearTable;

public class MonthComboBox extends JComboBox {
	
	// 매출요약 월 콤보박스 생성.
	Calendar now = Calendar.getInstance();
	int month = now.get(Calendar.MONTH) + 1;
	
	public MonthComboBox() {
		for (int i = 1; i <= 12; ++i ) {
			addItem(i);
		}
		setSelectedItem(month);
		setBounds(210, 100, 100, 25);

		// 콤보박스 값 선택 시 table 리스트 초기화
		addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				SalesYearTable yearTable = new SalesYearTable();
				yearTable.model.setNumRows(0);
				SalesMonthTable monthTable = new SalesMonthTable();
				monthTable.model.setNumRows(0);
				SalesDayTable dayTable = new SalesDayTable();
				dayTable.model.setNumRows(0);
				YearChart yearChart = new YearChart();
				yearChart.dataset.clear();
				MonthChart monthChart = new MonthChart();
				monthChart.dataset.clear();
				
			}
		});
	}
}
