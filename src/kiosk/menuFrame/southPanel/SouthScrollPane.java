package kiosk.menuFrame.southPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;

public class SouthScrollPane extends JScrollPane{
	
	public SouthScrollPane() {	//기능미구현 
		setPane();
	}
	
	public void setPane() { //스크롤패널 초기값만 설정.
		setPreferredSize(new Dimension(530, 210));
		setViewportView(new SouthScrollPaneComponent());
		
		
		add(new SouthScrollPaneComponent());
		add(new SouthScrollPaneComponent());
	}
	

	
}
