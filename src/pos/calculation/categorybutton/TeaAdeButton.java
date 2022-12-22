package pos.calculation.categorybutton;

import java.awt.Color;
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

public class TeaAdeButton extends JButton {

	
	JPanel nonCoffeePanel;
	JPanel coffeePanel;
	JPanel teaAdePanel;
	JPanel frappeBiendedPanel;
	ImageScaledTool tool = new ImageScaledTool();
	
	public TeaAdeButton() {
	}
	
	public TeaAdeButton(JPanel nonCoffeePanel, JPanel coffeePanel, JPanel teaAdePanel, JPanel frappeBiendedPanel) {
		this.coffeePanel = coffeePanel;
		this.nonCoffeePanel = nonCoffeePanel;
		this.teaAdePanel = teaAdePanel;
		this.frappeBiendedPanel = frappeBiendedPanel;
		
		// 기본적으로 버튼이 비활성화 되어 있다.
		setIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/계산 파트 이미지/티 카테고리 비활성화 버튼.png", 160, 100)));
		
		setBounds(866, 110, 160, 100);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setBackground(Color.WHITE);
		setBorder(null);
		addMouseListener(new MouseAdapter() {
			
			// 마우스 클릭 시 기존에 나오던 Panel들은 숨긴다.
			@Override
			public void mouseClicked(MouseEvent e) {
				coffeePanel.setVisible(false);
				nonCoffeePanel.setVisible(false);
				frappeBiendedPanel.setVisible(false);
				teaAdePanel.setVisible(true);
				setBtnEnabled();
			}
		});
	}
	
	public void setBtnDisabled() {
		setIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/계산 파트 이미지/티 카테고리 비활성화 버튼.png", 160, 100)));
	}
	
	public void setBtnEnabled() {
		setIcon(new ImageIcon(tool.getScaledImage(
				"images/PosImages/계산 파트 이미지/티 카테고리 버튼.png", 160, 100)));
	}
}
