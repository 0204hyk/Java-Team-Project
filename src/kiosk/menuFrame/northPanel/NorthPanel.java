package kiosk.menuFrame.northPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

import kiosk.byoption.All_1;
import kiosk.byoption.NoDecaf_7;
import kiosk.byoption.NoHotMilk_4;
import kiosk.byoption.NoHot_3;
import kiosk.byoption.NoMilk_2;
import kiosk.byoption.OnlyDecafShotCup_6;
import kiosk.byoption.OnlyShotCup_5;
import kiosk.byoption.OnlyShotIceCup_8;
import kiosk.byoption.TopImage;
import kiosk.tools.WithImage;

public class NorthPanel extends JPanel {
	
	String root = "images/KioskImages/3. 메뉴선택";
	WithImage wi = new WithImage(root);
	
	
	JPanel North_NorthPanel = new JPanel();
	JPanel panel = new JPanel();
	JPanel nsp = new JPanel();
	
	CardLayout card = new CardLayout();

	JPanel coffeePanel = new JPanel();
	JPanel coffeePanel2 = new JPanel();
	JPanel nonCoffeePanel = new JPanel();
	JPanel adePanel = new JPanel();
	JPanel frappePanel = new JPanel();

	private JLabel logo = new JLabel();
	private JButton homeButton = new JButton();
	
	Font font = new Font("맑은 고딕", Font.BOLD, 15);
	int count = 0;

	public JPanel North_NorthPanel() {
		
		
		North_NorthPanel.setLayout(null);
		logo();
		homeButton();
		
		North_NorthPanel.setBackground(Color.white);
		return North_NorthPanel;
	}
	
