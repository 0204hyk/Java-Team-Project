package pos.kjh;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TeamInfoPanel extends JPanel{


	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("images/PosImages/시작 페이지 버튼 이미지/프로젝트 구성원 창3.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	

	public TeamInfoPanel() {
		setBounds(0, 0, 500, 450);
		setLayout(null); 
	}	     

}
