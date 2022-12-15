package pos.gje.ReceiptCheck.receiptcheck_main.component;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class PrintLabel extends JLabel{
	
	public PrintLabel(String text) {
		setText(text);
	}
	
	public PrintLabel() {
		setText("AAA");
		JScrollPane scrollPane = new JScrollPane
				(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		scrollPane.add(this);
		setVerticalAlignment(TOP);
		
		setOpaque(true); //Opaque값을 true로 미리 설정해 주어야 배경색이 적용된다.
		setBackground(Color.WHITE);
		setBounds(640, 95, 500, 550); 
	}


}
