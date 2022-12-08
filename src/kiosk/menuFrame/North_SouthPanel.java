package kiosk.menuFrame;

import java.awt.Color;
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
		
		GridLayout grid = new GridLayout(2, 4, 0, 0);
		setLayout(grid);
		
		for (int i = 0; i < 8; i++) {
			JButton categoryButton = new JButton();

			try {
				BufferedImage homeBufferedImage = ImageIO.read(new File("image/menu/categoryScaled.png"));

				categoryButton.setIcon(new ImageIcon(homeBufferedImage));

			} catch (Exception e2) {
				e2.printStackTrace();
			}

			categoryButton.setBorderPainted(false);
			categoryButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			categoryButton.setOpaque(false);

			add(categoryButton);

		}

	}

}
