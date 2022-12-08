package kiosk;

import javax.swing.JFrame;

public class KioskFrame extends JFrame {
	
	public KioskFrame() {
		setLocation(500, 50);
		setSize(650, 950);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new KioskFrame();
	}
}
