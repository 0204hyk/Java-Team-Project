package pos.calculation.etcbutton;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.ImageScaledTool;
import pos.calculation.popup.ExistFrame;

public class CalcEscapeButton extends JButton {
	
	ImageScaledTool tool = new ImageScaledTool();
	
	public CalcEscapeButton() {
		
		// < 버튼 이미지
		setIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/계산 파트 이미지/돌아가기 버튼.png", 120, 60)));
		
		// < 버튼 이미지 눌렀을 때
		setPressedIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/계산 파트 이미지/돌아가기 버튼 클릭.png", 120, 60)));
		
		
		setBorder(null);
		setBounds(80, 700, 100, 50);
	
		
		
	}
}
