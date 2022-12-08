package kiosk;

import java.awt.Font;

import javax.swing.JFrame;

public class KioskFrame extends JFrame {
	
	public KioskFrame() {		
		
		setLocation(500, 50);
		setSize(650, 950);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	@Override
	public Font getFont() {
		return super.getFont();
	}
	
	public static void main(String[] args) {
		new KioskFrame();
	}
}
