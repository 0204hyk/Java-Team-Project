package pos.closing.closing_main.container;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class DailySalesPanel extends JPanel {
	private Image background;
	
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(background, 0, 0, d.width, d.height, null);		
	}	
	
	public DailySalesPanel(Image background) {
		this.background = background;
		setSize(new Dimension(background.getWidth(null), background.getHeight(null)));
		setLayout(null);
		setLocation(600, 100);
		setSize(500, 550);

		Calendar now = Calendar.getInstance();
		String date = "  " + now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH) + 1) 
				+ "-" + now.get(Calendar.DAY_OF_MONTH); 
		JLabel dateLabel = new JLabel(date);
		dateLabel.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		dateLabel.setBounds(10, 5, 200, 50);
		
		add(dateLabel);
		
	}
}
