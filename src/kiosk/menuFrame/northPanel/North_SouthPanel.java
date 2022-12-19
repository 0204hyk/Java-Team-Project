package kiosk.menuFrame.northPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class North_SouthPanel extends JPanel {
	
	public int categoryNum;
	int count = 0;
	
	//CenterPanel cp = new CenterPanel();

	public int getCategoryNum() {
		return categoryNum;
	}

	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}

	public North_SouthPanel() {
		setPanel();

		categoryButton();
		//coffeePanel();
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
			buttons[i] = categoryButton;

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
										.read(new File("images/KioskImages/3_메뉴선택/menuImages/" + (j + 1) + ".png"));
								buttons[j].setIcon(new ImageIcon(resetBufferedImage));

							} catch (Exception e2) {
								e2.printStackTrace();
							}

						}

						setCategoryNum(Arrays.asList(buttons).indexOf(categoryButton) + 1);
						System.out.println(categoryNum);
						categoryButton.setIcon(new ImageIcon(clcikedBufferedImage));
						
						if (categoryNum == 7) {
							
							coffeePanel();
							panel.add(coffeePanel);
							
													
						}
						if (categoryNum == 8) {
							
							noncoffeePanel();
							panel.add(nonCoffeePanel);
							revalidate();
							
						}
					}
				});

				if (count == 6) {// 신메뉴 기본선택
					categoryButton.setIcon(new ImageIcon(clcikedBufferedImage));
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
	JPanel panel = new JPanel();
	JPanel coffeePanel = new JPanel();
	JPanel nonCoffeePanel = new JPanel();
	
	
	public void setPanel() {
		FlowLayout flow = new FlowLayout(); 
		flow.setHgap(-15);
		flow.setVgap(10);
		coffeePanel.setLayout(flow);
		coffeePanel.setBackground(Color.white);
		nonCoffeePanel.setLayout(flow);
		nonCoffeePanel.setBackground(Color.white);
		
	}
	
	
	
	
	public JPanel panel() {
		
		

		
		//panel.setBackground(Color.white);
		
		
		return panel;
	}

	public void coffeePanel() {
		
		JButton[] coffee = new JButton[10];
		
		JButton americano = new JButton();
		JButton espresso = new JButton();
		JButton cafeLatte = new JButton();
		JButton cafeMocha = new JButton();
		JButton dolceLatte = new JButton();
		JButton vanillaLatte = new JButton();
		JButton caramelMacchiato = new JButton();
		JButton HazelnutLatte = new JButton();
		JButton coldBrew = new JButton();
		JButton coldBrewLatte = new JButton();

		coffee[0] = americano;
		coffee[1] = espresso;
		coffee[2] = cafeLatte;
		coffee[3] = cafeMocha;
		coffee[4] = dolceLatte;
		coffee[5] = vanillaLatte;
		coffee[6] = caramelMacchiato ;
		coffee[7] = HazelnutLatte;
		coffee[8] = coldBrew;
		coffee[9] = coldBrewLatte;

		int coffeeCount=0;
		
		for (int i = 0; i < 9; i++) {

			coffee[i].setContentAreaFilled(false);
			coffee[i].setFocusPainted(false);

			try {
				coffeeCount += 1;

				BufferedImage menuBufferedImage = ImageIO
						.read(new File("images/KioskImages/menu/coffee unselected/" + coffeeCount + ".png"));

				coffee[i].setIcon(new ImageIcon(menuBufferedImage));

				BufferedImage clcikedBufferedImage = ImageIO
						.read(new File("images/KioskImages/menu/coffee selected/" + coffeeCount + ".png"));
				coffee[i].setPressedIcon(new ImageIcon(clcikedBufferedImage));

				System.out.println("hi!");
			} catch (Exception e) {
				e.printStackTrace();
			}

			coffee[i].setBorderPainted(false);
			coffee[i].setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			coffee[i].setOpaque(false);

			coffeePanel.add(coffee[i]);
			
		}

	}

	public void noncoffeePanel() {

		JButton[] noncoffee = new JButton[5];

		JButton sweetPotatoLatte = new JButton();
		JButton greenTeaLatte = new JButton();
		JButton fiveGrainLatte = new JButton();
		JButton chocolateLatte = new JButton();
		JButton pistachioLatte = new JButton();

		noncoffee[0] = sweetPotatoLatte;
		noncoffee[1] = greenTeaLatte;
		noncoffee[2] = fiveGrainLatte;
		noncoffee[3] = chocolateLatte;
		noncoffee[4] = pistachioLatte;

		count=0;
		
		for (int i = 0; i < 5; i++) {

			noncoffee[i].setContentAreaFilled(false);
			noncoffee[i].setFocusPainted(false);

			try {
				count += 1;

				BufferedImage menuBufferedImage = ImageIO
						.read(new File("images/KioskImages/menu/noncoffee unselected/" + count + ".png"));

				noncoffee[i].setIcon(new ImageIcon(menuBufferedImage));

				BufferedImage clcikedBufferedImage = ImageIO
						.read(new File("images/KioskImages/menu/noncoffee selected/" + count + ".png"));
				noncoffee[i].setPressedIcon(new ImageIcon(clcikedBufferedImage));

				System.out.println("hi!");
			} catch (Exception e) {
				e.printStackTrace();
			}

			noncoffee[i].setBorderPainted(false);
			noncoffee[i].setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			noncoffee[i].setOpaque(false);

			nonCoffeePanel.add(noncoffee[i]);

		}
	}

}
