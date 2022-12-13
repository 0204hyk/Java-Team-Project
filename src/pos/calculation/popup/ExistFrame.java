package pos.calculation.popup;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExistFrame extends JFrame {

	Image scale;
	
	public ExistFrame() {
		
		//ImageIcon icon = new ImageIcon("images/PosImages/계산 파트 이미지/메뉴 선택 안내멘트 창.png");
		
		JButton btn = new JButton();
		try {
			BufferedImage image = ImageIO.read(new File("images/PosImages/계산 파트 이미지"
					+ "/메뉴 선택 안내멘트 창.png"));
			scale = image;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		JPanel backGround = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(scale.getScaledInstance(500, 280, Image.SCALE_SMOOTH), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};
		
		btn.setBounds(430, 10, 50, 50);
		
		try {
			BufferedImage image = ImageIO.read(new File("images/PosImages/계산 파트 이미지/안내 멘트 창 닫기 버튼.png"));
			Image click = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			btn.setIcon(new ImageIcon(click));
			btn.setBorder(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

	

		setContentPane(backGround);
		add(btn);
		setLayout(null);
		setSize(500, 300);
		setLocation(500, 250);
		setVisible(true);
	}


}
