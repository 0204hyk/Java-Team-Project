package pos.salescheck;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pos.salescheck.component.ChartLabel;
import pos.salescheck.component.DateComboBox;
import pos.salescheck.component.DigitalClock;
import pos.salescheck.component.EscapeButton;
import pos.salescheck.component.SearchButton;
import pos.salescheck.component.TestCombo;
import pos.salescheck.component.dateyear.YearComboBox;

public class SalesCheckMainFrame extends JFrame {
	
	
	
	public SalesCheckMainFrame() {
		JLabel titleName = new JLabel("안녕");
		JPanel titlePanel = new JPanel();
		JComboBox comboYear = new YearComboBox();
		JButton searchBtn = new SearchButton();
		JButton escapeBtn = new EscapeButton();
		JLabel label = new ChartLabel();
		
		
		add(comboYear);
		add(label);
		add(searchBtn);
		add(escapeBtn);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setSize(1200, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}



	public static void main(String[] args) {


		new SalesCheckMainFrame();

	}

}
