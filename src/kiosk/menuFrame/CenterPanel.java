package kiosk.menuFrame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CenterPanel extends JPanel{
	
	public CenterPanel() {
		setDisplay();
	}

	private void setDisplay() {
		setLayout(new GridLayout(3, 3));

		for (int i = 0; i < 9; i++) {
			JButton menuButton = new JButton();

			try {
				BufferedImage homeBufferedImage = ImageIO.read(new File("image/menu/wholeMenu.png"));

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
