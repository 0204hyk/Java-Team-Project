package kiosk.cartFrame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class CartMainFrame extends JFrame{
	
	public CartMainFrame() {
		panelSetting ();
		setDisplay();
		
	}


	public void panelSetting() {

	add(new CartMainPanel());	
	setBackground(Color.white);
	
	}
	
	

	
	public void setDisplay() {
		
		setBackground(Color.white);
		setVisible(true);
		setLocation(100, 100);
		setSize(650, 950);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}


	public static void main(String[] args) {
		new CartMainFrame();
	}
}
