package pos.gje.delet.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.gje.delet.DeleteFrame;
import pos.kjh.MenuListJTable;

public class CancelBtn extends JButton implements ActionListener{

	DeleteFrame f;
	
	public CancelBtn(DeleteFrame f) {
		this.f = f;
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 취소 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(100, 50, Image.SCALE_SMOOTH); // 크기 조정
			setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 취소 버튼 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(100, 50, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		addActionListener(this); 
		setBounds(280, 155, 100, 50); // 위치 및 사이즈 조절
		setContentAreaFilled(false);
		setBorderPainted(false); 
		setOpaque(false);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		MenuListJTable.table.setEnabled(true);
		f.dispose();
	}
}
