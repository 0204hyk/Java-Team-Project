package pos.closing.closing_message;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.ImageScaledTool;
import pos.closing.closing_main.ClosingFrame;

public class ClosingAcceptButton extends JButton implements ActionListener {
	
	public ClosingAcceptButton() {
		try {
			File f = new File("images/PosImages/마감 이미지/안내창 - 네.png");
			BufferedImage bufferedImage = ImageIO.read(f);
			Image scaledImage = bufferedImage.getScaledInstance(150, 75, Image.SCALE_AREA_AVERAGING);
			ImageIcon btnImage = new ImageIcon(scaledImage);
			setIcon(btnImage);
			setOpaque(false);
			setContentAreaFilled(false);
			setBorderPainted(false);
			setSize(150, 75);
			setFocusable(false);
			
			File f2 = new File("images/PosImages/마감 이미지/안내창 - 네 클릭.png");
			BufferedImage bufferedImage2 = ImageIO.read(f2);
			Image scaledImage2 = bufferedImage2.getScaledInstance(150, 75, Image.SCALE_AREA_AVERAGING);
			ImageIcon btnImage2 = new ImageIcon(scaledImage2);
			setPressedIcon(btnImage2);
			
			addActionListener(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("네 버튼 구현X");
	}
}
