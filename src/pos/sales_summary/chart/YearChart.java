package pos.sales_summary.chart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import database.OjdbcConnection;

public class YearChart extends JPanel {

	public static DefaultCategoryDataset dataset;
	private static CategoryDataset datasetResult = createDataset();
	private static JFreeChart chart = createChart(datasetResult);
	
	String year;

	public YearChart() {

		chart.getPlot().setBackgroundPaint(Color.WHITE);
		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new Dimension(500, 500));
		add(panel);
		setBounds(50, 150, 500, 500);
	} 

	public YearChart(String year) {
		this.year = year;

		String sql = "SELECT to_char(saledate, 'YYYY-MM'), sum(price) AS total " 
				+ "FROM sales_management INNER JOIN sales "
				+ "USING (sales_number) "
				+ "WHERE TO_CHAR(saledate, 'YYYY') = ? "
				+ "GROUP BY to_char(saledate, 'YYYY-MM')"
				+ "ORDER BY to_char(saledate, 'YYYY-MM')";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);

				) {

			pstmt.setString(1, year);
			try (ResultSet rs = pstmt.executeQuery()) {
				
				while (rs.next()) {
					dataset.addValue(rs.getInt("total"), rs.getString(1), rs.getString(1));
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
				"",               
				"",                  
				dataset,                 
				PlotOrientation.VERTICAL, 
				true,                    
				true,                     
				false                    
				);

		return chart;
	}
}
