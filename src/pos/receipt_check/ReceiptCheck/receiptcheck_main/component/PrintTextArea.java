package pos.receipt_check.ReceiptCheck.receiptcheck_main.component;

import java.awt.Font;

import javax.swing.JTextArea;

public class PrintTextArea extends JTextArea{

	public PrintTextArea() {

		setFont(new Font("굴림체", Font.PLAIN, 15));
		setEditable(false);

	}
}
