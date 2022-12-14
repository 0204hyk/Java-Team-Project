package pos.sales_summary.combobox;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.util.Calendar;
import javax.swing.JComboBox;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.general.DatasetChangeListener;

import pos.sales_summary.chart.DayChart;
import pos.sales_summary.chart.MonthChart;
import pos.sales_summary.chart.YearChart;
import pos.sales_summary.panel.TitleImagePanel;
import pos.sales_summary.panel.TitlePanel;
import pos.sales_summary.panel.TotalPanel;
import pos.sales_summary.table.SalesDayTable;
import pos.sales_summary.table.SalesMonthTable;
import pos.sales_summary.table.SalesYearTable;

public class YearComboBox extends JComboBox  {

	// 매출요약 년도 콤보박스 생성.
	Calendar now = Calendar.getInstance();
	int year = now.get(Calendar.YEAR);
	TotalPanel total = new TotalPanel();
	TitlePanel title = new TitlePanel();
	public YearComboBox() {
		for (int i = year - 10; i <= year; ++i) {
			addItem(i);
		}

		setSelectedItem(year);
		setBounds(90, 100, 100, 25);
		
		// 콤보박스 값 선택 시 table 리스트 초기화, Chart 초기화
		addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				SalesYearTable yearTable = new SalesYearTable();
				yearTable.model.setNumRows(0);
				SalesMonthTable monthTable = new SalesMonthTable();
				monthTable.model.setNumRows(0);
				SalesDayTable dayTable = new SalesDayTable();
				dayTable.model.setNumRows(0);
				YearChart chart = new YearChart();
				chart.dataset.clear();
				MonthChart monthChart = new MonthChart();
				monthChart.dataset.clear();
				DayChart dayChart = new DayChart();
				dayChart.dataset.clear();
				title.text.setText("");
				total.text.setText("");
				
			}
		});
	}
}
