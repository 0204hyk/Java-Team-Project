package pos.kjh;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class MenuAddFrame extends JFrame{
	
	JScrollPane scrollPane;
	ImageIcon icon;
	
	
	
	public JButton fixBtn() throws IOException{
		JButton fixBtn = new JButton();

		BufferedImage bufferedfixBtnImage = ImageIO.read(new File("PosImages/상품 관리 이미지/메뉴 추가 창 확인 버튼.png"));
		Image fixBtnImage = bufferedfixBtnImage.getScaledInstance(100,50, Image.SCALE_SMOOTH);
		fixBtn.setIcon(new ImageIcon(fixBtnImage));
		fixBtn.setBounds(750,380, 100,50);

		fixBtn.setBorderPainted(false);
		fixBtn.setContentAreaFilled(false);
		fixBtn.setFocusPainted(false);

		BufferedImage bufferedBtnClickImage = ImageIO.read(new File("PosImages/상품 관리 이미지/메뉴 추가 창 확인 버튼 클릭.png"));
		Image btnClickImage = bufferedBtnClickImage.getScaledInstance(100,50, Image.SCALE_SMOOTH);
		Icon btnClickIcon = new ImageIcon(btnClickImage);
		
		fixBtn.setPressedIcon(btnClickIcon);

		return fixBtn;
	}
	
//	public JRadioButton category() {
//		return
//	}

	
	public MenuAddFrame() throws IOException {
		
		JRadioButton coffee = new JRadioButton("Coffee");
		coffee.setBounds(180, 305, 90, 70);
		coffee.setFont(coffee.getFont().deriveFont(20.0f));
		coffee.setBorderPainted(false);
		coffee.setContentAreaFilled(false);
		coffee.setFocusPainted(false);
		
		
		

		icon = new ImageIcon("PosImages/상품 관리 이미지/메뉴 추가 창 기본 틀.png");

		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(icon.getImage(), 0, 0, d.width, d.height,null);
				setOpaque(false); 
				super.paintComponent(g);
			}
		};
		
		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);
		
			
		background.add(fixBtn());

		background.setBounds(0, 0, 890, 480);
		
		add(coffee);
		add(background);
		
		
		background.setLayout(null);	
		setLayout(null);
		//setUndecorated(true);
		setResizable(false);
		setSize(900, 480);
		setLocationRelativeTo(null);
		setVisible(true);
		
		

	}



	public static void main(String[] args) throws IOException {
		new MenuAddFrame();
	}
}
