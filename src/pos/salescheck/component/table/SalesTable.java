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
		String [][]b = {{"2022-01-01"}, {"30000"}};
		
		DefaultTableModel model = new DefaultTableModel(b, a);
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);

		table.setFont(getFont().deriveFont(20f));
		scroll.setBounds(0, 0, 400, 300);
	
		setBounds(630, 300, 400, 300);

		add(scroll);
		
		setLayout(null);
		setVisible(true);
		
	}

}
