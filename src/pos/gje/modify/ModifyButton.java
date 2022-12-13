package pos.gje.modify;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ModifyButton {

	// 수정 버튼 
	public static JButton modifyBtn () {
		JButton modifyBtn = new JButton();
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/메뉴 수정 확인 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(130, 63, Image.SCALE_SMOOTH); // 크기 조정
			modifyBtn.setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/상품 관리 이미지/메뉴 수정 확인 버튼 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(130, 63, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			modifyBtn.setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		modifyBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CheckFrame();
				
			}
		});

		modifyBtn.setBounds(660, 400, 130, 63); // 위치 및 사이즈 조절
		modifyBtn.setContentAreaFilled(false);
		modifyBtn.setBorderPainted(false); 
		modifyBtn.setOpaque(false);
		
		return modifyBtn;
	
	} 
	
	// 확인 버튼
	public static JButton okBtn(CheckFrame f) {
		JButton okBtn = new JButton();
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(100, 48, Image.SCALE_SMOOTH); // 크기 조정
			okBtn.setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(100, 48, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			okBtn.setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});

		okBtn.setBounds(150, 130, 100, 48); // 위치 및 사이즈 조절
		okBtn.setContentAreaFilled(false);
		okBtn.setBorderPainted(false); 
		okBtn.setOpaque(false);
		
		return okBtn;
	}

}
