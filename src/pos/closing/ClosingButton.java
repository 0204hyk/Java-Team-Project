package pos.closing;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ClosingButton extends JButton implements ActionListener{
	public ClosingButton() {
		setText("마감");
		setFont(new Font("맑은 고딕", Font.BOLD, 25));
		setBounds(850, 680, 250, 50);
		setFocusable(false);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
