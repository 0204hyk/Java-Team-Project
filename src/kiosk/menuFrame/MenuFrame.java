package kiosk.menuFrame;



import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

//메뉴프레임
public class MenuFrame extends JFrame{


	
	public MenuFrame()  {
		setUndecorated(true); 
		
		panelSetting();
		setDisplay();
		
	}
	
	public void panelSetting() {
		add(new NorthPanel(), BorderLayout.NORTH);
		add(new CenterPanel(), BorderLayout.CENTER);	
		add(new SouthPanel(), BorderLayout.SOUTH);

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
		new MenuFrame();

	}
}