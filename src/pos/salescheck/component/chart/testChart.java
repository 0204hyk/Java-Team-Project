package pos.salescheck.component.chart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import database.OjdbcConnection;

public class testChart extends JFreeChart {

	public testChart(String title, Plot b ) {
		super(title, b);
		
		ChartFactory.createBarChart(title, "first_name", "", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);
	
		
	}
	
	private CategoryDataset createDataset() {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String sql = "SELECT first_name, salary FROM employees WHERE salary > 11000";
		
		try {
			Connection conn = OjdbcConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				dataset.addValue(rs.getInt("salary"), rs.getString("first_name"), rs.getString("first_name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		return dataset;
	}


}
