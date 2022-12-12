package pos.gje.ReceiptCheck.receiptcheck_main.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ReceiptListPanel extends JPanel{

	// 패널 배경 넣기
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("images/PosImages/영수증 조회 이미지/날짜별 영수증 리스트 기본 틀.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	
	
	public ReceiptListPanel() {
		setBounds(75, 80, 500, 550); // Panel 틀
	}	       
	

	

}
