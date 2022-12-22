package kiosk.cartFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import kiosk.HomeButton;
import kiosk.cardPut.CardPutFrame;
import kiosk.menupan.ChoiceMenu;
import kiosk.menupan.Options;
import kiosk.paymentComplete.PaymentCompleteFrame;
import kiosk.tools.WithImage;

public class CartMainFrame extends JFrame {
	String root = "images/KioskImages/7. 주문정보 확인";
	WithImage wi = new WithImage(root);
	Timer timer;
	ArrayList<String> menuInfo = new ArrayList<>();

	public CartMainFrame(ArrayList menuInfo) {
		this.menuInfo = menuInfo;

		panelSetting();
		setDisplay();
	}

	public void panelSetting() {
		// hy
		add(wi.makeLabel("hy.png", 52, 24, 60, 83));

		// home
		add(new HomeButton());

		// 주문정보를 확인해주세요
		add(wi.makeLabel("pleaseConfirm.png", 58, 163, 358, 34));

		// 배경 (스크롤)
		JPanel panel = new JPanel();
		JScrollPane scroll = new JScrollPane();

		int i;
		int x = 133, y = 245;
		int series = 1;
		for (i = 0; i < menuInfo.size(); i++) {

			JLabel menu = new JLabel(
					menuInfo.get(i) + " / " + menuInfo.get(i + 1) + "잔 / " + menuInfo.get(i + 2) + "원");
			menu.setFont(new Font("맑은 고딕", Font.BOLD, 22));
			menu.setForeground(Color.BLACK);
			menu.setBounds(x, y, 400, 25);

			JLabel num = new JLabel("" + series);
			num.setBounds(x - 47, y + 4, 31, 31);
			num.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			num.setForeground(Color.WHITE);
			num.setHorizontalAlignment(SwingConstants.CENTER);
			num.setVerticalAlignment(SwingConstants.CENTER);

			JLabel numBg = wi.makeLabel("bg.png", x - 47, y + 4, 31, 31);
			y += 28;

			JLabel option = new JLabel("└ " + menuInfo.get(i + 3));
			option.setBounds(x, y, 400, 15);
			option.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			option.setForeground(new Color(181, 185, 183));

			y += 34;

			i = i + 3;

			series++;

			add(num);
			add(numBg);
			add(menu);
			add(option);
		}

		scroll.setBounds(52, 214, 560, 390);
		scroll.setViewportView(panel);
		add(scroll);

		// 주문 금액
		add(wi.makeLabel("orderPrice.png", 334, 644, 91, 23));
		int orderAmount = 0;
		for (int index = 2; index < menuInfo.size(); index += 4) {

			orderAmount += Integer.parseInt(menuInfo.get(index));
		}
		JLabel orderAmountlb = new JLabel(orderAmount + "");
		orderAmountlb.setBounds(450, 634, 150, 45);
		orderAmountlb.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		orderAmountlb.setForeground(Color.black);
		orderAmountlb.setHorizontalAlignment(SwingConstants.RIGHT);

		// 포인트
		add(wi.makeLabel("point.png", 315, 679, 112, 23));
		int point = 0;
		JLabel pointlb = new JLabel();
		pointlb.setBounds(450, 666, 150, 45);
		pointlb.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		pointlb.setForeground(Color.black);
		pointlb.setHorizontalAlignment(SwingConstants.RIGHT);

		// 결제 금액
		add(wi.makeLabel("purchase.png", 299, 716, 126, 32));
		JLabel purchaseAmountlb = new JLabel((orderAmount - point) + "");
		purchaseAmountlb.setBounds(450, 696, 150, 45);
		purchaseAmountlb.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		purchaseAmountlb.setForeground(new Color(63, 185, 144));
		purchaseAmountlb.setHorizontalAlignment(SwingConstants.RIGHT);

		// 돌아가기
		JButton cancel = wi.makeButton("cancel.png", 124, 789, 192, 67);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// 결제하기
		JButton pay = wi.makeButton("pay.png", 335, 789, 192, 67);

		pay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 자동종료
				JFrame cp = new CardPutFrame();
				timer = new Timer(3000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						cp.dispose();
						new PaymentCompleteFrame();
						timer.stop();
						// 적립 업데이트 해주기
					}
				});
				timer.start();
			}
		});

		add(orderAmountlb);
		add(pointlb);
		add(purchaseAmountlb);
		add(pay);
		add(cancel);
	}

	public void setDisplay() {

		setLayout(null);
		setUndecorated(true);
		setVisible(true);
		setSize(650, 950);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		Options.choiceMenu = new ChoiceMenu();
	}
}
