package pos.gje.calcView.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PartiallyDeleteButton extends JButton implements ActionListener{

	public PartiallyDeleteButton() {
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/계산 파트 이미지/주문 메뉴 창 선택 삭제 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(255, 56, Image.SCALE_SMOOTH); // 크기 조정
			setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/계산 파트 이미지/주문 메뉴 창 선택 삭제 버튼 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(255, 56, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		addActionListener(this);
		setBounds(30, 475, 255, 56); // 위치 및 사이즈 조절
		setContentAreaFilled(false);
		setBorderPainted(false); 
		setOpaque(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
