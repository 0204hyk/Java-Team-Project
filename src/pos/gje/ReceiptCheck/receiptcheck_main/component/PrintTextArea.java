package pos.gje.ReceiptCheck.receiptcheck_main.component;

import java.awt.Font;

import javax.swing.JTextArea;

public class PrintTextArea extends JTextArea{

	public PrintTextArea() {

		setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		setEditable(false);

	}
}
