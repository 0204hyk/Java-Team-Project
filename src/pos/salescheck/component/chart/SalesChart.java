package pos.salescheck.component.chart;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
import pos.salescheck.component.table.SalesTable;

/*
 	JFreeChart 
 	Build Path Jar파일 필요.

 */

public class SalesChart extends ApplicationFrame  {

	public static JFreeChart barChart;

	StringBuilder sb = new StringBuilder();
	SalesCheckMainFrame main;
	String year;
	String month;
	String day;

	
	

	public SalesChart (String applicationTitle, String chartTitle) {
		super(applicationTitle);
	
	
		barChart = ChartFactory.createBarChart(chartTitle, "", "", createDataset(),
				PlotOrientation.VERTICAL, true, true, false);

		
		
		//		ChartPanel chartPanel = new ChartPanel(barChart);
		//		chartPanel.setPreferredSize(new Dimension(650, 500));
		//		setContentPane(chartPanel);	
	}



	public CategoryDataset createDataset() {
		
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String sql = "SELECT s.saleDate, sales_m.total_price AS total_price "
				+ "FROM sales s INNER JOIN sales_management sales_m "
				+ "USING (sales_number)"
				+ "WHERE TO_CHAR(s.saleDate, 'YYYYMMDD') = ?";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);

				) {
			
			pstmt.setString(1, new String());
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					dataset.addValue(rs.getInt("total_price"), rs.getDate(1), rs.getDate(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataset;
	}
}
