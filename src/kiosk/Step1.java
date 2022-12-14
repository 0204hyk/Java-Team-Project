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

		//포인트 적립
		JButton save = wi.makeButton("save.png", 73,248,158,141);
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new EnterPhoneNum(); //대조
			}
		});
		add(save);
		
		//간편 가입
		JButton join = wi.makeButton("join.png", 417,248,158,141);
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new EnterPhoneNum(); //열리면 비활성화, 닫히면 원래 떠있던 창이 활성화 되어야한다
			}
		});
		add(join);	
		
		add(wi.makeButton("notsave.png", 245,248,158,141));
		add(wi.makeLabel("hy.png", 52, 25, 60, 83));
		add(wi.makeButton("home.png", 542, 44, 52, 52));

		JLabel step1 = new JLabel("Step1. 적립");
		step1.setBounds(52, 208, 150, 30);
		step1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		add(step1);

		add(wi.makeLabel("card.png", 73,519,158,141));
		add(wi.makeLabel("point.png", 245,519,158,141));

		JLabel step2 = new JLabel("Step2. 결제 방식");
		step2.setBounds(52, 478, 150, 30);
		step2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		add(step2);

		add(wi.makeButton("pay.png", 324, 771, 192, 67));
		add(wi.makeButton("cancel.png", 113, 771, 192, 67));

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
