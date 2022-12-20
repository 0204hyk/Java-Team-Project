package kiosk.menupan;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.kiosk.GetImageInfo;
import kiosk.byoption.TotalCups;
import kiosk.tools.WithImage;

public class AMenu extends JPanel {
	String root = "images/KioskImages/3. 메뉴선택";
	WithImage wi = new WithImage(root);
	DecimalFormat df = new DecimalFormat("#,###");
	static int num = 0;
	String menu, temparature;
	GetImageInfo gi = new GetImageInfo(menu);
	JLabel cups;
	JLabel menuPricelb;
	
	public static int yy = 0;
	int x = 0, y = 0;
	// 장바구니에 한 줄씩 들어감

	public AMenu(String menu, String temparature) {
		this.menu = menu;
		this.temparature = temparature;

	}

	public AMenu() {

		// 생성할때마다 하나씩 증가
		num++;

		add(sequence());
		add(menuName());
		add(menuPrice());
		add(cups());
		add(minus());
		add(plus());
		add(delete());

		setOpaque(false);
		setBorder(null);
		setLayout(null);
		setVisible(true);
		setBounds(31, 760, 505, 41);

	}

	public JLabel sequence() {

		// 음료 순번
		return wi.makeLabel(num + ".png", x + 4, y + 5, 31, 31);
	}

	public JLabel menuName() {

		// 음료 이름
		String menuName = "";
		if (temparature == null) {
			menuName = menu + " (ICE ONLY) ";
		} else {
			menuName = menu + " (" + temparature.toUpperCase() + ") ";
		}

		JLabel menuNamelb = new JLabel(menuName);
		menuNamelb.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		menuNamelb.setBounds(70, 771, 200, 32);

		return menuNamelb;
	}

	public JLabel menuPrice() {
		// 가격
		String price = df.format(gi.getMenuPrice() * TotalCups.cup) + "원";
		menuPricelb = new JLabel(price);
		menuPricelb.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		menuPricelb.setBounds(x + 41, y + 5, 70, 32);

		return menuPricelb;
	}

	public JLabel cups() {
		// 잔 수
		cups = new JLabel(TotalCups.cup + "잔");
		cups.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		cups.setBounds(379, 10, 35, 22);
		cups.setHorizontalAlignment(JLabel.CENTER);

		return cups;
	}

	public JButton minus() {
		// 마이너스
		JButton minus = wi.makeButton("minus.png", x + 344, y + 11, 18, 18);
		minus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (TotalCups.cup > 1) {
					TotalCups.cup = TotalCups.cup - 1;
				} else if (TotalCups.cup < 1) {
					TotalCups.cup = 1;
				}
				cups.setText(TotalCups.cup + "잔");
				menuPricelb.setText(df.format(gi.getMenuPrice() * TotalCups.cup) + "원");
			}
		});

		return minus;
	}

	public JButton plus() {
		JButton plus = wi.makeButton("plus.png", x + 419, y + 11, 18, 18);
		plus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (TotalCups.cup > 0) {
					TotalCups.cup = TotalCups.cup + 1;
				} else if (TotalCups.cup > 98) {
					TotalCups.cup = 99;
				}
				cups.setText(TotalCups.cup + "잔");
				menuPricelb.setText(df.format(gi.getMenuPrice() * TotalCups.cup) + "원");

			}
		});

		return plus;
	}

	public JButton delete() {

		// 삭제 버튼
		JButton delete = wi.makeButton("delete.png", x + 457, y + 5, 31, 31);

		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (num != 1) {
					num = num - 1;
				}
			}
		});
		return delete;
	}

}
