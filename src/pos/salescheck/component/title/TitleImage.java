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

import pos.ImageScaledTool;

public class TitleImage extends JPanel {
	Image image = ImageScaledTool.getScaledImage("images/상단 메뉴바.png", 1200, 60);
	
	// 상단 메뉴바 이미지
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(image, 0, 0, d.width, d.height, null);
	}
	
	public TitleImage() {
		setBounds(0, 0, 1200, 60);
	}
	
}
