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

import pos.closing.ImageScaledTool;

public class YesButton extends JButton implements ActionListener {

	public YesButton() {
		try {
			File f = new File("images/포스기 이미지 png/마감 이미지/안내창 - 네.png");
			BufferedImage bufferedImage = ImageIO.read(f);
			Image scaledImage = bufferedImage.getScaledInstance(150, 75, Image.SCALE_AREA_AVERAGING);
			ImageIcon btnImage = new ImageIcon(scaledImage);
			setIcon(btnImage);
			setOpaque(false);
			setContentAreaFilled(false);
			setBorderPainted(false);
			setSize(150, 75);
			setLocation(100, 140);
			setFocusable(false);
			addActionListener(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("네 버튼 기능 구현x");
	}
}
