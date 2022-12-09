package pos.salescheck.component.month;

import java.awt.Font;

import javax.swing.JLabel;

public class ListLabel extends JLabel {

	JLabel account = new JLabel();
	public ListLabel() {
		
		account.setText("1,000,000원");
		account.setBounds(800, 100, 500, 500);
		add(account);
		setText("1월");
		setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		setBounds(650, 100, 500, 500);
		
	}
}
