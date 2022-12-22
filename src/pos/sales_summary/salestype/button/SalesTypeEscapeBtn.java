package pos.sales_summary.salestype.button;

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
import pos.sales_summary.salestype.SalesTypeFrame;


public class SalesTypeEscapeBtn extends JButton implements ActionListener{
	
	SalesTypeFrame f;
	ImageScaledTool tool = new ImageScaledTool();
	
	
	public SalesTypeEscapeBtn(SalesTypeFrame f) {
		this.f = f;
		
		
		setIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/영수증 조회 이미지/돌아가기 버튼.png", 180, 60)));
		setPressedIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/영수증 조회 이미지/돌아가기 버튼 클릭.png", 180, 60)));
		addActionListener(this);
		setSize(180, 60);
		setLocation(100, 700);
		setContentAreaFilled(false);	// 버튼 배경 지우기
		setBorderPainted(false);	// 버튼 테두리 지우기
		setFocusable(false);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		f.dispose();
		
	}
}
