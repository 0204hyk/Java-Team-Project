package pos.salescheck.component;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class test {

	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		JComboBox combo = new JComboBox();
		
		
		
		combo.setPreferredSize(new Dimension(150, 150));
		
		f.add(combo);
		f.setVisible(true);
		f.setSize(500, 500);
		
	}	
}
