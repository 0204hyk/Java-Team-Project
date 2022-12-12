package pos.salescheck;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pos.salescheck.component.ChartLabel;
import pos.salescheck.component.EscapeButton;
import pos.salescheck.component.SearchButton;
import pos.salescheck.component.datecombo1.DayComboBox;
import pos.salescheck.component.datecombo1.MonthComboBox;
import pos.salescheck.component.datecombo1.YearComboBox;
import pos.salescheck.component.datecombo2.DayComboBox2;
import pos.salescheck.component.datecombo2.MonthComboBox2;
import pos.salescheck.component.datecombo2.YearComboBox2;
import pos.salescheck.component.saleslist.AmountLabel;
import pos.salescheck.component.saleslist.ListImgLabel;
import pos.salescheck.component.saleslist.TitleLabel;
import pos.salescheck.component.title.DigitalClock;
import pos.salescheck.component.title.TitleImage;

public class SalesCheckMainFrame extends JFrame {
	
	
	
	public SalesCheckMainFrame() {
		JPanel titlePanel = new JPanel();
		JLabel centerTitle = new DigitalClock();
		JLabel salesTitle = new TitleLabel();
		JLabel amount = new AmountLabel();
		JPanel graph = new JPanel();
		JComboBox combo1 = new YearComboBox();
		JComboBox monthCombo = new MonthComboBox();
		JComboBox dayCombo = new DayComboBox();
		JComboBox dayCombo2 = new DayComboBox2();
		JComboBox yearCombo2 = new YearComboBox2();
		JComboBox monthCombo2 = new MonthComboBox2();
		

		
		
	

		
		centerTitle.setBounds(1000, 10, 400, 30);
		
		
		
		
		
		JButton searchBtn = new SearchButton();
		JButton escapeBtn = new EscapeButton();
		JLabel label = new ChartLabel();
		JLabel list = new ListImgLabel();
		JPanel title = new TitleImage();
		title.add(centerTitle);
		add(title);
		add(combo1);
		add(monthCombo);
		add(dayCombo);
		add(yearCombo2);
		add(monthCombo2);
		add(dayCombo2);
		add(searchBtn);
		add(escapeBtn);
		add(salesTitle);
		add(amount);
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
