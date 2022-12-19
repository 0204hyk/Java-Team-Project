package pos.salescheck.component.datecombo1;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import pos.salescheck.component.table.SalesDayTable;
import pos.salescheck.component.table.SalesMonthTable;

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
<<<<<<< HEAD
	
=======
		
		addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				SalesMonthTable table = new SalesMonthTable();
				table.model.setNumRows(0);
			}
		});
>>>>>>> branch 'kbc' of https://github.com/0204hyk/Java-Team-Project.git
	}
}
