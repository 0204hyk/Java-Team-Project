package pos.sales_summary.chart;


import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import database.OjdbcConnection;

public class DayChart extends JPanel {


	public static DefaultCategoryDataset dataset;
	private static CategoryDataset datasetResult = createDataset();
	private static JFreeChart chart = createChart(datasetResult);
	
	String year;
	String month;
	String day;
	String hap;


	public DayChart() {
	
		chart.getPlot().setBackgroundPaint(Color.WHITE);
		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new Dimension(500, 500));
		add(panel);
		setBounds(50, 150, 500, 500);


	}

	// SalesSearchButton에서 year, month, day 값을 가져온 후 차트에 대입
	public DayChart(String year, String month, String day) {
		this.year = year;
		this.month = month;
		this.day = day;

		hap = year + month + day;

		String sql = "SELECT to_char(saledate, 'HH24'), sum(price) AS total "
				+ "FROM sales_management INNER JOIN sales "
				+ "USING (sales_number) "
				+ "WHERE to_char(saledate, 'YYYYMMDD') = ?  "
				+ "AND to_char(saledate, 'HH24') BETWEEN 10 AND 21"
				+ "GROUP BY to_char(saledate, 'HH24')"
				+ "ORDER BY to_char(saledate, 'HH24')";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);

				) {

			pstmt.setString(1, hap);
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					dataset.addValue(rs.getInt("total"), 
							rs.getString(1) + "H", rs.getString(1) + "H");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static CategoryDataset createDataset() {
		dataset = new DefaultCategoryDataset();

		return dataset;
	}

	private static JFreeChart createChart(CategoryDataset dataset) {

		JFreeChart chart = ChartFactory.createBarChart(
				"HyCafe",        
				"",               // domain axis label
				"",                  // range axis label
				dataset,                  // data
				PlotOrientation.VERTICAL, // orientation
				true,                     // include legend
				true,                     // tooltips
				false                     // URLs
				);

		return chart;
	}
}
