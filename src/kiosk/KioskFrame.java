package kiosk;

<<<<<<< HEAD
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class KioskFrame {
=======
import javax.swing.JFrame;
import javax.swing.JPanel;
>>>>>>> branch 'jsj' of https://github.com/0204hyk/Java-Team-Project.git

<<<<<<< HEAD
	public KioskFrame() {
		JFrame f = new JFrame();
		
		f.setVisible(true);
		f.setLocation(100, 100);
		f.setSize(650, 950);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel n = new JPanel();
		JPanel c = new JPanel();
		JPanel s = new JPanel();
		
	
		
		
		
	}
=======
public class KioskFrame extends JFrame {
	
	public KioskFrame() {		
		
		setLocation(500, 50);
		setSize(650, 950);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
>>>>>>> branch 'jsj' of https://github.com/0204hyk/Java-Team-Project.git
	public static void main(String[] args) {
		new KioskFrame();
	}
}
