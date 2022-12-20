package pos.salescheck.component.chart;

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

public class MonthChart extends JPanel {
	
	public static DefaultCategoryDataset dataset;

    String year;
    String month;
    String day;
    public static String hap;
    
    public MonthChart() {
    	CategoryDataset datasetResult = createDataset();
        JFreeChart chart = createChart(datasetResult);
        
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(500, 500));
        add(panel);
        setBounds(50, 150, 500, 500);
	}
    
    // SalesSearchButton에서 year와 month 값을 가져온 후 차트에 대입
    public MonthChart(String year, String month) {
    	this.year = year;
    	this.month = month;
    
    
    	hap = year + month;
    	System.out.println(hap);
//    	String sql = "SELECT s.saleDate, sales_m.total_price AS total_price "
//				+ "FROM sales s INNER JOIN sales_management sales_m "
//				+ "USING (sales_number)"
//				+ "WHERE TO_CHAR(s.saleDate, 'YYYYMM') = ?";
    	
    	String sql = "SELECT to_char(s.saledate, 'YYYY-MM-DD'), sum(p.price) AS total "
    			+ "FROM sales s INNER JOIN PAYMENT p "
    			+ "USING (sales_number) "
    			+ "WHERE TO_CHAR(s.saledate, 'YYYYMM') = ?"
    			+ "GROUP BY to_char(s.saledate, 'YYYY-MM-DD')";

		try (
				Connection conn = OjdbcConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);

				) {
			
			pstmt.setString(1, hap);
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					dataset.addValue(rs.getInt("total"), rs.getDate(1), rs.getDate(1));
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
