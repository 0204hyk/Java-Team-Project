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

public class YearChart extends JPanel {
	
	public static DefaultCategoryDataset dataset;

    String year;
    String month;
    String day;
    String hap;
    
    public YearChart() {
    	  CategoryDataset datasetResult = createDataset();
          JFreeChart chart = createChart(datasetResult);
          ChartPanel panel = new ChartPanel(chart);
          panel.setPreferredSize(new Dimension(500, 500));
          add(panel);
          setBounds(50, 150, 500, 500);
	}
    
    public YearChart(String year) {
    	this.year = year;
    	String sql = "SELECT to_char(s.saledate, 'YYYY-MM'), sum(p.price) AS total " 
				+ "FROM sales s INNER JOIN PAYMENT p "
				+ "USING (sales_number) "
				+ "WHERE TO_CHAR(s.saledate, 'YYYY') = ? "
				+ "GROUP BY to_char(s.saledate, 'YYYY-MM')"
				+ "ORDER BY to_char(s.saledate, 'YYYY-MM')";

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