	public void logo() {
		
		North_NorthPanel.add(wi.makeButton("hy.png", 53,24,60,83));
		
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

	public void setPanel() {
		FlowLayout flow = new FlowLayout(); 
		
		flow.setHgap(-15);
		flow.setVgap(10);
		
		coffeePanel.setLayout(flow);
		coffeePanel.setBackground(Color.white);
		
		coffeePanel2.setLayout(flow);
		coffeePanel2.setBackground(Color.white);
		
		nonCoffeePanel.setLayout(flow);
		nonCoffeePanel.setBackground(Color.white);
		
		adePanel.setLayout(flow);
		adePanel.setBackground(Color.white);
		
		frappePanel.setLayout(flow);
		frappePanel.setBackground(Color.white);
		

		
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
					
					nextButton.setEnabled(true);
					prevButton.setEnabled(true);
					
					nextButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							card.show(panel, "coffee2");
						}
					});

					prevButton.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							card.show(panel, "coffee");
						}
					});

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			

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

					nextButton.setEnabled(false);
					prevButton.setEnabled(false);
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
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

					nextButton.setEnabled(false);
					prevButton.setEnabled(false);
					
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

					nextButton.setEnabled(false);
					prevButton.setEnabled(false);
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				card.show(panel, "frappe");
			}
			// action기능추가
		});

	}
			
	public void coffeePanel() {
		
		JButton[] coffee = new JButton[10];
		
		JButton espresso = new JButton();
		JButton americano = new JButton();
		JButton cafeLatte = new JButton();
		JButton cafeMocha = new JButton();
		JButton dolceLatte = new JButton();
		JButton vanillaLatte = new JButton();
		JButton caramelMacchiato = new JButton();
		JButton HazelnutLatte = new JButton();
		JButton coldBrew = new JButton();
		JButton coldBrewLatte = new JButton();

		coffee[0] = espresso;
		coffee[1] = americano;
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

		
			} catch (Exception e) {
				e.printStackTrace();
			}
			coffee[i].setVerticalTextPosition(JButton.CENTER);
			coffee[i].setHorizontalTextPosition(JButton.CENTER);
			coffee[i].setText("3500원");
			coffee[i].setFont(font);
			coffee[i].setForeground(new Color(32, 31, 81));
			
			coffee[i].setBorderPainted(false);
			coffee[i].setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			coffee[i].setOpaque(false);

			int menu = i;
			coffee[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					switch (menu) {
					case 0:
						new NoMilk_2(new TopImage("에스프레소"));
						break;
					case 1:
						new NoMilk_2(new TopImage("아메리카노"));
						break;
					case 2:
						new All_1(new TopImage("카페라떼"));
						break;
					case 3:
						new All_1(new TopImage("카페모카"));
						break;
					case 4:
						new All_1(new TopImage("카페모카"));
						break;
					case 5:
						new All_1(new TopImage("바닐라 라떼"));
						break;
					case 6:
						new All_1(new TopImage("카라멜 마끼아또"));
						break;
					case 7:
						new All_1(new TopImage("헤이즐넛 라떼"));
						break;
					case 8:
						new NoHotMilk_4(new TopImage("콜드브루"));
						break;
					case 9:
						new NoHot_3(new TopImage("콜드브루 라떼"));
						break;

					}

				}
			});
			
			coffeePanel.add(coffee[i]);
			
		}
			coffee[0].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});

	}

	public void coffeePanel2() {
		
		JButton[] coffee2 = new JButton[9];

		JButton coldBrewLatte = new JButton();
		JButton blank1 = new JButton();
		JButton blank2 = new JButton();
		JButton blank3 = new JButton();
		JButton blank4 = new JButton();
		JButton blank5 = new JButton();
		JButton blank6 = new JButton();
		JButton blank7 = new JButton();
		JButton blank8 = new JButton();
		
		coffee2[0] = coldBrewLatte;
		coffee2[1] = blank1;
		coffee2[2] = blank2;
		coffee2[3] = blank3;
		coffee2[4] = blank4;
		coffee2[5] = blank5;
		coffee2[6] = blank6;
		coffee2[7] = blank7;
		coffee2[8] = blank8;
		
		int coffeeCount=0;
		
		for (int i = 0; i < 9; i++) {

			coffee2[i].setContentAreaFilled(false);
			coffee2[i].setFocusPainted(false);

			try {
				coffeeCount += 1;

				BufferedImage menuBufferedImage = ImageIO
						.read(new File("images/KioskImages/menu/coffee unselected/coffee2/" + coffeeCount + ".png"));

				coffee2[i].setIcon(new ImageIcon(menuBufferedImage));

				BufferedImage clcikedBufferedImage = ImageIO
						.read(new File("images/KioskImages/menu/coffee selected/coffee2/" + coffeeCount + ".png"));
				coffee2[i].setPressedIcon(new ImageIcon(clcikedBufferedImage));

		
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			coffee2[i].setBorderPainted(false);
			coffee2[i].setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			coffee2[i].setOpaque(false);
			coffeePanel2.add(coffee2[i]);
			
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

			
			} catch (Exception e) {
				e.printStackTrace();
			}

			noncoffee[i].setBorderPainted(false);
			noncoffee[i].setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			noncoffee[i].setOpaque(false);

			int menu = i;
			noncoffee[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

//					
//					noncoffee[0] = sweetPotatoLatte;
//					noncoffee[1] = greenTeaLatte;
//					noncoffee[2] = fiveGrainLatte;
//					noncoffee[3] = chocolateLatte;
//					noncoffee[4] = pistachioLatte;
					switch (menu) {
					case 0:
						new NoDecaf_7(new TopImage("고구마 라떼"));
						break;
					case 1:
						new NoDecaf_7(new TopImage("녹차 라떼"));
						break;
					case 2:
						new NoDecaf_7(new TopImage("오곡 라떼"));
						break;
					case 3:
						new NoDecaf_7(new TopImage("초코 라떼"));
						break;
					case 4:
						new NoDecaf_7(new TopImage("피스타치오 라떼"));
						break;
					}
				}
			});
			
			
			
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


			} catch (Exception e) {
				e.printStackTrace();
			}

			ade[i].setBorderPainted(false);
			ade[i].setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			ade[i].setOpaque(false);
			
			int menu = i;
			ade[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					switch (menu) {
					case 0:
						new OnlyShotIceCup_8(new TopImage("레몬 에이드"));
						break;
					case 1:
						new OnlyShotIceCup_8(new TopImage("자몽 에이드"));
						break;
					case 2:
						new OnlyShotIceCup_8(new TopImage("청포도 에이드"));
						break;
					}

				}
			});
			
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


			} catch (Exception e) {
				e.printStackTrace();
			}

			frappe[i].setBorderPainted(false);
			frappe[i].setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			frappe[i].setOpaque(false);

			int menu = i;
			frappe[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					switch (menu) {

					case 0:
						new OnlyShotCup_5(new TopImage("그린티 프라페"));
						break;
					case 1:
						new OnlyShotCup_5(new TopImage("딸기 젤라또 프라페"));
						break;
					case 2:
						new OnlyShotCup_5(new TopImage("레드 애플 프라페"));
						break;
					case 3:
						new OnlyShotCup_5(new TopImage("애플 망고 프라페"));
						break;
					case 4:
						new OnlyShotCup_5(new TopImage("초코칩 프라페"));
						break;
					case 5:
						new OnlyShotCup_5(new TopImage("초콜릿 쿠키 젤라또 프라페"));
						break;
					case 6:
						new OnlyDecafShotCup_6(new TopImage("콜드브루 모카 프라페"));
						break;
					case 7:
						new OnlyDecafShotCup_6(new TopImage("콜드브루 카라멜 프라페"));
						break;
					case 8:
						new OnlyDecafShotCup_6(new TopImage("콜드브루 프라페"));
						break;

					}

				}
			});
			
			frappePanel.add(frappe[i]);

		}
	}
	
	JPanel eastPanel = new JPanel();
	JButton nextButton = new JButton();
	JButton blankButton = new JButton();

	public JPanel panel() {

		setPanel();

		adePanel();
		coffeePanel();
		noncoffeePanel();
		frappePanel();
		coffeePanel2();

		panel.setLayout(card);

		panel.add(frappePanel, "frappe");
		panel.add(coffeePanel, "coffee");
		panel.add(coffeePanel2, "coffee2");
		panel.add(nonCoffeePanel, "nonCoffee");
		panel.add(adePanel, "ade");

		// panel.setBackground(Color.white);

		return panel;
	}

	public JPanel eastPanel() {
		eastPanel.setLayout(new BorderLayout());
		eastPanel.setBackground(Color.white);
		nextButton.setContentAreaFilled(false);
		nextButton.setFocusPainted(false);

		try {
			BufferedImage logoBufferedImage = ImageIO.read(new File("images/KioskImages/3_메뉴선택/nextButtonScaled.png"));
			nextButton.setIcon(new ImageIcon(logoBufferedImage));

			BufferedImage pressedBufferedImage = ImageIO
					.read(new File("images/KioskImages/3_메뉴선택/nextButtonPressedScaled.png"));
			nextButton.setPressedIcon(new ImageIcon(pressedBufferedImage));

			nextButton.setBorderPainted(false);
			nextButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			nextButton.setOpaque(false);
			nextButton.setPreferredSize(new Dimension(40, 40));

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		try {
			BufferedImage BufferedImage = ImageIO
					.read(new File("images/KioskImages/3_메뉴선택/menuImages/buttonBlank.png"));
			blankButton.setIcon(new ImageIcon(BufferedImage));

			blankButton.setPreferredSize(new Dimension(10, 10)); // (동쪽 버튼옆 여백 지정)
			blankButton.setBorderPainted(false);
			blankButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			blankButton.setOpaque(false);

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		eastPanel.add(nextButton, BorderLayout.WEST);
		eastPanel.add(blankButton, BorderLayout.EAST);
		return eastPanel;
	}

	JPanel westPanel = new JPanel();
	JButton prevButton = new JButton();

	public JPanel westPanel() {

		westPanel.setLayout(new BorderLayout());
		westPanel.setBackground(Color.white);

		try {
			BufferedImage logoBufferedImage = ImageIO.read(new File("images/KioskImages/3_메뉴선택/prevButtonScaled.png"));
			prevButton.setIcon(new ImageIcon(logoBufferedImage));

			BufferedImage pressedBufferedImage = ImageIO
					.read(new File("images/KioskImages/3_메뉴선택/prevButtonPressedScaled.png"));
			prevButton.setPressedIcon(new ImageIcon(pressedBufferedImage));
			prevButton.setContentAreaFilled(false);
			prevButton.setFocusPainted(false);
			prevButton.setPreferredSize(new Dimension(40, 40));
			prevButton.setBorderPainted(false);
			prevButton.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			prevButton.setOpaque(false);

		} catch (Exception e2) {
			e2.printStackTrace();
		}

		// Borderlayout 사용하여 옆쪽 여백주기위해서 공백버튼
		JButton button2 = new JButton();
		try {
			BufferedImage BufferedImage = ImageIO
					.read(new File("images/KioskImages/3_메뉴선택/menuImages/buttonBlank.png"));
			button2.setIcon(new ImageIcon(BufferedImage));

			button2.setPreferredSize(new Dimension(10, 10)); // (서쪽 버튼옆 여백 지정)
			button2.setBorderPainted(false);
			button2.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			button2.setOpaque(false);

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		westPanel.add(prevButton, BorderLayout.EAST);
		westPanel.add(button2, BorderLayout.WEST);

		return westPanel;
	}

}
