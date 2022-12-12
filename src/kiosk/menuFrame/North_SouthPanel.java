package kiosk.menuFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
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
		ButtonGroup group = new ButtonGroup();

		for (int i = 0; i < 10; i++) {

			JButton categoryButton = new JButton();

			group.add(categoryButton);

			try {

				count += 1;

				BufferedImage catogoryBufferedImage = ImageIO
						.read(new File("KioskImages/3_메뉴선택/menuImages/" + count + ".png"));

				BufferedImage clcikedBufferedImage = ImageIO
						.read(new File("KioskImages/3_메뉴선택/menuImages/" + count + "Pushed.png"));

				categoryButton.setIcon(new ImageIcon(catogoryBufferedImage));

				categoryButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						//group.getSelection().setPressed(false);
						
						
						categoryButton.setIcon(new ImageIcon(clcikedBufferedImage));
					}
				});

				if (count == 6) {
					categoryButton.doClick();
				}

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
