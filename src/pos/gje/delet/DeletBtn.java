package pos.gje.delet;

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

import pos.gje.modify.ModifyFrame;

public class DeletBtn {

	// 두번째 창 확인 버튼 
	public static JButton Completion (JFrame f) {
		JButton completionBtn = new JButton();
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(100, 50, Image.SCALE_SMOOTH); // 크기 조정
			completionBtn.setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(100, 50, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			completionBtn.setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		completionBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		completionBtn.setBounds(150, 120, 100, 50); // 위치 및 사이즈 조절
		completionBtn.setContentAreaFilled(false);
		completionBtn.setBorderPainted(false); 
		completionBtn.setOpaque(false);
		
		return completionBtn;
	}
	
	// 첫번째창 취소 버튼
	public static JButton cancel (JFrame f) {
		JButton cancelBtn = new JButton();
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 취소 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(100, 50, Image.SCALE_SMOOTH); // 크기 조정
			cancelBtn.setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 취소 버튼 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(100, 50, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			cancelBtn.setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				
			}
		});

		cancelBtn.setBounds(300, 175, 100, 50); // 위치 및 사이즈 조절
		cancelBtn.setContentAreaFilled(false);
		cancelBtn.setBorderPainted(false); 
		cancelBtn.setOpaque(false);
		
		return cancelBtn;
		
		
	}
	
	// 첫번째 창 확인 버튼 
	public static JButton ok() {
		
		JButton okBtn = new JButton();
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(100, 50, Image.SCALE_SMOOTH); // 크기 조정
			okBtn.setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(100, 50, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			okBtn.setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeletFrame().okFrame();
				
			}
		});

		okBtn.setBounds(100, 175, 100, 50); // 위치 및 사이즈 조절
		okBtn.setContentAreaFilled(false);
		okBtn.setBorderPainted(false); 
		okBtn.setOpaque(false);
		
		return okBtn;
	}
}
