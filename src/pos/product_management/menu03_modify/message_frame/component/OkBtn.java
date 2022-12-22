package pos.product_management.menu03_modify.message_frame.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.product_management.menu01_main.ProductManagementJFrame;
import pos.product_management.menu01_main.component.MenuListJTable;
import pos.product_management.menu03_modify.ModifyFrame;
import pos.product_management.menu03_modify.message_frame.ModifyMessageFrame;

public class OkBtn extends JButton implements ActionListener{
	
	ProductManagementJFrame f1;
	ModifyFrame f2;
	ModifyMessageFrame f3;
	
	public OkBtn(ProductManagementJFrame f1, ModifyFrame f2, ModifyMessageFrame f3) {
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(120, 60, Image.SCALE_SMOOTH); // 크기 조정
			setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(120, 60, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		setBounds(140, 115, 120, 60); // 위치 및 사이즈 조절
		setContentAreaFilled(false);
		setBorderPainted(false); 
		setOpaque(false);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			f1.mj.contents.setRowCount(0);
			f1.mj = new MenuListJTable(f1.allMenu());
			f1.setEnabled(true);
			f3.dispose();
			f2.dispose();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
