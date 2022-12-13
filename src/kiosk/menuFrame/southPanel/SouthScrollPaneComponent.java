package kiosk.menuFrame.southPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SouthScrollPaneComponent extends JPanel{
	
	Font font = new Font("맑은 고딕", Font.PLAIN, 16);
	
	public SouthScrollPaneComponent() {
		setSettings();
		components();
	}
	
	public void setSettings() {
		FlowLayout layout = new FlowLayout(0,10,10);


		setLayout(layout);
	}
	
	
	public void components() {

		add(number());
		add(menu());
		
		add(minusButton());
		add(amount());
		add(plusButton());
		add(closeButton());
	}
	
	
	public JLabel number() {
		JLabel label = new JLabel();
		
		try {
			BufferedImage numberBufferedImage =
			ImageIO.read(new File("images/KioskImages/3_메뉴선택/Scaled1.png"));			
			label.setIcon(new ImageIcon(numberBufferedImage));
			
			label.setPreferredSize(new Dimension(30,30));
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return label;
	}
	
	public JLabel menu() {
		String text = "카페라떼(ICE) 3,500원";
		
		JLabel label = new JLabel();
		label.setText(String.format("%-35s", text));
		label.setFont(font);
		
		return label;
	}
	
	public JButton minusButton() {
		JButton button = new JButton();
		
		try {
			BufferedImage buttonBufferedImage =
			ImageIO.read(new File("images/KioskImages/3_메뉴선택/minusButtonScaled.png"));			
			button.setIcon(new ImageIcon(buttonBufferedImage));
			
			button.setBorderPainted(false);	
			button.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			button.setOpaque(false);
			button.setPreferredSize(new Dimension(30,30));
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return button;
	}
	
	public JLabel amount() {
		JLabel label = new JLabel();
		label.setText("1잔");
		label.setFont(font);
		
		return label;
		
	}
	
	public JButton plusButton() {
		JButton button = new JButton();
		
		try {
			BufferedImage buttonBufferedImage =
			ImageIO.read(new File("images/KioskImages/3_메뉴선택/plusButtonScaled.png"));			
			button.setIcon(new ImageIcon(buttonBufferedImage));
			
			button.setBorderPainted(false);	
			button.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			button.setOpaque(false);
			button.setPreferredSize(new Dimension(30,30));
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return button;
	}
	
	public JButton closeButton() {
		JButton button = new JButton();
		
		try {
			BufferedImage buttonBufferedImage =
			ImageIO.read(new File("images/KioskImages/3_메뉴선택/closeButtonScaled.png"));			
			button.setIcon(new ImageIcon(buttonBufferedImage));
			
			button.setBorderPainted(false);	
			button.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			button.setOpaque(false);
			button.setPreferredSize(new Dimension(30,30));
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return button;
	}
	
	
	
}
