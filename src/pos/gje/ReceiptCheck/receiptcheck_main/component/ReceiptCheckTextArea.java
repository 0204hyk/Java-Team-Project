package pos.gje.ReceiptCheck.receiptcheck_main.component;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ReceiptCheckTextArea extends JTextArea{

	
	public ReceiptCheckTextArea() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.add(this);
		append("[영수증]\n"
				+ "\n"
				+ "[매장명] 구리점\n"
				+ "[사업자] 123-12-12345\n"
				+ "[주소] 경기도 구리시 건원대로 44 태영빌딩 \n"
				+ "4층 409호\n"
				+ "[대표자] 김하영\t\t[TEL] 031-555-4449\n");
		append("[매출일] " + "날짜\n"
				+ "[영수증] " + "번호\n"
				+ "=================================");
		setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		setBounds(650, 95, 475, 550);
		setLineWrap(true);
		setEditable(false);

	}

}
