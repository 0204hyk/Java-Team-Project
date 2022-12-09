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
	
	//임시 좌우버튼부분
	public void temp() {
		JTextArea temp = new JTextArea();
		temp.setSize(300,15);
		
		add(temp);
	}
	
}
