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
		setLayout(null);	
	}
}
