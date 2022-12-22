package pos.gje.ReceiptCheck.refund;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import pos.WithImage;
import pos.gje.ReceiptCheck.receiptcheck_main.List;

public class RefundFrame extends JFrame {

	static String root = "images/PosImages/영수증 조회 이미지/";
	static WithImage wi = new WithImage(root);
	
	Timer timer;
	
	public static int amount = 10000;
	public static int card = 23000;
	public static int point = 0;
	public static String cardNum = "1234-****-1234-****";
	public static HashSet<String> refundNum = new HashSet<>();
	
	List list;
	JLabel cardLb = new JLabel();
	JLabel pointLb = new JLabel();
	JLabel amountLb = new JLabel();
	JLabel cardNumLb = new JLabel();
	JButton refund = new JButton();
	
	public RefundFrame(JButton refund) {
		this.refund = refund;
	}
	
	
	//총 가격, 포인트 결제, 카드 결제, 받은 금액
	public RefundFrame (int amount, int point, int card, String cardNum, String sales_number){
		this.amount = amount;
		this.card = card;
		this.point = point;
		this.cardNum = cardNum;
		
		//System.out.println(amount + card + point + cardNum);
		
		JButton exit = wi.makeButton("환불 창 닫기 버튼", 725, 20, 43, 46);
		JButton checkBox = wi.makeButton("체크박스", 215, 394, 27, 27);
		JLabel check = wi.makeLabel("체크", 222, 388, 24, 24);
		JButton confirm = wi.makeButton("확인", 493, 371, 85, 74);
		confirm.setLayout(null);
		confirm.setHorizontalTextPosition(JButton.CENTER);
		confirm.setVerticalTextPosition(JButton.BOTTOM);
		confirm.setOpaque(true);
		
		check.setVisible(false);
		
		
		checkBox.addActionListener(new ActionListener() {
			int num = 1;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (num == 0) {
					num = 1;
					check.setVisible(false);
				} else if (num == 1) {
					num = 0;
					check.setVisible(true);
				}
			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();//나중에 dispose로 바꿔주기
				
			}
		});
		
		confirm.addActionListener(new ActionListener() {
			JLabel lb = wi.makeLabel("카드를 꽂아주세요", 0, 0, 401, 255); // 사진 불러
			
			// 정보 확인 후 꺼져야됨
			@Override
			public void actionPerformed(ActionEvent e) {
				refundNum.add(sales_number);
				if (refundNum.contains(sales_number)) {
					refund.setEnabled(false);
				}
				
				System.out.println(sales_number + "의 환불버튼이 눌렸습니다");
				//new List(refundNum);
			
				
				dispose();
			}
		});
		
		// setText 
		amountLb.setText(amount + "");
		cardLb.setText(card + "");
		pointLb.setText(point + "");
		cardNumLb.setText(cardNum);
		
		// 오른쪽 정렬
		amountLb.setHorizontalAlignment(JLabel.RIGHT);
		cardLb.setHorizontalAlignment(JLabel.RIGHT);
		pointLb.setHorizontalAlignment(JLabel.RIGHT);
		cardNumLb.setHorizontalAlignment(JLabel.RIGHT);
		
		// 붙이기
		add(amountLb);
		add(cardLb);
		add(pointLb);
		add(cardNumLb);	
		
		amountLb.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		cardLb.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		pointLb.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		cardNumLb.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		//add
		amountLb.setBounds(362, 126, 200, 50);
		cardLb.setBounds(362, 192, 200, 50);
		pointLb.setBounds(362, 229, 200, 50);
		cardNumLb.setBounds(362, 266, 200, 50);
		
		add(exit);
		add(wi.makeLabel("상단바", 0, 0, 800, 550));
		add(wi.makeLabel("목록", 218, 143, 88, 157));
		add(wi.makeLabel("선", 218, 184, 363, 1));
		add(wi.makeLabel("영수증 출력 여부", 254, 402, 109, 14));
		add(check);
		add(checkBox);
		add(confirm);
		
		getContentPane().setBackground(Color.WHITE); // 배경색
		setSize(800, 550); // 프레임 사이즈
		setUndecorated(true); // 타이틀바 없애기
		setLayout(null);
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		setVisible(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public RefundFrame() {
		this(10000, 0, 0, "default", "");
		
	}
	
	public static void DBsave() {
		
		
	}

}
