package pos.calculation.etcbutton;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.ImageScaledTool;
import pos.calculation.popup.ExistFrame;

public class PaymentButton extends JButton {

	ImageScaledTool tool = new ImageScaledTool();
	
	public PaymentButton() {
		
		// 결제 버튼 이미지 
		setIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/계산 파트 이미지/결제 버튼.png", 120, 60)));
		
		// 결제 버튼 눌렀을 때
		setPressedIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/계산 파트 이미지/결제 버튼 클릭.png", 120, 60)));

		setBounds(1050, 700, 100, 50);
		setBorder(null);
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ExistFrame();
				
			}
		});
		
	}
}
