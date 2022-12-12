package kiosk.menuFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class SouthPanel extends JPanel{
		
	public SouthPanel() {
		
		setLayout(new BorderLayout());	
		setBackground(Color.white);
		
		//장바구니 부분
		add(new SouthScrollPane(), BorderLayout.CENTER);
		
		//버튼 부분
		add(new South_EastPanel(), BorderLayout.EAST);
	}

}
