package pos.gje.ReceiptCheck.receiptcheck_main.component;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ReceiptCheckTextArea extends JTextArea{

	
	public ReceiptCheckTextArea() {
		JScrollPane scrollPane = new JScrollPane();
		
		setBounds(650, 80, 475, 550);
		setLineWrap(true);
		setEditable(false);

	}

}
