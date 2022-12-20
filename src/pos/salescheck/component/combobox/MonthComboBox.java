package pos.salescheck.component.combobox;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import pos.salescheck.component.table.SalesDayTable;
import pos.salescheck.component.table.SalesMonthTable;
import pos.salescheck.component.table.SalesYearTable;

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

		
		addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				SalesYearTable yearTable = new SalesYearTable();
				yearTable.model.setNumRows(0);
				SalesMonthTable monthTable = new SalesMonthTable();
				monthTable.model.setNumRows(0);
				SalesDayTable dayTable = new SalesDayTable();
				dayTable.model.setNumRows(0);
			}
		});

	}
}
