package kiosk.menuFrame;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class NorthPanel extends JPanel {
	
	public NorthPanel() {
		panelSetting();
	}

	//북쪽 패널 세팅(메뉴, 홈버튼)
	public void panelSetting() {
		
		GridLayout grid = new GridLayout(0,1);
		setLayout(grid);
		add(new North_NorthPanel());
		add(new North_SouthPanel());
		
		}
	
}
