package pos.gje.ReceiptCheck.refund.component;

import java.awt.Color;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import pos.gje.ReceiptCheck.receiptcheck_main.component.PrintScroll;

public class RefundReiceiptFrame extends JFrame{
	
	
	public RefundReiceiptFrame(String sales_number, String menu, int price, int point, int card) {
		long time = System.currentTimeMillis(); 

		Calendar cal = Calendar.getInstance(); // getInstance()로 객체 생성

		String date = cal.get(Calendar.YEAR) + "-" +
		        (cal.get(Calendar.MONTH) + 1) + "-" +
		        cal.get(Calendar.DATE) + " " +
		        cal.get(Calendar.HOUR_OF_DAY) + ":" +
		        cal.get(Calendar.MINUTE) + ":" +
		        cal.get(Calendar.SECOND);

		JTextArea print = new JTextArea();
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(print);
		
		
		print.setText("[환불 영수증]\n"
				+ "\n"
				+ "[매장명] 구리점\n"
				+ "[사업자] 123-12-12345\n"
				+ "[주소] 경기도 구리시 건원대로 44 태영빌딩\n"
				+ "4층 409호\n"
				+ "[대표자] 김XX		[TEL] 031-555-4449\n"
				+ "[환불일] " + date + "\n"
				+ "[환불 영수증] " + sales_number + "\n"
				+ "========================================\n"
				+ " 상 품 명\t\t수 량\t단 가\n"
				+ "--------------------------------------------------------------------\n"
				+ menu
				+ "--------------------------------------------------------------------\n"
				+ "\t\t합 계 금 액	"  + price + "\n"
				+ "--------------------------------------------------------------------\n"
				+ "\t\t받 을 금 액	"  + price + "\n"
				+ "\t\t포인트 결제	"  + point + "\n"
				+ "\t\t카 드 결 제	"  +  card + "\n"
				+ "\t\t받 은 금 액	"  + price + "\n"
				+ "========================================="
				);
		
		
		print.setEditable(false);
		scroll.setSize(500, 550);
		
		add(scroll);
		getContentPane().setBackground(Color.WHITE); // 배경색
		setSize(300, 550); // 프레임 사이즈
		setUndecorated(true); // 타이틀바 없애기
		setLayout(null);
		setResizable(false); // 크기 조절 안되게
		setLocationRelativeTo(null); // 가운데에 뜨게
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public RefundReiceiptFrame() {
		
	
	}
	

	
	public void changeTextA(String date, String sales_number, String menu, int price, int point, int card) {
		JTextArea a = PrintScroll.p;
		
		a.setText("[영수증]\n"
				+ "\n"
				+ "[매장명] 구리점\n"
				+ "[사업자] 123-12-12345\n"
				+ "[주소] 경기도 구리시 건원대로 44 태영빌딩\n"
				+ "4층 409호\n"
				+ "[대표자] 김XX		[TEL] 031-555-4449\n"
				+ "[매출일] " + date + "\n"
				+ "[영수증] " + sales_number + "\n"
				+ "=====================================\n"
				+ " 상 품 명\t\t수 량\t단 가\n"
				+ "--------------------------------------------------------------------\n"
				+ menu
				+ "--------------------------------------------------------------------\n"
				+ "\t\t합 계 금 액	"  + price + "\n"
				+ "--------------------------------------------------------------------\n"
				+ "\t\t받 을 금 액	"  + price + "\n"
				+ "\t\t포인트 결제	"  + point + "\n"
				+ "\t\t카 드 결 제	"  +  card + "\n"
				+ "\t\t받 은 금 액	"  + price + "\n"
				+ "====================================="
				);
	}

	public static void main(String[] args) {
	
	}
}
