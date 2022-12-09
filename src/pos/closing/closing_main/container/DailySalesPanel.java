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

////		setLayout(new BorderLayout());
//		LineBorder labelLine = new LineBorder(new Color(127, 127, 127), 2);
//		
//		JPanel northPanel = new JPanel(new BorderLayout());
//		northPanel.setBorder(labelLine);
//		northPanel.setOpaque(true);
//		northPanel.setBackground(new Color(217, 217, 217));
//		
		Calendar now = Calendar.getInstance();
		String date = "  " + now.get(Calendar.YEAR) + "-" + (now.get(Calendar.MONTH) + 1) 
				+ "-" + now.get(Calendar.DAY_OF_MONTH); 
		JLabel dateLabel = new JLabel(date);
		dateLabel.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		dateLabel.setBounds(10, 5, 200, 50);
		
		add(dateLabel);
		
//		JLabel northLabel2 = new JLabel("결제 금액  ");
//		northLabel2.setFont(new Font("맑은 고딕", Font.BOLD, 25));
//
//		
//		JTable centerTable = new JTable(1, 2); 
//		JScrollPane scrollPane = new JScrollPane(centerTable);
//		scrollPane.setPreferredSize(new Dimension(500, 500));
//		
//		JPanel southPanel = new JPanel(new BorderLayout());
//		southPanel.setBorder(labelLine);
//		southPanel.setOpaque(true);
//		southPanel.setBackground(new Color(217, 217, 217));
//
//		JLabel southLabel1 = new JLabel("  총 금액");
//		southLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 25));
//		
//		JLabel southLabel2 = new JLabel("원  ");
//		southLabel2.setFont(new Font("맑은 고딕", Font.BOLD, 25));
//
//		northPanel.add(northLabel1, "West");
//		northPanel.add(northLabel2, "East");
//		
//		southPanel.add(southLabel1, "West");
//		southPanel.add(southLabel2, "East");
//
//		add(northPanel, "North");
//		add(scrollPane, "Center");
//		add(southPanel, "South");
	}
}
