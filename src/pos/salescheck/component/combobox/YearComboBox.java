package pos.salescheck.component.combobox;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import pos.salescheck.component.table.SalesMonthTable;
import pos.salescheck.component.table.SalesYearTable;

public class YearComboBox extends JComboBox  {

	// 매출요약 년도 콤보박스 생성.
	Calendar now = Calendar.getInstance();
	int year = now.get(Calendar.YEAR);

	
	public YearComboBox() {
		for (int i = year - 10; i <= year; ++i) {
			addItem(i);
		}

		setSelectedItem(year);
		setBounds(90, 100, 100, 25);
		addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				SalesYearTable table = new SalesYearTable();
				table.model.setNumRows(0);
			}
		});
	}
}
