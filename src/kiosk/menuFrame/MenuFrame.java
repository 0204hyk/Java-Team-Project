package kiosk.menuFrame;



import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import kiosk.menuFrame.centerPanel.CenterPanel;
import kiosk.menuFrame.eastPanel.EastPanel;
import kiosk.menuFrame.northPanel.NorthPanel;
import kiosk.menuFrame.southPanel.SouthPanel;
import kiosk.menuFrame.westPanel.WestPanel;

//메뉴프레임
public class MenuFrame extends JFrame{

	public MenuFrame()  {
			
		panelSetting();
		setDisplay();
		
	}
	
	public void panelSetting() {
		add(new NorthPanel(), BorderLayout.NORTH);
		add(new CenterPanel(), BorderLayout.CENTER);	
		add(new SouthPanel(), BorderLayout.SOUTH);
		add(new WestPanel(), BorderLayout.WEST);
		add(new EastPanel(), BorderLayout.EAST);
		
		setBackground(Color.white);
		
	}
	
	
	
	public void setDisplay() {
		
		setUndecorated(true); //테두리제거
		setBackground(Color.white);
		setVisible(true);
		setSize(650, 950);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	public static void main(String[] args) {
		new MenuFrame();

	}
}
