package pos.calculation.categorybutton;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import pos.calculation.menubutton.CoffeeMenu;
import pos.calculation.menubutton.FrappeBlendedMenu;
import pos.calculation.menubutton.NonCoffeeMenu;
import pos.calculation.menubutton.TeaAdeMenu;

public class CoffeeButton extends JButton{
	
	JPanel nonCoffeePanel;
	JPanel coffeePanel;
	JPanel teaAdePanel;
	JPanel frappeBiendedPanel;
	
	public CoffeeButton() {
		
	}
	
	
	public CoffeeButton(JPanel nonCoffeePanel, JPanel coffeePanel, JPanel teaAdePanel, JPanel frappeBiendedPanel) {
		this.coffeePanel = coffeePanel;
		this.nonCoffeePanel =  nonCoffeePanel;
		this.teaAdePanel = teaAdePanel;
		this.frappeBiendedPanel = frappeBiendedPanel;
		
		try {
			BufferedImage image = ImageIO.read(new File("images/PosImages/계산 파트 이미지/카페 카테고리 버튼.png"));
			Image scale = image.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scale));
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	
		setBounds(550, 110, 150, 100);
		setBorderPainted(false);
		setContentAreaFilled(false);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nonCoffeePanel.setVisible(false);
				teaAdePanel.setVisible(false);
				frappeBiendedPanel.setVisible(false);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				coffeePanel.setVisible(true);
				
			}
			
		});
		
	
	}

	public void setCoffeeBtn() {
		try {
			BufferedImage image = ImageIO.read(new File("images/PosImages/계산 파트 이미지/카페 카테고리 비활성 버튼.png"));
			Image scale = image.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scale));
			setBorder(null);
		} catch (IOException e) {
			e.printStackTrace();
			
		}

	}

}
