package pos.closing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DailySalesPanel extends JPanel {
	public DailySalesPanel() {
		setLayout(new BorderLayout());
		setLocation(600, 100);
		setSize(500, 550);

		Calendar now = Calendar.getInstance();
		JLabel northLabel = new JLabel();
		northLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		String date = now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH) + 1) 
				+ "-" + now.get(Calendar.DAY_OF_MONTH); 
		northLabel.setText(date);
		
		add(northLabel, "North");
	}
}
