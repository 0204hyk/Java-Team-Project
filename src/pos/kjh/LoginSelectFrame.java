package pos.kjh;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kiosk.TouchToPlaceAnOrder;
import pos.product_management.menu01_main.ProductManagementJFrame;

public class LoginSelectFrame extends JFrame{
	
	public static void buttonSetting(JButton b) {
		b.setBorderPainted(false);
		b.setContentAreaFilled(false);
		b.setFocusPainted(false);
		b.setFocusable(false);
	}
	
	
	
	public LoginSelectFrame() {
		
		
		// 키오스크 로그인 버튼
		JButton kioskBtn = ProductManagementJFrame.btnImage(
				"images/KioskImages/1. 관리자, 키오스크 모드/Asset 11@4x-8.png"
				, "images/KioskImages/1. 관리자, 키오스크 모드/Asset 11@4x-8 클릭.png"
				, 87, 154, 163, 141);
		
		kioskBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TouchToPlaceAnOrder();
			}
		});
		
		
		// 포스 로그인 버튼
		JButton posBtn = ProductManagementJFrame.btnImage(
				"images/KioskImages/1. 관리자, 키오스크 모드/Asset 10@4x-8.png"
				, "images/KioskImages/1. 관리자, 키오스크 모드/Asset 10@4x-8 클릭.png"
				, 319, 154, 163, 141);
		
		posBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginStart(); 
			}
		});
		
		
		// 닫기 버튼
		JButton xBtn = new JButton();
		try {
			BufferedImage bufferedxImage = ImageIO.read(new File("images/KioskImages/1. 관리자, 키오스크 모드/닫기 버튼.png"));
			Image xBtnImage = bufferedxImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			xBtn.setIcon(new ImageIcon(xBtnImage));
			xBtn.setBounds(520, 10, 40, 40);
			
			xBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
				
		add(xBtn);
		add(posBtn);
		add(kioskBtn);
		
		buttonSetting(kioskBtn);
		buttonSetting(posBtn);
		buttonSetting(xBtn);
		
		setUndecorated(true);
		setLayout(null);
		setSize(570, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		setLocationRelativeTo(null);
		setResizable(false); 
		setVisible(true);
	}
	


	public static void main(String[] args) throws IOException {
		new LoginSelectFrame();
	}
		
	

}
