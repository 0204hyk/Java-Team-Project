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
		
		
		setPreferredSize(new Dimension(40, 40));
		setSelectedItem(year);
		setBounds(50, 100, 100, 25);
	
		
	}
}
