package pos.gje.modify.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.gje.modify.CheckFrame;

public class OkBtn extends JButton implements ActionListener{
	CheckFrame f;
	
	public OkBtn(CheckFrame f) {
		this.f = f;
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(100, 48, Image.SCALE_SMOOTH); // 크기 조정
			setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(100, 48, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		setBounds(150, 115, 100, 48); // 위치 및 사이즈 조절
		setContentAreaFilled(false);
		setBorderPainted(false); 
		setOpaque(false);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		f.dispose();

	}
}
