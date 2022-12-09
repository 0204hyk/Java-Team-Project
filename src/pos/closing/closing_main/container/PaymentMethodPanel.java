package pos.closing.closing_main.container;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class PaymentMethodPanel extends JPanel{
	private Image background;
	
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(background, 0, 0, d.width, d.height, null);
	}	
	
	public PaymentMethodPanel(Image background) {
		this.background = background;

		setSize(new Dimension(background.getWidth(null), background.getHeight(null)));
		setSize(400, 100);
		setLocation(120, 80);
		setLayout(null);

		
//		setLayout(new GridLayout(2, 2));
//		
//		LineBorder labelLine = new LineBorder(new Color(127, 127, 127));
//		
//		JLabel label1 = new JLabel("카드 결제", JLabel.CENTER);
//		label1.setBorder(labelLine);
//		label1.setOpaque(true);
//		label1.setBackground(new Color(217, 217, 217));
//		label1.setFont(new Font("맑은 고딕", Font.BOLD, 16));
//		
//		JLabel label2 = new JLabel("원  ", JLabel.RIGHT);
//		label2.setBorder(labelLine);
//		label2.setOpaque(true);
//		label2.setBackground(Color.white);
//		label2.setFont(new Font("맑은 고딕", Font.BOLD, 16));
//		
//		JLabel label3 = new JLabel("현금 결제", JLabel.CENTER);
//		label3.setBorder(labelLine);
//		label3.setOpaque(true);
//		label3.setBackground(new Color(217, 217, 217));
//		label3.setFont(new Font("맑은 고딕", Font.BOLD, 16));
//		
//		JLabel label4 = new JLabel("원  ", JLabel.RIGHT);
//		label4.setBorder(labelLine);
//		label4.setOpaque(true);
//		label4.setBackground(Color.white);
//		label4.setFont(new Font("맑은 고딕", Font.BOLD, 16));
//				
//		add(label1);
//		add(label2);
//		add(label3);
//		add(label4);
	}
}
