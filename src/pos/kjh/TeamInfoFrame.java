package pos.kjh;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import pos.main.main_component.ProductManagementButton;


public class TeamInfoFrame extends JFrame{

	public JLabel introduction(String message, int a, int b, int c, int d) {

		JLabel label = new JLabel(message);

		label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		label.setOpaque(false);
		label.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		label.setBounds(a, b, c, d);

		return label;
	}

	public JLabel profile(String message, int a, int b, int c, int d) {

		JLabel label = new JLabel(message);

		label.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		label.setOpaque(false);
		label.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		label.setBounds(a, b, c, d);

		return label;
	}
	
	public JLabel position(String message, int a, int b, int c, int d) {

		JLabel label = new JLabel(message);

		label.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		label.setOpaque(false);
		label.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		label.setBounds(a, b, c, d);

		return label;
	}

	public static JLabel labelImage(String image, int a, int b, int c, int d) throws IOException {
		JLabel l = new JLabel();
		BufferedImage bufferedlImage = ImageIO.read(new File(image));
		Image lImage = bufferedlImage.getScaledInstance(c, d, Image.SCALE_SMOOTH);
		l.setIcon(new ImageIcon(lImage));
		l.setBounds(a, b, c, d);

		return l;

	}

	public TeamInfoFrame() throws IOException {

		add(introduction("소개글", 65, 70, 100, 50));
/*
		// 이름
		add(profile("김하영", 95, 170, 50, 40));
		add(profile("정수정", 95, 220, 50, 40));
		add(profile("강병천", 95, 270, 50, 40));
		add(profile("구지은", 95, 320, 50, 40));
		add(profile("전인재", 95, 370, 50, 40));
		add(profile("김주희", 95, 420, 50, 40));
		
		// 직책
		add(position("팀장", 145, 170, 50, 40));
		add(position("부팀장", 145, 220, 50, 40));
		add(position("팀원", 145, 270, 50, 40));
		add(position("팀원", 145, 320, 50, 40));
		add(position("팀원", 145, 370, 50, 40));
		add(position("팀원", 145, 420, 50, 40));

		// 프로필 사진(임시)
		add(labelImage("images/PosImages/시작 페이지 버튼 이미지/프사2.jpg", 43, 170, 40, 40));
		add(labelImage("images/PosImages/시작 페이지 버튼 이미지/프사1.png", 43, 220, 40, 40));
		add(labelImage("images/PosImages/시작 페이지 버튼 이미지/프사3.png", 43, 270, 40, 40));
		add(labelImage("images/PosImages/시작 페이지 버튼 이미지/프사4.png", 43, 320, 40, 40));
		add(labelImage("images/PosImages/시작 페이지 버튼 이미지/프사5.png", 43, 370, 40, 40));
		add(labelImage("images/PosImages/시작 페이지 버튼 이미지/프사 6.jpg", 43, 420, 40, 40));
*/
		JButton xBtn = new JButton();
		BufferedImage bufferedxImage = ImageIO.read(new File("images/KioskImages/1. 관리자, 키오스크 모드/닫기 버튼.png"));
		Image xBtnImage = bufferedxImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		xBtn.setIcon(new ImageIcon(xBtnImage));
		xBtn.setBounds(455, 15, 30, 30);

		xBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		add(xBtn);
		LoginSelectFrame.buttonSetting(xBtn);

		add(new TeamInfoPanel());

		setUndecorated(true);
		setLayout(null);
//		setSize(350, 510);
		setSize(500, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		setLocationRelativeTo(null);
		setResizable(false); 
		setVisible(true);

	}

	public static void main(String[] args) throws IOException {
		new TeamInfoFrame();
	}

}
