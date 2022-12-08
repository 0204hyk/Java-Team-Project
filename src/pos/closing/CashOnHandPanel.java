package pos.closing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class CashOnHandPanel extends JPanel{
	
	public CashOnHandPanel() {
		setLayout(new BorderLayout(0,0));
		setLocation(120, 230);
		setSize(400, 430);
		
		LineBorder labelLine = new LineBorder(new Color(127, 127, 127));
		
		JLabel titleLabel = new JLabel("현금 시재", JLabel.CENTER);
		titleLabel.setBorder(labelLine);
		titleLabel.setOpaque(true);
		titleLabel.setBackground(new Color(242, 242, 242));
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		
		JPanel westPanel = new JPanel(new GridLayout(9, 1));
		
		JLabel westLabel1 = new JLabel("오만원", JLabel.CENTER);
		westLabel1.setBorder(labelLine);
		westLabel1.setOpaque(true);
		westLabel1.setBackground(new Color(217, 217, 217));
		westLabel1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JLabel westLabel2 = new JLabel("만원", JLabel.CENTER);
		westLabel2.setBorder(labelLine);
		westLabel2.setOpaque(true);
		westLabel2.setBackground(new Color(217, 217, 217));
		westLabel2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JLabel westLabel3 = new JLabel("오천원", JLabel.CENTER);
		westLabel3.setBorder(labelLine);
		westLabel3.setOpaque(true);
		westLabel3.setBackground(new Color(217, 217, 217));
		westLabel3.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JLabel westLabel4 = new JLabel("천원", JLabel.CENTER);
		westLabel4.setBorder(labelLine);
		westLabel4.setOpaque(true);
		westLabel4.setBackground(new Color(217, 217, 217));
		westLabel4.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JLabel westLabel5 = new JLabel("오백원", JLabel.CENTER);
		westLabel5.setBorder(labelLine);
		westLabel5.setOpaque(true);
		westLabel5.setBackground(new Color(217, 217, 217));
		westLabel5.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JLabel westLabel6 = new JLabel("백원", JLabel.CENTER);
		westLabel6.setBorder(labelLine);
		westLabel6.setOpaque(true);
		westLabel6.setBackground(new Color(217, 217, 217));
		westLabel6.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JLabel westLabel7 = new JLabel("오십원", JLabel.CENTER);
		westLabel7.setBorder(labelLine);
		westLabel7.setOpaque(true);
		westLabel7.setBackground(new Color(217, 217, 217));
		westLabel7.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JLabel westLabel8 = new JLabel("십원", JLabel.CENTER);
		westLabel8.setBorder(labelLine);
		westLabel8.setOpaque(true);
		westLabel8.setBackground(new Color(217, 217, 217));
		westLabel8.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JLabel westLabel9 = new JLabel("총 금액", JLabel.CENTER);
		westLabel9.setBorder(labelLine);
		westLabel9.setOpaque(true);
		westLabel9.setBackground(new Color(242, 242, 242));
		westLabel9.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		westPanel.add(westLabel1, "West");
		westPanel.add(westLabel2, "West");
		westPanel.add(westLabel3, "West");
		westPanel.add(westLabel4, "West");
		westPanel.add(westLabel5, "West");
		westPanel.add(westLabel6, "West");
		westPanel.add(westLabel7, "West");
		westPanel.add(westLabel8, "West");
		westPanel.add(westLabel9, "West");

		JPanel centerPanel = new JPanel(new GridLayout(9, 1));
		JLabel count50000 = new JLabel("원  ", JLabel.RIGHT);
		count50000.setBorder(labelLine);
		count50000.setOpaque(true);
		count50000.setBackground(Color.white);
		count50000.setFont(new Font("맑은 고딕", Font.BOLD, 16));

		JLabel count10000 = new JLabel("원  ", JLabel.RIGHT);
		count10000.setBorder(labelLine);
		count10000.setOpaque(true);
		count10000.setBackground(Color.white);
		count10000.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JLabel count5000 = new JLabel("원  ", JLabel.RIGHT);
		count5000.setBorder(labelLine);
		count5000.setOpaque(true);
		count5000.setBackground(Color.white);
		count5000.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JLabel count1000 = new JLabel("원  ", JLabel.RIGHT);
		count1000.setBorder(labelLine);
		count1000.setOpaque(true);
		count1000.setBackground(Color.white);
		count1000.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JLabel count500 = new JLabel("원  ", JLabel.RIGHT);
		count500.setBorder(labelLine);
		count500.setOpaque(true);
		count500.setBackground(Color.white);
		count500.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JLabel count100 = new JLabel("원  ", JLabel.RIGHT);
		count100.setBorder(labelLine);
		count100.setOpaque(true);
		count100.setBackground(Color.white);
		count100.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JLabel count50 = new JLabel("원  ", JLabel.RIGHT);
		count50.setBorder(labelLine);
		count50.setOpaque(true);
		count50.setBackground(Color.white);
		count50.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		JLabel count10 = new JLabel("원  ", JLabel.RIGHT);
		count10.setBorder(labelLine);
		count10.setOpaque(true);
		count10.setBackground(Color.white);
		count10.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		JLabel countAll = new JLabel("원  ", JLabel.RIGHT);
		countAll.setBorder(labelLine);
		countAll.setOpaque(true);
		countAll.setBackground(new Color(242, 242, 242));
		countAll.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		
		centerPanel.add(count50000);
		centerPanel.add(count10000);
		centerPanel.add(count5000);
		centerPanel.add(count1000);
		centerPanel.add(count500);
		centerPanel.add(count100);
		centerPanel.add(count50);
		centerPanel.add(count10);
		centerPanel.add(countAll);
		
		
		
		add(titleLabel, "North");
		add(westPanel, "West");
		add(centerPanel, "Center");
		
	}
	

}
