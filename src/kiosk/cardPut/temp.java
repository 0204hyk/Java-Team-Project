package kiosk.cardPut;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import kiosk.menuFrame.southPanel.SouthScrollPaneComponent;

public class temp extends JFrame{

	public temp() {
		setDisplay();
		//add(pane);
		
	}
	
	JScrollPane pane = new JScrollPane();
	JPanel panel = new JPanel();
	
	
	
public void setDisplay() {
	
	setVisible(true);
		
		//pane.setPreferredSize(new Dimension(450, 210));
		pane.set
		
		setBackground(Color.WHITE);
		setSize(650, 950);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}

	public static void main(String[] args) {
		new temp();
	}
}
