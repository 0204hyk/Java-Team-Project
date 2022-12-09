package pos.salescheck.component.chart;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import database.OjdbcConnection;



public class SalesChart extends ApplicationFrame {

	
	
	public SalesChart(String applicationTitle, String chartTitle) {
		super(applicationTitle);
		JFreeChart barChart = ChartFactory.createBarChart(chartTitle, "12월 매출", "", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);
		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(560, 367));
		setContentPane(chartPanel);
		
		
	}

	private CategoryDataset createDataset() {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String sql = "SELECT first_name, salary FROM employees WHERE salary > 11000";
		
		try {
			Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getInt("salary"));
				System.out.println(rs.getString("first_name"));
				dataset.addValue(rs.getInt("salary"), rs.getString("first_name"), rs.getString("first_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		return dataset;
	}
	public static void main(String[] args) {
		SalesChart chart = new SalesChart("gd", "gd");
		JLabel test = new JLabel();
		
		chart.pack();
		chart.setVisible(true);
		RefineryUtilities.centerFrameOnScreen(chart);
	
	}
	
	
}
