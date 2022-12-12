package pos.gje.ReceiptCheck.receiptcheck_main.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import pos.ImageScaledTool;

public class ReceiptListPanel extends JPanel{
	Image image = ImageScaledTool.getScaledImage(
			"images/PosImages/영수증 조회 이미지/날짜별 영수증 리스트 기본 틀.png", 500, 550);

	// 패널 배경 넣기
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(image, 0, 0, d.width, d.height, null);
	}	
	
	public ReceiptListPanel() {
		setBounds(75, 80, 500, 550); // Panel 틀
	}	       
	

	

}
