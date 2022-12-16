package kiosk.menuFrame.northPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NorthPanel extends JPanel {
	
	JPanel North_NorthPanel = new JPanel();
	JPanel panel = new JPanel();
	JPanel coffeePanel = new JPanel();
	JPanel nonCoffeePanel = new JPanel();
	JPanel adePanel = new JPanel();
	JPanel frappePanel = new JPanel();
	JPanel nsp = new JPanel();
	private JLabel logo = new JLabel();
	private JButton homeButton = new JButton();
	

	public JPanel North_NorthPanel() {
		
		
		North_NorthPanel.setLayout(null);
		logo();
		homeButton();
		
		North_NorthPanel.setBackground(Color.white);
		return North_NorthPanel;
	}
	
	public void logo() {
		
		logo.setBounds(52, 25, 60, 83);
		
		
		try {
			BufferedImage logoBufferedImage2 =
			ImageIO.read(new File("images/KioskImages/3_메뉴선택/logoScaled.png"));			
			logo.setIcon(new ImageIcon(logoBufferedImage2));
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		North_NorthPanel.add(logo);
		
	}
	
	public void homeButton() {
		homeButton.setBorderPainted(false);	
		homeButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
		homeButton.setOpaque(false);
		
		homeButton.setFocusable(false);
		homeButton.setContentAreaFilled(false);
		homeButton.setFocusPainted(false);
		homeButton.setBounds(542, 44, 52, 52);
	
		try {
			BufferedImage homeBufferedImage2 =
			ImageIO.read(new File("images/KioskImages/3_메뉴선택/homeScaled.png"));
			
			homeButton.setIcon(new ImageIcon(homeBufferedImage2));
			
			BufferedImage pressedHomeBufferedImage2 =
					ImageIO.read(new File("images/KioskImages/3_메뉴선택/homePressedScaled.png"));
					
					homeButton.setPressedIcon(new ImageIcon(pressedHomeBufferedImage2));
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		North_NorthPanel.add(homeButton);
	}
	
	public NorthPanel() {
		
	setLayout(new GridLayout(0,1));
		
		add(new  North_NorthPanel());
		add(North_SouthPanel());
		
	}

	int count = 0;
	
	CardLayout card = new CardLayout();
	
	public void setPanel() {
		FlowLayout flow = new FlowLayout(); 
		
		flow.setHgap(-15);
		flow.setVgap(10);
		
		coffeePanel.setLayout(flow);
		coffeePanel.setBackground(Color.white);
		
		nonCoffeePanel.setLayout(flow);
		nonCoffeePanel.setBackground(Color.white);
		
		adePanel.setLayout(flow);
		adePanel.setBackground(Color.white);
		
		frappePanel.setLayout(flow);
		frappePanel.setBackground(Color.white);
		
		coffeePanel.setVisible(true);
		nonCoffeePanel.setVisible(true);
	}
	
	public JPanel North_SouthPanel() {
		
		//setPanel();
		panel();

		categoryButton();
		setBackground(Color.white);
		return nsp;
	}
	
	public void categoryButton() {

		GridLayout grid = new GridLayout(2, 5, 0, 5);
		nsp.setLayout(grid);
		nsp.setBackground(Color.white);
		int count = 0;
		JButton[] category = new JButton[10];
		
		JButton blankA = new JButton();
		JButton blankB = new JButton();
		JButton blankC = new JButton();
		JButton blankD = new JButton();
		JButton blankE = new JButton();
		JButton hotMenu = new JButton();
		JButton coffee = new JButton();
		JButton nonCoffee = new JButton();
		JButton ade = new JButton();
		JButton frappe = new JButton();
		
		category[0] = blankA;
		category[1] = blankB;
		category[2] = blankC;
		category[3] = blankD;
		category[4] = blankE;
		category[5] = hotMenu;
		category[6] = coffee;
		category[7] = nonCoffee;
		category[8] = ade;
		category[9] = frappe;

		for (int i = 0; i < 10; i++) {//버튼생성 for문

			category[i].setContentAreaFilled(false);
			category[i].setFocusPainted(false);

			try {
				count += 1;
				BufferedImage catogoryBufferedImage = ImageIO
						.read(new File("images/KioskImages/3_메뉴선택/menuImages/" + count + ".png"));
				category[i].setIcon(new ImageIcon(catogoryBufferedImage));

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				BufferedImage pushedBufferedImage = ImageIO
						.read(new File("images/KioskImages/3_메뉴선택/menuImages/6Pushed.png"));
				category[5].setIcon(new ImageIcon(pushedBufferedImage));
			} catch (Exception e) {
				// TODO: handle exception
			}

			category[i].setBorderPainted(false);
			category[i].setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			category[i].setOpaque(false);
			category[i].setPreferredSize(new Dimension(110, 46));
			nsp.add(category[i]);
		}

		
		category[5].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					BufferedImage pushedBufferedImage = ImageIO
							.read(new File("images/KioskImages/3_메뉴선택/menuImages/6Pushed.png"));
					category[5].setIcon(new ImageIcon(pushedBufferedImage));
					
					BufferedImage bufferedImage7 = ImageIO
							.read(new File("images/KioskImages/3_메뉴선택/menuImages/7.png"));
					category[6].setIcon(new ImageIcon(bufferedImage7));
					
					BufferedImage bufferedImage8 = ImageIO
							.read(new File("images/KioskImages/3_메뉴선택/menuImages/8.png"));
					category[7].setIcon(new ImageIcon(bufferedImage8));
					
					BufferedImage bufferedImage9 = ImageIO
							.read(new File("images/KioskImages/3_메뉴선택/menuImages/9.png"));
					
					category[8].setIcon(new ImageIcon(bufferedImage9));
					BufferedImage bufferedImage10 = ImageIO
							
							.read(new File("images/KioskImages/3_메뉴선택/menuImages/10.png"));
					category[9].setIcon(new ImageIcon(bufferedImage10));

				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			
				
			}
			
		});

		category[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					BufferedImage pushedBufferedImage = ImageIO
							.read(new File("images/KioskImages/3_메뉴선택/menuImages/7Pushed.png"));
					category[6].setIcon(new ImageIcon(pushedBufferedImage));

					BufferedImage bufferedImage7 = ImageIO.read(new File("images/KioskImages/3_메뉴선택/menuImages/6.png"));
					category[5].setIcon(new ImageIcon(bufferedImage7));

					BufferedImage bufferedImage8 = ImageIO.read(new File("images/KioskImages/3_메뉴선택/menuImages/8.png"));
					category[7].setIcon(new ImageIcon(bufferedImage8));

					BufferedImage bufferedImage9 = ImageIO.read(new File("images/KioskImages/3_메뉴선택/menuImages/9.png"));

					category[8].setIcon(new ImageIcon(bufferedImage9));

					BufferedImage bufferedImage10 = ImageIO

							.read(new File("images/KioskImages/3_메뉴선택/menuImages/10.png"));
					category[9].setIcon(new ImageIcon(bufferedImage10));
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				System.out.println("hi2");
			

				card.show(panel, "coffee");
				
				
			}
		
		});

		category[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					BufferedImage pushedBufferedImage = ImageIO
							.read(new File("images/KioskImages/3_메뉴선택/menuImages/8Pushed.png"));
					category[7].setIcon(new ImageIcon(pushedBufferedImage));

					BufferedImage bufferedImage7 = ImageIO.read(new File("images/KioskImages/3_메뉴선택/menuImages/6.png"));
					category[5].setIcon(new ImageIcon(bufferedImage7));

					BufferedImage bufferedImage8 = ImageIO.read(new File("images/KioskImages/3_메뉴선택/menuImages/7.png"));
					category[6].setIcon(new ImageIcon(bufferedImage8));

					BufferedImage bufferedImage9 = ImageIO.read(new File("images/KioskImages/3_메뉴선택/menuImages/9.png"));

					category[8].setIcon(new ImageIcon(bufferedImage9));
					BufferedImage bufferedImage10 = ImageIO

							.read(new File("images/KioskImages/3_메뉴선택/menuImages/10.png"));
					category[9].setIcon(new ImageIcon(bufferedImage10));

				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				System.out.println("hi8");
				card.show(panel, "nonCoffee");
			}
			
		});

		category[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					BufferedImage pushedBufferedImage = ImageIO
							.read(new File("images/KioskImages/3_메뉴선택/menuImages/9Pushed.png"));
					category[8].setIcon(new ImageIcon(pushedBufferedImage));

					BufferedImage bufferedImage7 = ImageIO.read(new File("images/KioskImages/3_메뉴선택/menuImages/6.png"));
					category[5].setIcon(new ImageIcon(bufferedImage7));

					BufferedImage bufferedImage8 = ImageIO.read(new File("images/KioskImages/3_메뉴선택/menuImages/7.png"));
					category[6].setIcon(new ImageIcon(bufferedImage8));

					BufferedImage bufferedImage9 = ImageIO.read(new File("images/KioskImages/3_메뉴선택/menuImages/8.png"));

					category[7].setIcon(new ImageIcon(bufferedImage9));
					BufferedImage bufferedImage10 = ImageIO

							.read(new File("images/KioskImages/3_메뉴선택/menuImages/10.png"));
					category[9].setIcon(new ImageIcon(bufferedImage10));

				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				card.show(panel, "ade");
				
			}
			// action기능추가
		});

		category[9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					BufferedImage pushedBufferedImage = ImageIO
							.read(new File("images/KioskImages/3_메뉴선택/menuImages/10Pushed.png"));
					category[9].setIcon(new ImageIcon(pushedBufferedImage));

					BufferedImage bufferedImage7 = ImageIO.read(new File("images/KioskImages/3_메뉴선택/menuImages/6.png"));
					category[5].setIcon(new ImageIcon(bufferedImage7));

					BufferedImage bufferedImage8 = ImageIO.read(new File("images/KioskImages/3_메뉴선택/menuImages/7.png"));
					category[6].setIcon(new ImageIcon(bufferedImage8));

					BufferedImage bufferedImage9 = ImageIO.read(new File("images/KioskImages/3_메뉴선택/menuImages/8.png"));

					category[7].setIcon(new ImageIcon(bufferedImage9));
					BufferedImage bufferedImage10 = ImageIO

							.read(new File("images/KioskImages/3_메뉴선택/menuImages/9.png"));
					category[8].setIcon(new ImageIcon(bufferedImage10));

				} catch (Exception e2) {
					e2.printStackTrace();
				}
				card.show(panel, "frappe");
			}
			// action기능추가
		});

	}
			
	public JPanel panel() {
		
		setPanel();

		adePanel();
		coffeePanel();
		noncoffeePanel();
		frappePanel();
		
		
		panel.setLayout(card);

		panel.add(coffeePanel, "coffee");
		panel.add(nonCoffeePanel, "nonCoffee");
		panel.add(adePanel, "ade");
		panel.add(frappePanel, "frappe");
	
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

		JButton[] noncoffee = new JButton[9];

		JButton sweetPotatoLatte = new JButton();
		JButton greenTeaLatte = new JButton();
		JButton fiveGrainLatte = new JButton();
		JButton chocolateLatte = new JButton();
		JButton pistachioLatte = new JButton();
		JButton blank1 = new JButton();
		JButton blank2 = new JButton();
		JButton blank3 = new JButton();
		JButton blank4 = new JButton();
		
		noncoffee[0] = sweetPotatoLatte;
		noncoffee[1] = greenTeaLatte;
		noncoffee[2] = fiveGrainLatte;
		noncoffee[3] = chocolateLatte;
		noncoffee[4] = pistachioLatte;
		noncoffee[5] = blank1;
		noncoffee[6] = blank2;
		noncoffee[7] = blank3;
		noncoffee[8] = blank4;

		count=0;
		
		for (int i = 0; i < 9; i++) {

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

	public void adePanel() {

		JButton[] ade = new JButton[9];

		JButton lemonade = new JButton();
		JButton grapeFruitAde = new JButton();
		JButton greenGrapeAde = new JButton();
		JButton blank1 = new JButton();
		JButton blank2 = new JButton();
		JButton blank3 = new JButton();
		JButton blank4 = new JButton();
		JButton blank5 = new JButton();
		JButton blank6 = new JButton();

		ade[0] = lemonade;
		ade[1] = grapeFruitAde;
		ade[2] = greenGrapeAde;
		ade[3] = blank1;
		ade[4] = blank2;
		ade[5] = blank3;
		ade[6] = blank4;
		ade[7] = blank5;
		ade[8] = blank6;

		count=0;
		
		for (int i = 0; i < 9; i++) {

			ade[i].setContentAreaFilled(false);
			ade[i].setFocusPainted(false);

			try {
				count += 1;

				BufferedImage menuBufferedImage = ImageIO
						.read(new File("images/KioskImages/menu/ade unselected/" + count + ".png"));

				ade[i].setIcon(new ImageIcon(menuBufferedImage));

				BufferedImage clcikedBufferedImage = ImageIO
						.read(new File("images/KioskImages/menu/ade selected/" + count + ".png"));
				ade[i].setPressedIcon(new ImageIcon(clcikedBufferedImage));

				System.out.println("hi!");
			} catch (Exception e) {
				e.printStackTrace();
			}

			ade[i].setBorderPainted(false);
			ade[i].setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			ade[i].setOpaque(false);

			adePanel.add(ade[i]);
			
		}
	}
	
	public void frappePanel() {

		JButton[] frappe = new JButton[9];

		JButton greenTeaFrappe = new JButton();
		JButton strawberryGelatoFrappe = new JButton();
		JButton redAppleFrappe = new JButton();
		JButton appleMangoFrappe = new JButton();
		JButton chocolateChipFrappe = new JButton();
		JButton chocolateCookiegelatFrappe = new JButton();
		JButton	coldBrewMochaFrappe = new JButton();
		JButton	coldBrewCaramelFrappe = new JButton();
		JButton	coldBrewFrappe = new JButton();

		frappe[0] = greenTeaFrappe;
		frappe[1] = strawberryGelatoFrappe;
		frappe[2] = redAppleFrappe;
		frappe[3] = appleMangoFrappe;
		frappe[4] = chocolateChipFrappe;
		frappe[5] = chocolateCookiegelatFrappe;
		frappe[6] = coldBrewMochaFrappe;
		frappe[7] = coldBrewCaramelFrappe;
		frappe[8] = coldBrewFrappe;

		count=0;
		
		for (int i = 0; i < 9; i++) {

			frappe[i].setContentAreaFilled(false);
			frappe[i].setFocusPainted(false);

			try {
				count += 1;

				BufferedImage menuBufferedImage = ImageIO
						.read(new File("images/KioskImages/menu/frappe unselected/" + count + ".png"));

				frappe[i].setIcon(new ImageIcon(menuBufferedImage));

				BufferedImage clcikedBufferedImage = ImageIO
						.read(new File("images/KioskImages/menu/frappe selected/" + count + ".png"));
				frappe[i].setPressedIcon(new ImageIcon(clcikedBufferedImage));

				System.out.println("hi!");
			} catch (Exception e) {
				e.printStackTrace();
			}

			frappe[i].setBorderPainted(false);
			frappe[i].setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			frappe[i].setOpaque(false);

			frappePanel.add(frappe[i]);

		}
	}
	

	
	
}
