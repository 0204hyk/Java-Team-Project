package kiosk.menuFrame;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class NorthPanel extends JPanel {
	
	JPanel a = new JPanel();
	JPanel b = new JPanel();
	JPanel c = new JPanel();
	
	
	
	public NorthPanel() {
		panelSetting();
	}

	
	//북쪽 패널 세팅(메뉴, 홈버튼)
	public void panelSetting() {
		
		GridLayout grid = new GridLayout(1,0);
		setLayout(grid);
		add(new North_NorthPanel());
		add(new North_SouthPanel());
		}
	
}
