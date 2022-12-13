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

public class NonCoffeeButton extends JButton{

	JPanel nonCoffeePanel;
	JPanel coffeePanel;
	JPanel teaAdePanel;
	JPanel frappeBiendedPanel;

	public NonCoffeeButton(JPanel coffeePanel, JPanel nonCoffeePanel, JPanel teaAdePanel, JPanel frappeBiendedPanel) {
		
		this.coffeePanel =  coffeePanel;
		this.nonCoffeePanel = nonCoffeePanel;
		this.teaAdePanel = teaAdePanel;
		this.frappeBiendedPanel = frappeBiendedPanel;
	

		try {
			BufferedImage image = ImageIO.read(new File("images/PosImages/계산 파트 이미지/논커피 비활성 버튼.png"));
			Image scale = image.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scale));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setBounds(695, 110, 150, 100);
		setBorder(null);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				coffeePanel.setVisible(false);
				teaAdePanel.setVisible(false);
				frappeBiendedPanel.setVisible(false);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				nonCoffeePanel.setVisible(true);
				
			}
			
		});
	}



}
