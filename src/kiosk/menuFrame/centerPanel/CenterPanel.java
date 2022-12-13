package kiosk.menuFrame.centerPanel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CenterPanel extends JPanel{
	
	public CenterPanel() {
		
		setDisplay();
		menuButton();
	}
	
	//패널 디스플레이 설정
	private void setDisplay() {
		
		FlowLayout flow = new FlowLayout(); //매뉴버튼 간격조절
		flow.setHgap(-15);
		flow.setVgap(10);
	
		setLayout(flow);
		
		setBackground(Color.white);
	}
	
	//메뉴버튼설정
	public void menuButton() {
		
		for (int i = 0; i < 9; i++) {
			JButton menuButton = new JButton();
			menuButton.setContentAreaFilled(false);
			menuButton.setFocusPainted(false);
			
			try {
				BufferedImage homeBufferedImage = ImageIO.read
						(new File("images/KioskImages/3_메뉴선택/menuScaled.png"));

				menuButton.setIcon(new ImageIcon(homeBufferedImage));
				
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			menuButton.setBorderPainted(false);
			menuButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			menuButton.setOpaque(false);

			add(menuButton);
		}
	}
	
	
	

}
