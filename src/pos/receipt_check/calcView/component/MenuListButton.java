package pos.receipt_check.calcView.component;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MenuListButton extends JButton implements ActionListener{

	
	public MenuListButton() {
		setText("아메리카노");
		setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		
		addActionListener(this);
		setHorizontalAlignment(SwingConstants.LEFT); // 텍스트 왼쪽으로 
		setBounds(5, 40, 330, 56); // 위치 및 사이즈 조절
		setContentAreaFilled(false);
		setBorderPainted(false); 
		setOpaque(false);
		setFocusable(false);
	}
	
	
	int num = 0;
	@Override
	public void actionPerformed(ActionEvent e) {
	num++;
	
	if (num % 2 != 0) {
		setFont(new Font("맑은 고딕", Font.BOLD, 18));
	} else {
		setFont(new Font("맑은 고딕", Font.PLAIN, 18));
	}
		
	}
}
