package kiosk.menuFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class North_SouthPanel extends JPanel {

	public North_SouthPanel() {
		
		categoryButton();
		setBackground(Color.white);
	}

	// 카테고리 버튼
	public void categoryButton() {
		
		GridLayout grid = new GridLayout(2, 5, 0, 5);
		setLayout(grid);
		int count = 0;
		
		for (int i = 0; i < 10; i++) {
			JButton categoryButton = new JButton();
			
			try {
				
				count +=1;
				
				BufferedImage homeBufferedImage = ImageIO.read(new File
						("KioskImages/3_메뉴선택/menuImages/"+ count + ".png"));

				categoryButton.setIcon(new ImageIcon(homeBufferedImage));

			} catch (Exception e2) {
				e2.printStackTrace();
			}

			categoryButton.setBorderPainted(false);
			categoryButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			categoryButton.setOpaque(false);
			categoryButton.setPreferredSize(new Dimension(110, 46));
			add(categoryButton);
			
		}
		
	}
	
}
