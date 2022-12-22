package kiosk.cartFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import kiosk.CardPutFrame;
import kiosk.Step1Step2;
import kiosk.paymentComplete.PaymentCompleteFrame;
import kiosk.tools.WithImage;

public class CartMainFrame extends JFrame {
	String root = "images/KioskImages/7. 주문정보 확인";
	WithImage wi = new WithImage(root);
	Timer timer;
	ArrayList<String> menuInfo = new ArrayList<>();
	DecimalFormat df = new DecimalFormat("#,###");
	
	public CartMainFrame(ArrayList menuInfo) {
		
		this.menuInfo = menuInfo;

		panelSetting();
		
		setLayout(null);
		setUndecorated(true);
		setVisible(true);
		setSize(650, 950);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public void panelSetting() {
		// hy
		add(wi.makeLabel("hy.png", 52, 24, 60, 83));

		// home
		JButton home = wi.makeButton("home.png", 542, 44, 52, 52);
		home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

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

		add(home);
		scroll.setBounds(52, 214, 560, 390);
		scroll.setViewportView(panel);
		add(scroll);

		// 주문 금액
		add(wi.makeLabel("orderPrice.png", 334, 640, 91, 23));
		int orderAmount = 0;
		for (int index = 2; index < menuInfo.size(); index += 4) {

			orderAmount += Integer.parseInt(menuInfo.get(index));
		}
		JLabel orderAmountlb = new JLabel(df.format(orderAmount) + "원");
		orderAmountlb.setBounds(450, 630, 150, 45);
		orderAmountlb.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		orderAmountlb.setForeground(Color.black);
		orderAmountlb.setHorizontalAlignment(SwingConstants.RIGHT);

		// 포인트
		add(wi.makeLabel("point.png", 315, 679, 112, 23));
		int point = 1323;
		JLabel pointlb = new JLabel("-"+df.format(point));
		pointlb.setBounds(450, 666, 150, 45);
		pointlb.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		pointlb.setForeground(Color.black);
		pointlb.setHorizontalAlignment(SwingConstants.RIGHT);

		// 결제 금액
		add(wi.makeLabel("purchase.png", 299, 720, 126, 32));
		JLabel purchaseAmountlb = new JLabel(df.format(orderAmount - point)+"원");
		purchaseAmountlb.setBounds(450, 710, 150, 45);
		purchaseAmountlb.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		purchaseAmountlb.setForeground(new Color(15, 11, 16));
		purchaseAmountlb.setHorizontalAlignment(SwingConstants.RIGHT);

		// 돌아가기
		JButton cancel = wi.makeButton("cancel.png", 124, 789, 192, 67);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Step1Step2(getTotalAmounts(),menuInfo);
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

	   public int getTotalAmounts() {

		      int total = 0;
		      for (int i = 2; i < menuInfo.size(); i += 4) {
		         total += Integer.parseInt(menuInfo.get(i));

		      }

		      return total / 10;
		   }
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<>();
		a.add("아메리카노");
		a.add("1");
		a.add("5000");
		a.add("옵션 이거저거");

		a.add("카페라떼");
		a.add("3");
		a.add("1000");
		a.add("옵션 이거저거");

		a.add("카푸치노");
		a.add("4");
		a.add("3000");
		a.add("옵션 이거저거이거저거이거저거");

		new CartMainFrame(a);

	}
}
