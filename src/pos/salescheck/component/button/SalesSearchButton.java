package pos.salescheck.component.button;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.ApplicationFrame;

import pos.ImageScaledTool;

import pos.salescheck.component.chart.DayChart;
import pos.salescheck.component.chart.MonthChart;
import pos.salescheck.component.chart.SalesChart;
import pos.salescheck.component.chart.YearChart;
import pos.salescheck.component.datecombo1.DayComboBox;
import pos.salescheck.component.datecombo1.MonthComboBox;
import pos.salescheck.component.datecombo1.YearComboBox;
import pos.salescheck.component.table.SalesDayTable;
import pos.salescheck.component.table.SalesMonthTable;
import pos.salescheck.component.table.SalesYearTable;
import pos.salescheck.component.type.SalesMonthCheckMain;

public class SalesSearchButton extends JButton {

	ImageScaledTool tool = new ImageScaledTool();


	JComboBox yearBox;
	JComboBox monthBox;
	JComboBox dayBox;

	String year;
	String month;
	String day;
	String year2;
	String month2;
	String day2;

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
				year = String.format("%02d",  yearBox.getSelectedItem());
				SalesYearTable table = new SalesYearTable(year);
				YearChart chart = new YearChart(year);
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
				year = String.format("%02d",  yearBox.getSelectedItem());
				month = String.format("%02d", monthBox.getSelectedItem()); 
				SalesMonthTable table = new SalesMonthTable(year, month);
				MonthChart chart = new MonthChart(year, month);

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

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				year = String.format("%02d",  yearBox.getSelectedItem());
				month = String.format("%02d", monthBox.getSelectedItem()); 
				day = String.format("%02d", dayBox.getSelectedItem());	
				SalesDayTable table = new SalesDayTable(year, month, day);
				DayChart chart = new DayChart(year, month, day);

			}
		});


		setContentAreaFilled(false);	// 버튼 배경 지우기
		setBorderPainted(false);	// 버튼 테두리 지우기
		setFocusable(false);	

	}
}
