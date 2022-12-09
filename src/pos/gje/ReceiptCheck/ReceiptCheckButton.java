package pos.gje.ReceiptCheck;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.gje.refund.RefundFrame;

public class ReceiptCheckButton {
	
	public ReceiptCheckButton() {

	}
	
	
	public static JButton refundBtn () {
		JButton refundBtn = new JButton();
	
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("PosImages/영수증 조회 이미지/환불 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(230, 60, Image.SCALE_SMOOTH); // 크기 조정
			refundBtn.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		refundBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("환불버튼이 눌렸습니다");
				try {
					BufferedImage bufferedImage = ImageIO.read(new File("PosImages/영수증 조회 이미지/환불 버튼 클릭.png"));
					Image scaledImage = bufferedImage.getScaledInstance(230, 60, Image.SCALE_SMOOTH); // 크기 조정
					refundBtn.setIcon(new ImageIcon(scaledImage));
				} catch (IOException e1) {
					e1.printStackTrace();
				} // 사진은 바뀌는데 다시 안돌아옴(수정필요) 
				
				// 누르는대로 창이 계속 뜸 
				new RefundFrame();
			}
		});
		
		
		refundBtn.setBounds(900, 650, 230, 60); // 위치 및 사이즈 조절
		refundBtn.setContentAreaFilled(false);
		refundBtn.setBorderPainted(false); 
		refundBtn.setOpaque(false);
		
		return refundBtn;
	}
	

	
	public static JButton outfutBtn() {
		JButton outfutBtn = new JButton();
		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("src/receiptImages/영수증 출력 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(230, 60, Image.SCALE_SMOOTH); // 크기 조정
			outfutBtn.setIcon(new ImageIcon(scaledImage));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		outfutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("출력버튼이 눌렸습니다");
				try {
					BufferedImage bufferedImage = ImageIO.read(new File("PosImages/영수증 조회 이미지/영수증 출력 버튼 클릭.png"));
					Image scaledImage = bufferedImage.getScaledInstance(230, 60, Image.SCALE_SMOOTH); // 크기 조정
					outfutBtn.setIcon(new ImageIcon(scaledImage));
				} catch (IOException e1) {
					e1.printStackTrace();
				} // 사진은 바뀌는데 다시 안돌아옴(수정필요) 
				
				// ReceiptCheckTextArea에 선택한 것 띄우기 
			}
		});
		
		outfutBtn.setBounds(650, 650, 230, 60);
		outfutBtn.setContentAreaFilled(false);
		outfutBtn.setBorderPainted(false);
		outfutBtn.setOpaque(false);
		
		return outfutBtn;
		
	}
	
	

	

}
