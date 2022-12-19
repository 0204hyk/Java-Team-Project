package pos.salescheck.component.chart;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
import pos.salescheck.SalesCheckMainFrame;

/*
 	JFreeChart 
 	Build Path Jar파일 필요.
 
*/

public class SalesChart extends ApplicationFrame {

	public static JFreeChart barChart;
	
	SalesCheckMainFrame main;

	public SalesChart (String applicationTitle, String chartTitle) {
		super(applicationTitle);
	
		 barChart = ChartFactory.createBarChart(chartTitle, "first_name", "", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);
		 
//		ChartPanel chartPanel = new ChartPanel(barChart);
//		chartPanel.setPreferredSize(new Dimension(650, 500));
//		setContentPane(chartPanel);	
	}

	private CategoryDataset createDataset() {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String sql = "SELECT s.saleDate, sales_m.total_price FROM sales s INNER JOIN sales_management sales_m USING (sales_number)";
		
		try {
			Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				dataset.addValue(rs.getInt("total_price"), rs.getString("saleDate"), rs.getString("saleDate"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		return dataset;
	}
}