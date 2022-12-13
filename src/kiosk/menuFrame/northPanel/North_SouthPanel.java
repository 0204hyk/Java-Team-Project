package kiosk.menuFrame.northPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		JButton[] buttons = new JButton[10];

		for (int i = 0; i < 10; i++) {// gridlayout 사용하여 기본 가테고리 틀 추가 (1~5)는 공백처리하여 layout형식 맞추는데 사용함

			JButton categoryButton = new JButton();
			categoryButton.setContentAreaFilled(false);
			categoryButton.setFocusPainted(false);
			
			try {
				count += 1;

				BufferedImage catogoryBufferedImage = ImageIO
						.read(new File("images/KioskImages/3_메뉴선택/menuImages/" + count + ".png"));

				BufferedImage clcikedBufferedImage = ImageIO
						.read(new File("images/KioskImages/3_메뉴선택/menuImages/" + count + "Pushed.png"));


				categoryButton.setIcon(new ImageIcon(catogoryBufferedImage));

				categoryButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						for (int j = 5; j < 10; j++) {// 버튼이눌릴시 다른 버튼들 기본 이미지로 변경
							try {
								BufferedImage resetBufferedImage = ImageIO
										.read(new File("images/KioskImages/3_메뉴선택/menuImages/" + (j+1) + ".png"));
								buttons[j].setIcon(new ImageIcon(resetBufferedImage));
							} catch (Exception e2) {
								e2.printStackTrace();
							}

						}

						categoryButton.setIcon(new ImageIcon(clcikedBufferedImage));
					}
				});

				if (count == 6) {//신메뉴 기본선택
					categoryButton.setIcon(new ImageIcon(clcikedBufferedImage));
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

			categoryButton.setBorderPainted(false);
			categoryButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			categoryButton.setOpaque(false);
			categoryButton.setPreferredSize(new Dimension(110, 46));

			buttons[i] = categoryButton;

			add(categoryButton);
		}
	}
}
