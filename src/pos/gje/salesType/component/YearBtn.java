package pos.gje.salesType.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class YearBtn extends JButton implements ActionListener{
	
	public YearBtn() {
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/매출 요약 이미지/연 매출.png"));
			Image scaledImage = bufferedImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // 크기 조정
			setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/매출 요약 이미지/연 매출 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		addActionListener(this);
		setBounds(825, 290, 300, 300); // 위치 및 사이즈 조절
		setContentAreaFilled(false);
		setBorderPainted(false); 
		setOpaque(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("연 매출 클릭");
		
	}
}