package pos.salescheck.component.datecombo1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class YearComboBox extends JComboBox  {

	
	Calendar now = Calendar.getInstance();
	int year = now.get(Calendar.YEAR);
	
	public YearComboBox() {
		for (int i = year; i <= year + 10; ++i) {
			addItem(i);
		}
		
		
		try {
			BufferedImage image = ImageIO.read(new File("sales_summary/date.png"));
			Image scale = image.getScaledInstance(100, 25, Image.SCALE_SMOOTH);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		setPreferredSize(new Dimension(150, 20));
		setSelectedItem(year);
		setBounds(50, 100, 100, 25);
	
		
	}
}
