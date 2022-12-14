package pos.calculation.etcbutton;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.ImageScaledTool;

public class RightButton extends JButton {

	ImageScaledTool tool = new ImageScaledTool();
	
	public RightButton() {
		
		// > 버튼 이미지 기본 아이콘
		setIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/계산 파트 이미지/메뉴 창 앞으로가기 버튼.png", 60, 60)));

		// > 버튼 이미지 눌렀을 때
		setPressedIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/계산 파트 이미지/메뉴 창 앞으로가기 버튼 클릭.png", 60, 60)));
		
		setBounds(1100, 540, 60, 60);
	}


}
