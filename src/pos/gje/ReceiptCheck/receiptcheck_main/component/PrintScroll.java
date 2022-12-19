package pos.gje.ReceiptCheck.receiptcheck_main.component;

import java.awt.Font;

import javax.swing.JScrollPane;

public class PrintScroll extends JScrollPane{
	public static PrintTextArea p = new PrintTextArea();
	
	public PrintScroll() {
		setViewportView(p);// TextArea를 붙여줌
		setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
		setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		setBounds(640, 95, 500, 550); //틀
	}

}
