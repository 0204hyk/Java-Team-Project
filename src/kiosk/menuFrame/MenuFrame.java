package kiosk.menuFrame;



import javax.swing.JFrame;

//메뉴프레임
public class MenuFrame extends JFrame{

	
	public MenuFrame()  {
		setDisplay();
		
	}
	
	public void panelSetting() {
		
		
		
	}
	
	
	
	public void setDisplay() {
		
		setVisible(true);
		setLocation(100, 100);
		setSize(650, 950);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	
	public static void main(String[] args) {
		new MenuFrame();
	}
}
