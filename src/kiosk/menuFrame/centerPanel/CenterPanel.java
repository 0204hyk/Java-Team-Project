package kiosk.menuFrame.centerPanel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import kiosk.menuFrame.northPanel.North_SouthPanel;

public class CenterPanel extends JPanel{
	
	North_SouthPanel nsp = new North_SouthPanel();
	int count = 0;
	
	public CenterPanel() {
		
		
		setDisplay();
		
	

		menuButton();
		repaint();
		revalidate();
		
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

		North_SouthPanel nsp = new North_SouthPanel();
		int count = 0;

		System.out.println(nsp.categoryNum);
		
		for (int i = 0; i < 9; i++) {
			JButton menuButton = new JButton();
			menuButton.setContentAreaFilled(false);
			menuButton.setFocusPainted(false);

			try {
				count += 1;

				if (nsp.categoryNum == 7) {

					BufferedImage menuBufferedImage = ImageIO
							.read(new File("images/KioskImages/menu/coffee unselected/" + count + ".png"));

					menuButton.setIcon(new ImageIcon(menuBufferedImage));

					BufferedImage clcikedBufferedImage = ImageIO
							.read(new File("images/KioskImages/menu/coffee selected/" + count + ".png"));
					menuButton.setPressedIcon(new ImageIcon(clcikedBufferedImage));
					
					//System.out.println("hi!");
					
					
				}else if (nsp.categoryNum  == 8) {

					BufferedImage menuBufferedImage = ImageIO
							.read(new File("images/KioskImages/menu/noncoffee unselected/" + count + ".png"));

					menuButton.setIcon(new ImageIcon(menuBufferedImage));

					BufferedImage clcikedBufferedImage = ImageIO
							.read(new File("images/KioskImages/menu/noncoffee selected/" + count + ".png"));

					menuButton.setPressedIcon(new ImageIcon(clcikedBufferedImage));
					
					

				}else if (nsp.categoryNum  == 9) {

					BufferedImage menuBufferedImage = ImageIO
							.read(new File("images/KioskImages/menu/ade unselected/" + count + ".png"));

					menuButton.setIcon(new ImageIcon(menuBufferedImage));

					BufferedImage clcikedBufferedImage = ImageIO
							.read(new File("images/KioskImages/menu/ade selected/" + count + ".png"));

					menuButton.setPressedIcon(new ImageIcon(clcikedBufferedImage));

				}else if (nsp.categoryNum == 10) {

					BufferedImage menuBufferedImage = ImageIO
							.read(new File("images/KioskImages/menu/frappe unselected/" + count + ".png"));

					menuButton.setIcon(new ImageIcon(menuBufferedImage));

					BufferedImage clcikedBufferedImage = ImageIO
							.read(new File("images/KioskImages/menu/frappe selected/" + count + ".png"));

					menuButton.setPressedIcon(new ImageIcon(clcikedBufferedImage));

				}

				

				

				

			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			menuButton.setBorderPainted(false);
			menuButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			menuButton.setOpaque(false);
			
			add(menuButton);
			
		}
		
	}
	
	
	public void coffee(int categoryNum) {

	
		count = 0;

		for (int i = 0; i < 9; i++) {

			JButton menuButton = new JButton();
			menuButton.setContentAreaFilled(false);
			menuButton.setFocusPainted(false);

			try {
				count += 1;

				BufferedImage menuBufferedImage = ImageIO
						.read(new File("images/KioskImages/menu/coffee unselected/" + count + ".png"));

				menuButton.setIcon(new ImageIcon(menuBufferedImage));

				BufferedImage clcikedBufferedImage = ImageIO
						.read(new File("images/KioskImages/menu/coffee selected/" + count + ".png"));

				menuButton.setPressedIcon(new ImageIcon(clcikedBufferedImage));

			} catch (Exception e2) {
				e2.printStackTrace();
			}
			menuButton.setBorderPainted(false);
			menuButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			menuButton.setOpaque(false);

			add(menuButton);
			setVisible(true);
		}

	}
	
	public void noncoffee(int categoryNum) {
		
		count = 0;

		for (int i = 0; i < 9; i++) {

			JButton menuButton = new JButton();
			menuButton.setContentAreaFilled(false);
			menuButton.setFocusPainted(false);

			try {
				count += 1;

				BufferedImage menuBufferedImage = ImageIO
						.read(new File("images/KioskImages/menu/noncoffee unselected/" + count + ".png"));

				menuButton.setIcon(new ImageIcon(menuBufferedImage));

				BufferedImage clcikedBufferedImage = ImageIO
						.read(new File("images/KioskImages/menu/noncoffee selected/" + count + ".png"));

				menuButton.setPressedIcon(new ImageIcon(clcikedBufferedImage));

			} catch (Exception e2) {
				e2.printStackTrace();
			}
			menuButton.setBorderPainted(false);
			menuButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			menuButton.setOpaque(false);

			add(menuButton);
			setVisible(true);
		}
		
	}

	public void ade(int categoryNum) {
		count = 0;

		for (int i = 0; i < 9; i++) {

			JButton menuButton = new JButton();
			menuButton.setContentAreaFilled(false);
			menuButton.setFocusPainted(false);

			try {
				count += 1;

				BufferedImage menuBufferedImage = ImageIO
						.read(new File("images/KioskImages/menu/ade unselected/" + count + ".png"));

				menuButton.setIcon(new ImageIcon(menuBufferedImage));

				BufferedImage clcikedBufferedImage = ImageIO
						.read(new File("images/KioskImages/menu/ade selected/" + count + ".png"));

				menuButton.setPressedIcon(new ImageIcon(clcikedBufferedImage));

			} catch (Exception e2) {
				e2.printStackTrace();
			}
			menuButton.setBorderPainted(false);
			menuButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			menuButton.setOpaque(false);

			add(menuButton);
			setVisible(true);
		}
	}

	public void frappe(int categoryNum) {
		count = 0;

		for (int i = 0; i < 9; i++) {

			JButton menuButton = new JButton();
			menuButton.setContentAreaFilled(false);
			menuButton.setFocusPainted(false);

			try {
				count += 1;

				BufferedImage menuBufferedImage = ImageIO
						.read(new File("images/KioskImages/menu/frappe unselected/" + count + ".png"));

				menuButton.setIcon(new ImageIcon(menuBufferedImage));

				BufferedImage clcikedBufferedImage = ImageIO
						.read(new File("images/KioskImages/menu/frappe selected/" + count + ".png"));

				menuButton.setPressedIcon(new ImageIcon(clcikedBufferedImage));

			} catch (Exception e2) {
				e2.printStackTrace();
			}
			menuButton.setBorderPainted(false);
			menuButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			menuButton.setOpaque(false);

			add(menuButton);
			setVisible(true);
		}

	}

}
