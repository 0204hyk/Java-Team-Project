package pos.kjh;

import java.awt.Color;

import javax.swing.JFrame;

public class MenuAddFrame extends JFrame{

	public MenuAddFrame() {
		openFrame();
	}
	
	public void openFrame() {
		
		setLayout(null);
		setSize(1000, 600);
		setVisible(true);
		getContentPane().setBackground(new Color(255, 255, 255));
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new MenuAddFrame();
	}
}
