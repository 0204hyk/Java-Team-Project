package pos.calculation.categorybutton;


import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import pos.ImageScaledTool;

public class CoffeeButton extends JButton{

	JPanel nonCoffeePanel;
	JPanel coffeePanel;
	JPanel teaAdePanel;
	JPanel frappeBiendedPanel;
	ImageScaledTool tool = new ImageScaledTool();
	
	
	public CoffeeButton(JPanel nonCoffeePanel, JPanel coffeePanel, JPanel teaAdePanel, JPanel frappeBiendedPanel) {
		this.coffeePanel = coffeePanel;
		this.nonCoffeePanel =  nonCoffeePanel;
		this.teaAdePanel = teaAdePanel;
		this.frappeBiendedPanel = frappeBiendedPanel;

		
		// 기본적으로 버튼이 활성화 되어있다.
		setIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/계산 파트 이미지/카페 카테고리 버튼.png", 160, 100)));
		setBounds(560, 110, 160, 100);
		setBorderPainted(false);
		setContentAreaFilled(false);


		addMouseListener(new MouseAdapter() {

			// 마우스 클릭 시 기존에 나오던 Panel들은 숨긴다.
			@Override
			public void mouseClicked(MouseEvent e) {
				nonCoffeePanel.setVisible(false);
				teaAdePanel.setVisible(false);
				frappeBiendedPanel.setVisible(false);
				coffeePanel.setVisible(true);
				setBtnEnabled();
			}
			
		});	
	}

	public void setBtnDisabled() {
		setIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/계산 파트 이미지/카페 카테고리 비활성 버튼.png", 160, 100)));
	}
	
	public void setBtnEnabled() {
		setIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/계산 파트 이미지/카페 카테고리 버튼.png", 160, 100)));
	}
		
}
