package pos.gje.salesType;

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

public class SalesTypeBtn {
	
	public static JButton day() {
		// 두번째 창 확인 버튼 
		JButton completionBtn = new JButton();
			
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/매출 요약 이미지/일 매출.png"));
			Image scaledImage = bufferedImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // 크기 조정
			completionBtn.setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/매출 요약 이미지/일 매출 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			completionBtn.setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		completionBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
			}
		});

		completionBtn.setBounds(75, 290, 300, 300); // 위치 및 사이즈 조절
		completionBtn.setContentAreaFilled(false);
		completionBtn.setBorderPainted(false); 
		completionBtn.setOpaque(false);
		
		return completionBtn;
	}
	
	
	public static JButton month() {
		JButton completionBtn = new JButton();
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/매출 요약 이미지/월 매출.png"));
			Image scaledImage = bufferedImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // 크기 조정
			completionBtn.setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/매출 요약 이미지/월 매출 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			completionBtn.setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		completionBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
			}
		});

		completionBtn.setBounds(450, 290, 300, 300); // 위치 및 사이즈 조절
		completionBtn.setContentAreaFilled(false);
		completionBtn.setBorderPainted(false); 
		completionBtn.setOpaque(false);
		
		return completionBtn;
	}
	
	
	public static JButton year() {
		
		JButton completionBtn = new JButton();
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/매출 요약 이미지/연 매출.png"));
			Image scaledImage = bufferedImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // 크기 조정
			completionBtn.setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/매출 요약 이미지/연 매출 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(300, 300, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			completionBtn.setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		completionBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
			}
		});

		completionBtn.setBounds(825, 290, 300, 300); // 위치 및 사이즈 조절
		completionBtn.setContentAreaFilled(false);
		completionBtn.setBorderPainted(false); 
		completionBtn.setOpaque(false);
		
		return completionBtn;
	}
	

}
