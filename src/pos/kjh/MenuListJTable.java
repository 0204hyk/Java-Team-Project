package pos.kjh;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import database.OjdbcConnection;

public class MenuListJTable extends JTable{

	public static String driver = "oracle.jdbc.driver.OracleDriver";
	public static String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static String id = "hyCafe";
	private static String pw = "1234";
	
	private String top[] = {"", "상품코드", "메뉴 이름", "금액"};
	
	private DefaultTableModel contents = new DefaultTableModel(top, 0);
	
	static String num;
	static String name;
	static String price;
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
//	 DefaultTableCellRenderer dcr = new DefaultTableCellRenderer()
//	 {
//	  public Component getTableCellRendererComponent  // 셀렌더러
//	   (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
//	  {
//	   JCheckBox box= new JCheckBox();
//	   box.setSelected(((Boolean)value).booleanValue());  
//	   box.setHorizontalAlignment(JLabel.CENTER);
//	   return box;
//	  }
//	 };
	
	public MenuListJTable(String sqlCondition) throws SQLException {
		String sql = sqlCondition;

		try (
				Connection conn = DriverManager.getConnection(url, id, pw);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				){

			while (rs.next()) {
				
				contents.addRow(new Object[] {
						rs.getInt("menu_number"),
						rs.getString("menu_name"),
						rs.getInt("price")
				});
			}
			
			JTable table = new JTable(contents);
			//
//			table.getColumn("").setCellRenderer(dcr);
//			JCheckBox box = new JCheckBox();
//			box.setHorizontalAlignment(JLabel.CENTER);
//			
//			table.getColumn("").setCellEditor(new DefaultCellEditor(box));;
			
			
			JScrollPane scroll = new JScrollPane(table);
			
			table.setFont(getFont().deriveFont(20f));
			table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 23));
			table.setRowHeight(35);
			scroll.setBounds(0, 0, 1100, 400);
			
			
			
			
//			table.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mousePressed(MouseEvent e) {
//					int row = table.getSelectedRow();
//					
//				}
//			});
			
			
			setBounds(48, 190, 1100, 400);
			add(scroll);
			setLayout(null);
			setVisible(true);


		}
	}
	

	
}
