package kiosk;

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

import kiosk.tools.WithImage;

public class Step1 extends JFrame {

	String root = "images/KioskImages/5. step1";
	WithImage wi = new WithImage(root);

	public Step1() {

		// 포인트 적립
		JButton save = wi.makeButton("save.png", 73, 248, 158, 141);
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EnterPhoneNum(); // 대조
				// 포인트 적립 띄우기 - 디자인
			}
		});


		// 포인트 적립 안함
		JButton notsave = wi.makeButton("notsave.png", 245, 248, 158, 141);
		
		notsave.addActionListener(new ActionListener() {
			int num = 1;
			@Override
			public void actionPerformed(ActionEvent e) {
				if (num == 0) {
					notsave.setIcon(new ImageIcon(wi.readImage(root + "/notsave.png", 158, 141)));
					num = 1;
					save.setEnabled(true);
					
				} else if (num ==1){
					notsave.setIcon(new ImageIcon(wi.readImage(root + " Selected/notsave.png", 158, 141)));
					save.setEnabled(false);
					num = 0;
				}
			}
		});

		// 간편 가입
		JButton join = wi.makeButton("join.png", 417, 248, 158, 141);
		join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame jf = new EnterPhoneNum(); // 열리면 비활성화, 닫히면 원래 떠있던 창이 활성화 되어야한다
				jf.add(new JLabel("회원 가입")); // 이거 디자인해서 붙이기 
				// 바로 포인트 적립 진행 (창 만들어야 함)
			}
		});
		
		add(save);
		add(notsave);
		add(join);

		add(wi.makeLabel("hy.png", 52, 25, 60, 83));
		add(wi.makeButton("home.png", 542, 44, 52, 52));

		JLabel step1 = new JLabel("Step1. 적립");
		step1.setBounds(52, 208, 150, 30);
		step1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		add(step1);

		add(wi.makeLabel("card.png", 73, 519, 158, 141));
		add(wi.makeLabel("point.png", 245, 519, 158, 141));

		JLabel step2 = new JLabel("Step2. 결제 방식");
		step2.setBounds(52, 478, 150, 30);
		step2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		add(step2);

		JButton pay = wi.makeButton("pay.png", 324, 771, 192, 67);
		pay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Step2();
			}
		});
		
		
		JButton cancel = wi.makeButton("cancel.png", 113, 771, 192, 67);
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// 장바구니가 유지된 첫 화면으로 돌아가야 됨
			}
		});
		
		add(pay);
		add(cancel);

		setLayout(null);
		setSize(650, 950);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
	}
	

	public static void main(String[] args) {
		new Step1();
		
	}
}
