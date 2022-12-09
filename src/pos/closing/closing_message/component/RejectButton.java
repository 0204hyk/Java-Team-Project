package pos.closing.closing_message.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.closing.closing_message.ClosingMessageFrame;

public class RejectButton extends JButton implements ActionListener{
	ClosingMessageFrame frame;
	
	public RejectButton(ClosingMessageFrame frame) {
		this.frame = frame;
		try {
			File f = new File("PosImages/포스기 이미지 png/마감 이미지/안내창 - 아니요.png");
			BufferedImage bufferedImage = ImageIO.read(f);
			Image scaledImage = bufferedImage.getScaledInstance(150, 75, Image.SCALE_AREA_AVERAGING);
			ImageIcon btnImage = new ImageIcon(scaledImage);
			setIcon(btnImage);
			setOpaque(false);
			setContentAreaFilled(false);
			setBorderPainted(false);
			setSize(150, 75);
			setLocation(280, 140);
			setFocusable(false);
			addActionListener(this);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
	}

}
