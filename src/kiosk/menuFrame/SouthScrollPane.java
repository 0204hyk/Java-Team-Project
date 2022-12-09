package kiosk.menuFrame;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SouthScrollPane extends JScrollPane{
	
	JScrollPane pane = new JScrollPane();
	
	public SouthScrollPane() {
		setPane();
		
	}
	
	public void setPane() {
		temp();
		
	}
	
	
	public void temp() {
		JTextArea temp = new JTextArea();
		temp.setSize(540,830);
		
		add(temp);
	}
	
}
