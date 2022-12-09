package pos.kjh;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginSelectFrame extends JFrame{
	
	//LoginSelectButton lb = new LoginSelectButton();
	
	public LoginSelectFrame() throws IOException {
		
		JButton kioskBtn = new JButton();
		JButton posBtn = new JButton();
		
		BufferedImage bufferedKioskImage = ImageIO.read(new File("./login_image/Asset 11@4x-8.png"));
		BufferedImage bufferedPoskImage = ImageIO.read(new File("./login_image/Asset 10@4x-8.png"));
		
		Image kImage = bufferedKioskImage.getScaledInstance(163, 141, Image.SCALE_SMOOTH);
		Image pImage = bufferedPoskImage.getScaledInstance(163, 141, Image.SCALE_SMOOTH);
		
		kioskBtn.setIcon(new ImageIcon(kImage));
		posBtn.setIcon(new ImageIcon(pImage));

		kioskBtn.setText("키오스크");
		posBtn.setText("포스");
		
		kioskBtn.setBounds(87, 154, 163, 141);
		posBtn.setBounds(319, 154, 163, 141);
		
		add(kioskBtn);
		add(posBtn);
		
		setLayout(null);
		setBounds(700, 150, 570, 450);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
	}
	


	public static void main(String[] args) throws IOException {
		new LoginSelectFrame();
	}
		
	

}
