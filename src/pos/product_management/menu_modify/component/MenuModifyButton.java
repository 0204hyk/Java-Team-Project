package pos.product_management.menu_modify.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.product_management.menu_modify.message_frame.ModifyMessageFrame;

public class MenuModifyButton extends JButton implements ActionListener {

	ModifyMessageFrame messageFrame;
	
	public MenuModifyButton(ModifyMessageFrame messageFrame) {
		this.messageFrame = messageFrame;
		
		try {
			BufferedImage bufferedfixBtnImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/메뉴 추가 창 확인 버튼.png"));
			Image fixBtnImage = bufferedfixBtnImage.getScaledInstance(150,75, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(fixBtnImage));
			setBounds(720, 450, 150, 75);
			
			setBorderPainted(false);
			setContentAreaFilled(false);
			setFocusPainted(false);
			
			BufferedImage bufferedBtnClickImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/메뉴 추가 창 확인 버튼 클릭.png"));
			Image btnClickImage = bufferedBtnClickImage.getScaledInstance(150,75, Image.SCALE_SMOOTH);
			Icon btnClickIcon = new ImageIcon(btnClickImage);
			setPressedIcon(btnClickIcon);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		messageFrame.setVisible(true);
	}
	
}
