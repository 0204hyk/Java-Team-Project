package pos.sales_summary.combobox;


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import javax.swing.JComboBox;

import pos.sales_summary.chart.DayChart;
import pos.sales_summary.chart.MonthChart;
import pos.sales_summary.chart.YearChart;
import pos.sales_summary.panel.TotalPanel;
import pos.sales_summary.table.SalesDayTable;
import pos.sales_summary.table.SalesMonthTable;
import pos.sales_summary.table.SalesYearTable;

public class DayComboBox extends JComboBox {

	// 매출요약 일 콤보박스 생성.
	Calendar now = Calendar.getInstance();
	int day = now.get(Calendar.DATE);
	
	public DayComboBox() {
		
		for (int i = 1; i <= now.getActualMaximum(Calendar.DAY_OF_MONTH); ++i) {
			addItem(i);
		}
		
		setSelectedItem(day);
		
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
				DayChart dayChart = new DayChart();
				dayChart.dataset.clear();
				
				
			}
		});
		setBounds(320, 100, 100, 25);
	}
}
