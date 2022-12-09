package pos.closing.closing_message;

import java.awt.Color;
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
				
		add(new BackgroundPanel(this, ImageScaledTool.getScaledImage(
				"PosImages/포스기 이미지 png/마감 이미지/마감 확인 안내창.png", 500, 250)));
		
		setSize(500, 250);
		setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));	// 패널 배경 투명하게 하기
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}
