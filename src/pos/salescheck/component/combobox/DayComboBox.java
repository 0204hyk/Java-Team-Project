package pos.salescheck.component.combobox;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import org.jfree.data.category.DefaultCategoryDataset;


import pos.salescheck.component.table.SalesDayTable;
import pos.salescheck.component.table.SalesMonthTable;
import pos.salescheck.component.table.SalesYearTable;

public class DayComboBox extends JComboBox {

	// 매출요약 일 콤보박스 생성.
	Calendar now = Calendar.getInstance();
	int day = now.get(Calendar.DATE);
	
	public DayComboBox() {
		
		for (int i = 1; i <= now.getActualMaximum(Calendar.DAY_OF_MONTH); ++i) {
			addItem(i);
		}

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
			}
		});
		setBounds(320, 100, 100, 25);
	}
}
