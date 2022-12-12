package pos.gje.refund;

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

public class RefundButton{
	
	public static JButton inputBtn () {
		
		JButton inputBtn = new JButton();
	
		try {

			BufferedImage bufferedImage = ImageIO.read(new File("PosImages/영수증 조회 이미지/카드번호 & 현금 영수증 란 입력 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(78, 48, Image.SCALE_SMOOTH); // 크기 조정
			inputBtn.setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("PosImages/영수증 조회 이미지/카드번호 및 현금 영수증용 입력 버튼 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(78, 48, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			
			inputBtn.setPressedIcon(img);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	
		
		inputBtn.setBounds(296, 370, 78, 48);
		inputBtn.setContentAreaFilled(false);
		inputBtn.setBorderPainted(false);
		inputBtn.setOpaque(false);
		
		return inputBtn;
	}
	
	
	// 
	public static JButton checkBtn() {
		JButton checkBtn = new JButton();
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("PosImages/영수증 조회 이미지/영수증 출력 여부 체크.png"));
			Image scaledImage = bufferedImage.getScaledInstance(56, 48, Image.SCALE_SMOOTH); // 크기 조정
			checkBtn.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e1) {
			e1.printStackTrace();
		}


		checkBtn.addActionListener(new ActionListener() {
			int num = 1;
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					++num;
					System.out.println(num);
					if (num % 2 == 0) {	
						System.out.println("영수증을 출력합니다.");
						BufferedImage bufferedImage = ImageIO.read(new File("PosImages/영수증 조회 이미지/영수증 출력 여부 체크 완.png"));
						Image scaledImage = bufferedImage.getScaledInstance(56, 63, Image.SCALE_SMOOTH); // 크기 조정
						checkBtn.setIcon(new ImageIcon(scaledImage));
						checkBtn.setLocation(25, 427);
					} else {
						BufferedImage bufferedImage = ImageIO.read(new File("PosImages/영수증 조회 이미지/영수증 출력 여부 체크.png"));
						Image scaledImage = bufferedImage.getScaledInstance(56, 48, Image.SCALE_SMOOTH); // 크기 조정
						checkBtn.setIcon(new ImageIcon(scaledImage));
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				} // 사진은 바뀌는데 다시 안돌아옴(수정필요) 
				
			}
		});
		
		checkBtn.setBounds(25, 430, 56, 48);
		checkBtn.setContentAreaFilled(false);
		checkBtn.setBorderPainted(false);
		checkBtn.setOpaque(false);
		
		return checkBtn; 
	}
	
	
	// 숫자 키패드
	public static JButton numberPad(int num) {
		JButton numBtn = new JButton();
		int x = 300, y = 80;
		
		String root = "PosImages/영수증 조회 이미지/새 폴더/";
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File(root + num + ".png"));
			Image scaledImage = bufferedImage.getScaledInstance(90, 95, Image.SCALE_SMOOTH); // 크기 조정
			numBtn.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		if (num >= 5 && num <= 8) {
			x = 300;
			y += 100;
			num -= 4;
		} else if (num > 8 && num < 13) {
			x = 300;
			y += 100 * 2;
			num -= 8;
		} else if (num > 12) {
			x = 300;
			y += 100 * 3;
			num -= 12;
		}
		
		x += num * 95;
		
		numBtn.setBounds(x, y, 90, 95);
		numBtn.setContentAreaFilled(false);
		numBtn.setBorderPainted(false);
		numBtn.setOpaque(false);
		
		return numBtn;
	
	}
	
	// 닫기 버튼
	public static JButton closeBtn(JFrame f) {
		
		JButton closeBtn = new JButton();
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("PosImages/영수증 조회 이미지/새 폴더/환불 창 닫기 버튼.jpg"));
			Image scaledImage = bufferedImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH); // 크기 조정
			closeBtn.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		closeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();

			}
		});
		
		closeBtn.setBounds(700, 10, 78, 48);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setBorderPainted(false);
		closeBtn.setOpaque(false);
		
		return closeBtn;
		
	}
	
}

