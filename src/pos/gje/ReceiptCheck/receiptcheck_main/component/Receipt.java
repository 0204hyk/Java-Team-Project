package pos.gje.ReceiptCheck.receiptcheck_main.component;

import javax.swing.JFrame;

import pos.gje.ReceiptCheck.receiptcheck_main.ReceiptCheckFrame;

public class Receipt extends JFrame{

	public Receipt() {
		ReceiptBtn b = new ReceiptBtn(1,  new ReceiptCheckFrame());
		
		add(b.changeTextA("1","2","3"));

	}
	
public static void main(String[] args) {
	new Receipt();
}
}

