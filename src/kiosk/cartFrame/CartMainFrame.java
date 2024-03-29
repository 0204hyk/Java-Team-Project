package kiosk.cartFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import database.kiosk.fromdb.GetImageInfo;
import database.kiosk.infotodb.SavePoint;
import database.kiosk.infotodb.ToSales;
import database.kiosk.infotodb.ToSalesManagement;
import database.kiosk.infotodb.UsePoint;
import kiosk.CardPutFrame;
import kiosk.Point;
import kiosk.Step1Step2;
import kiosk.menupan.ChoiceMenu;
import kiosk.menupan.MenuPanelForConfirmOrder;
import kiosk.paymentComplete.PaymentCompleteFrame;
import kiosk.tools.WithImage;

// 마지막 페이지!!!!!!

public class CartMainFrame extends JFrame {
	String root = "images/KioskImages/7. 주문정보 확인";
	WithImage wi = new WithImage(root);
	Timer timer;
	ArrayList<String> menuInfo = new ArrayList<>();
	DecimalFormat df = new DecimalFormat("#,###");
	String salesNum = getTimeNow();
	JPanel cart = new JPanel();
	ChoiceMenu f;
	// int point = 0;

	String phoneNum = "";
	int totalPoint = 0;

	CartMainFrame f2 = this;

	public static int usedPoint;

	ArrayList<String> orderInfo = new ArrayList<>();

	public CartMainFrame(ArrayList menuInfo, int totalPoint, String phoneNum, int payMethod, ChoiceMenu f) {
		this.menuInfo = menuInfo;
		this.f = f;
		this.totalPoint = totalPoint;
		this.phoneNum = phoneNum;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String now = formatter.format(LocalDateTime.now()).toString();

		orderInfo.add(salesNum);
		orderInfo.add(phoneNum + "");
		orderInfo.add(now);
		orderInfo.add(payMethod + "");
		orderInfo.add(totalPoint + "");
		orderInfo.add(new GenerateCardNum().randomCardNumber());

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
		ArrayList<String> sub = new ArrayList<>();

		for (int i = 0; i < menuInfo.size(); i++) {
			sub.addAll(menuInfo.subList(i, i + 5));
			
			cart.add(new MenuPanelForConfirmOrder(sub));
			System.out.println(sub+"cartMainFrame 출력");
			sub.removeAll(sub);
			i = i + 4;

		}
		JScrollPane scroll = new JScrollPane();
		JPanel bg = new JPanel();

		scroll.setBorder(null);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		cart.setLayout(new BoxLayout(cart, BoxLayout.Y_AXIS));
		scroll.setViewportView(bg);
		bg.add(cart);
		scroll.setBounds(52, 214, 560, 390);
		add(scroll);

		// 주문 금액
		add(wi.makeLabel("orderPrice.png", 334, 640, 91, 23));
		int orderAmount = 0;
		for (int index = 2; index < menuInfo.size(); index += 5) {

			orderAmount += Integer.parseInt(menuInfo.get(index));
		}

		JLabel orderAmountlb = new JLabel(df.format(orderAmount) + "원");
		orderAmountlb.setBounds(450, 630, 150, 45);
		orderAmountlb.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		orderAmountlb.setForeground(Color.black);
		orderAmountlb.setHorizontalAlignment(SwingConstants.RIGHT);

		// 사용 포인트
		add(wi.makeLabel("point.png", 315, 679, 112, 23));
		// 입력된 포인트 적용시키기

		// usedPoint = Point.getPoint();

		String minus = usedPoint == 0 ? "" : "- ";
		JLabel pointlb = new JLabel(minus + df.format(usedPoint));
		pointlb.setBounds(450, 667, 150, 45);
		pointlb.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		pointlb.setForeground(Color.black);
		pointlb.setHorizontalAlignment(SwingConstants.RIGHT);

		// 결제 금액
		add(wi.makeLabel("purchase.png", 299, 720, 126, 32));
		JLabel purchaseAmountlb = new JLabel(df.format(orderAmount - usedPoint) + "원");
		purchaseAmountlb.setBounds(450, 710, 150, 45);
		purchaseAmountlb.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		purchaseAmountlb.setForeground(new Color(15, 11, 65));
		purchaseAmountlb.setHorizontalAlignment(SwingConstants.RIGHT);

		// 돌아가기
		JButton cancel = wi.makeButton("cancel.png", 124, 789, 192, 67);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Step1Step2(getTotalAmounts(), menuInfo, f);
				dispose();
			}
		});

		// 결제하기
		JButton pay = wi.makeButton("pay.png", 335, 789, 192, 67);

		pay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pay.setEnabled(false);
				cancel.setEnabled(false);
				// 자동종료
				JFrame cp = new CardPutFrame();

				timer = new Timer(2000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						timer.stop();
						cp.dispose();
						f.dispose();

						// 결제가 완료되었습니다
						new PaymentCompleteFrame(f2);

						// 판매관리 데이터 입력
						new ToSalesManagement(orderInfo);

						// 판매 데이터 입력
//						new ToSales(completeInfoMenu(menuInfo));
						ArrayList<String> sub = new ArrayList<>();
						for (int i = 0; i < menuInfo.size(); ++i) {
							sub.addAll(menuInfo.subList(i, i + 5));
							new ToSales(completeInfoMenu(sub));
							sub.removeAll(sub);
							i = i + 4;
						}

						// 종료

						// 포인트 적립
						new SavePoint(totalPoint, phoneNum);

						// 포인트 차감
						new UsePoint(usedPoint, phoneNum);

						/*
						 * 결제 후 필요 한 동작
						 * 
						 * 1.멤버십적립 2.판매테이블 3.판매관리테이블
						 */

					}
				});
				timer.start();
			}
		});
		add(home);
		add(orderAmountlb);
		add(pointlb);
		add(purchaseAmountlb);
		add(pay);
		add(cancel);
	}

	// 판매 테이블 전달용
	public ArrayList<String> completeInfoMenu(ArrayList<String> menuInfo) {
		ArrayList<String> menuInfoComplete = menuInfo;

		for (int i = 0; i < menuInfo.size() - 3; i++) {
			menuInfoComplete.add(i, salesNum);
			i = i + 5;
			menuInfoComplete.add(i, "" + getMenuNum(menuInfo.get(i - 4)));
			i = i + 1;
		}

		return menuInfoComplete;
	}

	public int getMenuNum(String menu) {

		GetImageInfo gi = new GetImageInfo(menu);

		return gi.getMenuNum();
	}

	public String getTimeNow() {

		Calendar now = Calendar.getInstance();
		SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyyMMdd-01-HHmmss");

		Date date = now.getTime();

		return myDateFormat.format(date);
	}

	public String getDate() {

		Calendar now = Calendar.getInstance();
		SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

		Date date = now.getTime();

		return myDateFormat.format(date);
	}

	public int getTotalAmounts() {

		int total = 0;
		for (int i = 2; i < menuInfo.size(); i += 4) {
			total += Integer.parseInt(menuInfo.get(i));

		}

		return total / 10;
	}

	public static void main(String[] args) {

	}
}
