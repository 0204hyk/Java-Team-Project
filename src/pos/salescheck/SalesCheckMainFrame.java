package pos.salescheck;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pos.salescheck.component.ChartLabel;
import pos.salescheck.component.DateComboBox;
import pos.salescheck.component.EscapeButton;
import pos.salescheck.component.SearchButton;
import pos.salescheck.component.TestCombo;
import pos.salescheck.component.chart.SalesChart;
import pos.salescheck.component.datecombo1.DayComboBox;
import pos.salescheck.component.datecombo1.MonthComboBox;
import pos.salescheck.component.datecombo1.YearComboBox;
import pos.salescheck.component.datecombo2.DayComboBox2;
import pos.salescheck.component.datecombo2.MonthComboBox2;
import pos.salescheck.component.datecombo2.YearComboBox2;
import pos.salescheck.component.saleslist.ListLabel;
import pos.salescheck.component.title.DigitalClock;
import pos.salescheck.component.title.TitleImage;

public class SalesCheckMainFrame extends JFrame {
	
	
	
	public SalesCheckMainFrame() {
		JPanel titlePanel = new JPanel();
		JLabel leftTitle = new JLabel();
		JLabel centerTitle = new DigitalClock();
		JLabel rightTitle = new JLabel();
	
		JComboBox combo1 = new YearComboBox();
		JComboBox monthCombo = new MonthComboBox();
		JComboBox dayCombo = new DayComboBox();
		JComboBox dayCombo2 = new DayComboBox2();
		JComboBox yearCombo2 = new YearComboBox2();
		JComboBox monthCombo2 = new MonthComboBox2();
		JLabel graph = new SalesChart();
		leftTitle.setBounds(10, 10, 400, 30);
		centerTitle.setBounds(1000, 10, 400, 30);
		rightTitle.setBounds(1100, 10, 400, 30);
		
		
		
		
		JButton searchBtn = new SearchButton();
		JButton escapeBtn = new EscapeButton();
		JLabel label = new ChartLabel();
		JLabel list = new ListLabel();
		JPanel title = new TitleImage();
		title.add(leftTitle);
		title.add(centerTitle);
		title.add(rightTitle);
		add(title);
//		add(leftTitle);
//		add(centerTitle);
//		add(rightTitle);
		add(combo1);
		add(monthCombo);
		add(dayCombo);
		add(yearCombo2);
		add(monthCombo2);
		add(dayCombo2);
		add(graph);
		add(searchBtn);
		add(escapeBtn);
		add(list);
		
		setBackground(Color.BLACK);
		setLayout(null);
		setSize(1200, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}



	public static void main(String[] args) {


		new SalesCheckMainFrame();

	}

}
