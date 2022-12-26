package kiosk.logout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import kiosk.TouchToPlaceAnOrder;


public class KioskAccessPanel extends JPanel{
	TouchToPlaceAnOrder mainframe;
	KioskEndFrame frame;
	KioskAccessPanel panel;

	public JPasswordField accessPassword;

	static JLabel discordance = loginCheck("암호가 틀렸습니다.");
	public static  JLabel loginCheck(String text) {
		JLabel l = new JLabel(text);

		l.setForeground(Color.RED);
		l.setBounds(21, 105, 200, 43);

		return l;
	}

	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("images/KioskImages/2_1. touchScreen Selected/키오스크 관리자 모드 접속창 틀.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}	

	public JPasswordField managerAccess() {

		accessPassword = new JPasswordField();


		accessPassword.setBounds(30, 75, 300, 30);
		accessPassword.selectAll();
		accessPassword.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		accessPassword.setOpaque(false);
		accessPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		return accessPassword;
	}

	
//	public static String pwValue() {
//		
//		String pw = "";
//		  
//		//managerAccess 필드에서 패스워드를 얻어옴, char[] 배열에 저장
//		char[] secret_pw = managerAccess().getPassword(); 
//
//		//secret_pw 배열에 저장된 암호의 자릿수 만큼 for문 돌리면서 cha에 한 글자씩 저장
//		     for(char cha : secret_pw){         
//		         Character.toString(cha);       //cha 에 저장된 값 string으로 변환
//		       //pw 에 저장하기, pw 에 값이 비어있으면 저장, 값이 있으면 이어서 저장하는 삼항연산자
//		         pw += (pw.equals("")) ? ""+cha+"" : ""+cha+"";   
//		     }
//		     
//		
//		return pw;
//	}

	public KioskAccessPanel(TouchToPlaceAnOrder mainframe, KioskEndFrame frame) {
		this.mainframe = mainframe;
		this.frame = frame;

		discordance.setVisible(false);
		setLayout(null);
		setSize(450, 160);
		
		KioskEndCheckBtn kioskBtn = new KioskEndCheckBtn(mainframe, this, frame);
		
		JButton closeBtn = new JButton();
		try {
			BufferedImage bufferedcloseBtnImage = ImageIO.read(new File("images/PosImages/계산 파트 이미지/안내 멘트 창 닫기 버튼.png"));
			Image closeBtnImage = bufferedcloseBtnImage.getScaledInstance(35,35, Image.SCALE_SMOOTH);
			closeBtn.setIcon(new ImageIcon(closeBtnImage));
			closeBtn.setBounds(410, 10, 35, 35);
			closeBtn.setBorderPainted(false);
			closeBtn.setContentAreaFilled(false);
			closeBtn.setFocusPainted(false);
			closeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					mainframe.home.setEnabled(true);
					mainframe.setEnabled(true);
					frame.dispose();
				}
			});
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		add(closeBtn);
		add(kioskBtn);
		add(managerAccess());
		add(discordance);
	}	     
	

}
