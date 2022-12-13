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

public class TeaAdeButton extends JButton {

	
	JPanel nonCoffeePanel;
	JPanel coffeePanel;
	JPanel teaAdePanel;
	JPanel frappeBiendedPanel;
	
	
	public TeaAdeButton(JPanel nonCoffeePanel, JPanel coffeePanel, JPanel teaAdePanel, JPanel frappeBiendedPanel) {
		this.coffeePanel = coffeePanel;
		this.nonCoffeePanel = nonCoffeePanel;
		this.teaAdePanel = teaAdePanel;
		this.frappeBiendedPanel = frappeBiendedPanel;
		
		// 기본적으로 버튼이 비활성화 되어 있다.
		try {
			BufferedImage image = ImageIO.read(new File("images/PosImages/계산 파트 이미지/티, 에이드 비활성 버튼.png"));
			Image scale = image.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(scale));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setBounds(840, 110, 150, 100);
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
				
			}
			
			// 마우스 누를 시 teaAdePanel이 나타난다.
			@Override
			public void mousePressed(MouseEvent e) {
				teaAdePanel.setVisible(true);
			}
		});
		
	}
}
