package pos.closing.closing_message;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import pos.closing.ImageScaledTool;
import pos.closing.closing_message.container.BackgroundPanel;

public class ClosingMessageFrame extends JFrame {
	
	public ClosingMessageFrame() {

		add(new BackgroundPanel(ImageScaledTool.getScaledImage(
				"PosImages/포스기 이미지 png/마감 이미지/마감 확인 안내창.png", 508, 258)));
		
		setSize(500, 250);
		setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}
