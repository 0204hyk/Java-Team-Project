package kiosk.logout;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;

import kiosk.TouchToPlaceAnOrder;

public class KioskEndFrame extends JFrame{

	TouchToPlaceAnOrder mainFrame;
	
	public KioskEndFrame(TouchToPlaceAnOrder mainFrame) {
		add(new KioskAccessPanel(mainFrame, this));
		
		setLayout(null);
		setSize(465, 195);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new KioskEndFrame(new TouchToPlaceAnOrder());
	}

}
