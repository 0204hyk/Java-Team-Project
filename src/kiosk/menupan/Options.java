package kiosk.menupan;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import database.kiosk.fromdb.GetImageInfo;
import kiosk.byoption.Cups;
import kiosk.tools.GroupButtons;
import kiosk.tools.WithImage;

public class Options extends JFrame {
	String root = "images/KioskImages/4. detailedOption";
	WithImage wi = new WithImage(root);

	String hotAndIce;
	String decaffein;
	String cup;
	String sizes;
	String shot;
	String ice;
	String milk;

	String menu;
	ChoiceMenu frame;

	Cups cupText = new Cups();

	ArrayList<String> menuInfo = new ArrayList<>();

	static public ChoiceMenu choiceMenu;

	public Options(String menu, ChoiceMenu frame) {
		this.menu = menu;
		this.frame = frame;

		defaults();
		setUndecorated(true);
		setLayout(null);
		setSize(650, 950);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);

	}

	public void defaults() {

		cupText.setBounds(470, 174, 47, 23);
		cupText.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		cupText.setHorizontalAlignment(JLabel.CENTER);
		cupText.setVerticalAlignment(JLabel.CENTER);

		add(wi.makeLabel("hy.png", 53, 24, 60, 83));
		JButton home = wi.makeButton("home.png", 543, 44, 52, 52);
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});

		JButton minus = wi.makeButton("minus.png", 420, 170, 32, 32);

		minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (cupText.cup > 1) {
					cupText.setCup(cupText.cup - 1);

				} else if (cupText.cup < 1) {
					cupText.setCup(1);
				}
				cupText.setText(cupText.cup + "잔");

			}
		});

		JButton plus = wi.makeButton("plus.png", 533, 170, 32, 32);

		plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cupText.cup > 98) {
					cupText.cup = 99;
				} else {
					cupText.setCup(cupText.cup + 1);
				}
				cupText.setText(cupText.cup + "잔");

			}
		});

		// 여기서 컵을 보내줘야한다, 옵션 포함된 가격 추가
		JButton put = wi.makeButton("put.png", 333, 817, 192, 68);
		put.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 1. 옵션 미선택 된 부분 막기 2. 담아서 장바구니로 넘기기
				GetImageInfo gi = new GetImageInfo(menu);
				int howManyNull = Collections.frequency(getOptionText(), null);
				int categoryNum = gi.getMenuOptionCategory();
				int optionPrice = 0;

				// 디카페인
				if (getOptionText().get(1) == "2") {
					optionPrice += 1000;
				}

				// 사이즈
				if (getOptionText().get(3) == "2") {
					optionPrice += 500;
				} else if (getOptionText().get(3) == "3") {
					optionPrice += 1000;
				}

				// 샷
				if (getOptionText().get(4) == "2") {
					optionPrice += 300;
				} else if (getOptionText().get(4) == "3") {
					optionPrice += 600;
				}

				// 우유
				if (getOptionText().get(6) == "2") {
					optionPrice += 300;
				} else if (getOptionText().get(6) == "3") {
					optionPrice += 300;
				}

				if (hotAndIce == null) {
					hotAndIce = "3";
				}

				if (categoryNum == 1 && howManyNull != 0 || categoryNum == 2 && howManyNull != 1
						|| categoryNum == 3 && howManyNull != 1 || categoryNum == 4 && howManyNull != 2
						|| categoryNum == 5 && howManyNull != 5 || categoryNum == 6 && howManyNull != 4
						|| categoryNum == 7 && howManyNull != 1 || categoryNum == 8 && howManyNull != 4) {

					JFrame alert = new JFrame();

					JButton confirm = wi.makeButton("confirm.png", 149, 131, 80, 41);

					confirm.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							alert.dispose();
						}
					});

					alert.add(confirm);
					alert.add(wi.makeLabel("pleaseSelectAll.png", 0, 0, 379, 213));
					alert.setUndecorated(true);
					alert.setSize(379, 213);
					alert.setLocationRelativeTo(null);
					alert.setVisible(true);

				} else {

					AMenu menuPn = new AMenu(menu, cupText,
							hotAndIce.equals("1") ? "HOT" : hotAndIce.equals("2") ? "ICE" : "ICE ONLY", optionPrice,
							frame, numToMenu(), optionNums());

					// 메뉴 정보 담아서 보내기
					menuInfo.add(menu);
					menuInfo.add(cupText.cup + "");
					menuInfo.add((optionPrice + gi.getMenuPrice()) + "");
					menuInfo.add(numToMenu());
					menuInfo.add(optionNums());

					frame.makeMenu(menuPn, cupText, menuInfo);
					frame.setVisible(true);
					frame.paint(frame.getGraphics());

					dispose();
				}

			}
		});

		JButton cancel = wi.makeButton("cancel.png", 124, 815, 192, 68);

		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});

		add(cupText);
		add(minus);
		add(plus);
		add(put);
		add(cancel);
	}

	public void hotAndIce(int x, int y) {

		add(wi.makeLabel("hot, ice.png", x, y, 45, 16));
		JButton hot = wi.makeButton("hot.png", x + 173, y - 20, 78, 54);
		JButton ice = wi.makeButton("ice.png", x + 257, y - 20, 78, 54);
		add(hot);
		add(ice);

		hot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hotAndIce = "1"; // "Hot";
			}
		});

		ice.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hotAndIce = "2"; // "Ice";
			}
		});

		new GroupButtons(hot, ice, "hot", "ice", 78, 54);
	}

	public void decaffein(int x, int y) {

		add(wi.makeLabel("changeDecaffein.png", x, y, 119, 17));
		JButton noDecaffein = wi.makeButton("noDecaffein.png", x + 173, y - 20, 78, 54);
		JButton toDecaffein = wi.makeButton("toDecaffein.png", x + 257, y - 20, 78, 54);
		add(noDecaffein);
		add(toDecaffein);
		new GroupButtons(noDecaffein, toDecaffein, "noDecaffein", "toDecaffein", 78, 54);

		noDecaffein.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				decaffein = "1"; // "NoDecaffein";

			}
		});

		toDecaffein.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				decaffein = "2"; // "Decaffein";
			}
		});

	}

	public void cup(int x, int y) {
		add(wi.makeLabel("selectCup.png", x, y, 66, 17));
		JButton useDisposal = wi.makeButton("useDisposal.png", x + 173, y - 20, 78, 54);
		JButton useTumbler = wi.makeButton("useTumbler.png", x + 257, y - 20, 78, 54);
		add(useDisposal);
		add(useTumbler);
		new GroupButtons(useDisposal, useTumbler, "useDisposal", "useTumbler", 78, 54);

		useDisposal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cup = "1";// "Disposal";
			}
		});

		useTumbler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cup = "2";// "Tumbler";
			}
		});
	}

	public void sizes(int x, int y) {
		add(wi.makeLabel("selectSize.png", x, y, 103, 17));
		JButton S = wi.makeButton("S.png", x + 173, y - 20, 78, 54);
		JButton M = wi.makeButton("M.png", x + 257, y - 20, 78, 54);
		JButton L = wi.makeButton("L.png", x + 343, y - 20, 78, 54);
		add(S);
		add(M);
		add(L);
		new GroupButtons(S, M, L, "S", "M", "L", 78, 54);

		S.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				sizes = "1";// "S";
			}
		});

		M.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sizes = "2";// "M";
			}
		});

		L.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sizes = "3";// "L";
			}
		});
	}

	public void shot(int x, int y) {
		add(wi.makeLabel("selectShot.png", x, y, 68, 18));
		JButton noShot = wi.makeButton("noShot.png", x + 173, y - 20, 78, 54);
		JButton oneShot = wi.makeButton("oneShot.png", x + 257, y - 20, 78, 54);
		JButton twoShot = wi.makeButton("twoShot.png", x + 343, y - 20, 78, 54);
		add(noShot);
		add(oneShot);
		add(twoShot);
		new GroupButtons(noShot, oneShot, twoShot, "noShot", "oneShot", "twoShot", 78, 54);

		noShot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				shot = "1";// "NoShot";
			}
		});

		oneShot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				shot = "2";// "OneShot";
			}
		});

		twoShot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				shot = "3";// "TwoShot";
			}
		});
	}

	public void ice(int x, int y) {
		add(wi.makeLabel("selectIce.png", x, y, 83, 17));
		JButton normalIce = wi.makeButton("normalIce.png", x + 173, y - 20, 78, 54);
		JButton lessIce = wi.makeButton("lessIce.png", x + 257, y - 20, 78, 54);
		JButton noIce = wi.makeButton("noIce.png", x + 343, y - 20, 78, 54);
		add(normalIce);
		add(lessIce);
		add(noIce);
		new GroupButtons(normalIce, lessIce, noIce, "normalIce", "lessIce", "noIce", 78, 54);

		normalIce.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ice = "1";// "Normal";
			}
		});

		lessIce.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ice = "2";// "Less";
			}
		});

		noIce.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ice = "3";// "None";
			}
		});
	}

	public void milk(int x, int y) {
		add(wi.makeLabel("selectMilk.png", x, y, 85, 16));
		JButton basicMilk = wi.makeButton("basicMilk.png", x + 173, y - 20, 78, 54);
		JButton toSoy = wi.makeButton("toSoy.png", x + 257, y - 20, 78, 54);
		JButton toLowfat = wi.makeButton("toLowfat.png", x + 343, y - 20, 78, 54);
		add(basicMilk);
		add(toSoy);
		add(toLowfat);
		new GroupButtons(basicMilk, toSoy, toLowfat, "basicMilk", "toSoy", "toLowfat", 78, 54);

		basicMilk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				milk = "1";// "Basic";
			}
		});

		toSoy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				milk = "2";// "Soy";
			}
		});

		toLowfat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				milk = "3";// "Lowfat";
			}
		});
	}

	public ArrayList getOptionText() {
		ArrayList<String> options = new ArrayList<>();

		options.add(hotAndIce);
		options.add(decaffein);
		options.add(cup);
		options.add(sizes);
		options.add(shot);
		options.add(ice);
		options.add(milk);

		return options;
	}

	public String numToMenu() {

		ArrayList optionByNum = getOptionText();
		String menu = "";
		// hot & ice

		if (optionByNum.get(0) == null) {

		} else if (optionByNum.get(0).equals("1")) {
			menu += "HOT";
		} else if (optionByNum.get(0).equals("2")) {
			menu += "ICE";
		} else if (optionByNum.get(0).equals("3")) {
			menu += "ICE ONLY";
		}

		// 디카페인
		if (optionByNum.get(1) == null) {

		} else if (optionByNum.get(1).equals("1")) {

		} else if (optionByNum.get(1).equals("2")) {
			menu += " / 디카페인";
		}

		// 컵
		if (optionByNum.get(2) == null) {

		} else if (optionByNum.get(2).equals("1")) {
			menu += " / 일회용 컵";
		} else if (optionByNum.get(2).equals("2")) {
			menu += " / 텀블러 사용";
		}

		// 사이즈
		if (optionByNum.get(3) == null) {

		} else if (optionByNum.get(3).equals("1")) {
			menu += " / S";
		} else if (optionByNum.get(3).equals("2")) {
			menu += " / M";
		} else if (optionByNum.get(3).equals("3")) {
			menu += " / L";
		}

		// 샷
		if (optionByNum.get(4) == null) {

		} else if (optionByNum.get(4).equals("1")) {
			menu += " / 1샷 추가";
		} else if (optionByNum.get(4).equals("2")) {
			menu += " / 2샷 추가";
		}

		// 얼음
		if (optionByNum.get(5) == null) {

		} else if (optionByNum.get(5).equals("1")) {

		} else if (optionByNum.get(5).equals("2")) {
			menu += " / 얼음 적게";
		} else if (optionByNum.get(5).equals("3")) {
			menu += " / 얼음 없음";
		}

		// 우유
		if (optionByNum.get(6) == null) {

		} else if (optionByNum.get(6).equals("1")) {

		} else if (optionByNum.get(6).equals("2")) {
			menu += " / 두유";
		} else if (optionByNum.get(6).equals("3")) {
			menu += " / 저지방 우유";
		}

		return menu;

	}

	public String optionNums() {

		if (hotAndIce == null) {
			hotAndIce = "0";
		}
		if (decaffein == null) {
			decaffein = "0";
		}
		if (cup == null) {
			cup = "0";
		}
		if (sizes == null) {
			sizes = "0";
		}

		if (shot == null) {
			shot = "0";
		}
		if (ice == null) {
			ice = "0";
		}
		if (milk == null) {
			milk = "0";
		}

		return hotAndIce + decaffein + cup + sizes + shot + milk + "";

	}

}
