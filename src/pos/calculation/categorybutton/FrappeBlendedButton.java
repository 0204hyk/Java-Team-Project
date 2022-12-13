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

public class FrappeBlendedButton extends JButton {

	JPanel nonCoffeePanel;
	JPanel coffeePanel;
	JPanel teaAdePanel;
	JPanel frappeBiendedPanel;
	JButton coffeeBtn;
	
	public FrappeBlendedButton(JButton coffeeBtn) {
		this.coffeeBtn = coffeeBtn;
	}
	
	public FrappeBlendedButton(JPanel nonCoffeePanel, JPanel coffeePanel, JPanel teaAdePanel, JPanel frappeBiendedPanel) {
		this.coffeePanel = coffeePanel;
		this.nonCoffeePanel = nonCoffeePanel;
		this.teaAdePanel = teaAdePanel;
		this.frappeBiendedPanel = frappeBiendedPanel;
		
		// 이미지 추가예정..
		
		setBounds(985, 110, 150, 100);
		setBackground(Color.WHITE);
		setText("프라페/블렌디드");
		addMouseListener(new MouseAdapter() {
			
			// 마우스 클릭 시 기존에 나오던 Panel들은 숨긴다.
			@Override
			public void mouseClicked(MouseEvent e) {
				coffeePanel.setVisible(false);
				teaAdePanel.setVisible(false);
				nonCoffeePanel.setVisible(false);
				frappeBiendedPanel.setVisible(true);
			}
		
	
		});
		
	}
}
