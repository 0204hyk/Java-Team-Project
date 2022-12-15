package pos.salescheck.component.datecombo1;

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

public class DayComboBox extends JComboBox {

	// 매출요약 일 콤보박스 생성.
	Calendar now = Calendar.getInstance();
	int day = now.get(Calendar.DATE);
	
	
	public DayComboBox() {
		
		for (int i = 1; i <= now.getActualMaximum(Calendar.DAY_OF_MONTH); ++i) {
			addItem(i);
		}

		// 콤보박스 선택 시 선택 i값 추출
		addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e.getItem());
			}
		});
		
		setBounds(320, 100, 100, 25);
		
	}
}
