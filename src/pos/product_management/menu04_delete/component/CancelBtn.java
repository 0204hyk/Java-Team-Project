package pos.product_management.menu04_delete.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.product_management.menu01_main.ProductManagementJFrame;
import pos.product_management.menu01_main.component.MenuListJTable;
import pos.product_management.menu04_delete.DeleteFrame;

public class CancelBtn extends JButton implements ActionListener{

	DeleteFrame f;
	
	public CancelBtn(DeleteFrame f) {
		this.f = f;
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 취소 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(120, 60, Image.SCALE_SMOOTH); // 크기 조정
			setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 취소 버튼 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(120, 60, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		addActionListener(this); 
		setBounds(270, 160, 120, 60); // 위치 및 사이즈 조절
		setContentAreaFilled(false);
		setBorderPainted(false); 
		setOpaque(false);
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		ProductManagementJFrame.deleteBtn.setEnabled(true);
//		MenuListJTable.table.setEnabled(true);
		f.dispose();
	}
}
