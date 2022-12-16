package pos.gje.ReceiptCheck.receiptcheck_main.component;

import java.awt.Font;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PrintTextArea extends JTextArea{

	public PrintTextArea() {
		//JScrollPane scrollPane = new JScrollPane(this);
		setText("hello");
		//contentPane.add(scrollPane);
		setFont(new Font("맑은 고딕", Font.PLAIN, 20));	
		setBounds(640, 95, 500, 550); // Panel 틀
		setLayout(null);
	}
}
