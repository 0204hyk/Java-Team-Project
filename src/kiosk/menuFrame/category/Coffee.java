package kiosk.menuFrame.category;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Coffee {

public void menuButton() {
		
		for (int i = 0; i < 9; i++) {
			JButton menuButton = new JButton();
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

			
		}
	}	
}
