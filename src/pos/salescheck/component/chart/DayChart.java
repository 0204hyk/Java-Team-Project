package pos.salescheck.component.chart;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import database.OjdbcConnection;

public class DayChart extends JPanel {


    public static DefaultCategoryDataset dataset;

    String year;
    String month;
    String day;
    public static String hap;
    
    
    public DayChart() {
        CategoryDataset datasetResult = createDataset();
        JFreeChart chart = createChart(datasetResult);
        
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
    	System.out.println(hap);
    	String sql = "SELECT s.saleDate, sales_m.total_price AS total_price "
				+ "FROM sales s INNER JOIN sales_management sales_m "
				+ "USING (sales_number)"
				+ "WHERE TO_CHAR(s.saleDate, 'YYYYMMDD') = ?";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);

				) {
			
			pstmt.setString(1, hap);
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					dataset.addValue(rs.getInt("total_price"), rs.getDate(1), rs.getDate(1));
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
                "hyCafe",         // chart title
                "",               // domain axis label
                "",                  // range axis label
                dataset,                  // data
                PlotOrientation.VERTICAL, // orientation
                true,                     // include legend
                true,                     // tooltips?
                false                     // URLs?
                );

//        chart.setBackgroundPaint(Color.white);
//        CategoryPlot plot = (CategoryPlot) chart.getPlot();
//        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
//        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
//        BarRenderer renderer = (BarRenderer) plot.getRenderer();
//        renderer.setDrawBarOutline(false);
//
//        GradientPaint gp0 = new GradientPaint(0.0f,0.0f,Color.blue,0.0f,0.0f,new Color(0, 0, 64));
//        GradientPaint gp1 = new GradientPaint(0.0f,0.0f,Color.green,0.0f,0.0f,new Color(0, 64, 0));
//        GradientPaint gp2 = new GradientPaint(0.0f,0.0f,Color.red,0.0f,0.0f,new Color(64, 0, 0));
//
//        renderer.setSeriesPaint(0, gp0);
//        renderer.setSeriesPaint(1, gp1);
//        renderer.setSeriesPaint(2, gp2);
//
//        CategoryAxis domainAxis = plot.getDomainAxis();
//        domainAxis.setCategoryLabelPositions(
//                         CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
//                                             );
        return chart;
    }
}
