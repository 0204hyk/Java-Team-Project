package pos.salescheck.component.saleslist;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TotalLabel extends JLabel {

	String total;
	
	
	public TotalLabel() {
	}
	public TotalLabel(String total) {
		this.total = total;
		setText(total);
		setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		setBounds(830, 560, 300, 100);
		
	}
}