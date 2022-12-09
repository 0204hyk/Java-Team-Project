package pos.closing;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ClosingButton extends JButton implements ActionListener{
	public ClosingButton() {
		try {
			File image = new File("images/포스기 이미지 png/마감 이미지/마감 버튼.png");
			BufferedImage bufferedImage = ImageIO.read(image);
			Image scaledImage = bufferedImage.getScaledInstance(300, 80, Image.SCALE_DEFAULT);
			ImageIcon btnImage = new ImageIcon(scaledImage);
			setIcon(btnImage);
			setBounds(850, 680, 250, 50);
//			setBorderPainted(false);
			setFocusable(false);
			addActionListener(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
