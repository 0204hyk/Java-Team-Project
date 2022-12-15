package pos.salescheck.component.table;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SalesTable extends JTable {
	
	
	public SalesTable() {
		String []a = {"날짜", "매출액"};
		String [][]b = {{"2022-01-01", "3000000"}, {"2022-12-15", "500000"}};
		
		DefaultTableModel model = new DefaultTableModel(b, a);
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);

		table.setFont(getFont().deriveFont(20f));
		table.getTableHeader().setFont(new Font("맑은 고딕", Font.PLAIN, 23));
		scroll.setBounds(0, 0, 450, 360);
	
		setBounds(650, 230, 450, 360);

		add(scroll);
		
		setLayout(null);
		setVisible(true);
		
	}

}
