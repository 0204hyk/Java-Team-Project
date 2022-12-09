package pos.salescheck.component.title;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TitleImage extends JPanel {
	
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon("sales_summary/title.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}
	
	public TitleImage() {
		
		setBounds(0, 0, 1200, 50);
	}
	
}
