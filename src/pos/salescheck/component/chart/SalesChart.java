package pos.salescheck.component.chart;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
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
import pos.salescheck.component.button.SalesSearchButton;

/*
 	JFreeChart 
 	Build Path Jar파일 필요.

 */

public class SalesChart extends ApplicationFrame {

	public static JFreeChart barChart;

	SalesCheckMainFrame main;


	DTOHAP a = new DTOHAP();
	private static String hap = new DTOHAP().getHap();
	
	
	
	final DefaultCategoryDataset dataset = new DefaultCategoryDataset();


	public SalesChart (String applicationTitle, String chartTitle) {

		super(applicationTitle);

		barChart = ChartFactory.createBarChart(chartTitle, "first_name", "", viewChart(), 
				PlotOrientation.VERTICAL, true, true, false);
		System.out.println(hap);
	}

	public CategoryDataset viewChart() {
		

		String sql = "SELECT s.saleDate, sales_m.total_price "
				+ "FROM sales s INNER JOIN sales_management sales_m "
				+ "USING (sales_number) WHERE TO_CHAR(s.saleDate, 'YYYYMMDD') = ?";


		try  (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){


			pstmt.setString(1, hap.toString());
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
