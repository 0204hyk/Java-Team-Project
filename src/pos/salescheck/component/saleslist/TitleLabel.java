package pos.salescheck.component.saleslist;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pos.ImageScaledTool;
import pos.salescheck.component.type.SalesDayCheckMain;



public class TitleLabel extends JPanel {

	String year;
	String month;
	String day;
	ImageScaledTool tool = new ImageScaledTool();

	private static JLabel text = new JLabel();


	public TitleLabel() {
		setBounds(730, 180, 250, 100);
		setOpaque(true);
	
		setForeground(new Color(0, 0, 0, 0));
	
		add(text);

	}




	public TitleLabel(String year, String month, String day) {
		this.year = year;
		this.month = month;
		this.day = day;

		text.setText(year + "년 " + month + "월 " + day + "일");
		text.setFont(new Font("맑은 고딕", Font.PLAIN, 25));

	}

	
}
