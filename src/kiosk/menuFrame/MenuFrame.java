//package kiosk.menuFrame;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//
//import javax.swing.JFrame;
//
//import kiosk.menuFrame.northPanel.NorthPanel;
//import kiosk.menuFrame.southPanel.SouthPanel;
//
//
////메뉴프레임
//public class MenuFrame extends JFrame{
//
//	NorthPanel np = new NorthPanel();
//	
//	
//	public MenuFrame()  {
//			
//		panelSetting();
//		setDisplay();
//		
//	}
//	
//	public void panelSetting() {
//		
//		add(np, BorderLayout.NORTH);
//		//add(new CenterPanel(), BorderLayout.CENTER);	
//		add(np.panel(), BorderLayout.CENTER);
//		add(new SouthPanel(), BorderLayout.SOUTH);
//		add(np.westPanel(), BorderLayout.WEST);
//		add(np.eastPanel(), BorderLayout.EAST);
//		
//		setBackground(Color.white);
//		
//	}
//	
//
//	public void setDisplay() {
//		
//		//setUndecorated(true); //테두리제거
//		setBackground(Color.white);
//		setVisible(true);
//		setSize(650, 950);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLocationRelativeTo(null);
//		
//	}
//	
//	public static void main(String[] args) {
//		new MenuFrame();
//
//	}
//}
