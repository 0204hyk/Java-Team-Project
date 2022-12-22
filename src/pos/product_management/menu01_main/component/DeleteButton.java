package pos.product_management.menu01_main.component;

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

import pos.product_management.menu01_main.ProductManagementJFrame;

public class DeleteButton extends JButton implements ActionListener{
	ProductManagementJFrame mainFrame;

	public DeleteButton(ProductManagementJFrame mainFrame) {
		this.mainFrame = mainFrame;
		
		try {
			BufferedImage bufferedfixBtnImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/삭제 버튼.png"));
			Image fixBtnImage = bufferedfixBtnImage.getScaledInstance(130,65, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(fixBtnImage));
			setBounds(1027, 620, 130, 65);
			
			setBorderPainted(false);
			setContentAreaFilled(false);
			setFocusPainted(false);
			
			BufferedImage bufferedBtnClickImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/삭제 버튼 클릭.png"));
			Image btnClickImage = bufferedBtnClickImage.getScaledInstance(130,65, Image.SCALE_SMOOTH);
			Icon btnClickIcon = new ImageIcon(btnClickImage);
			setPressedIcon(btnClickIcon);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mainFrame.setEnabled(false);
		mainFrame.mj.delete();
	}

}
