package kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import kiosk.tools.WithImage;

public class Step2 extends JFrame {

	String root = "images/KioskImages/5. step2";
	WithImage wi = new WithImage(root);
	
	public Step2() {

		add(wi.makeLabel("hy.png", 52, 25, 60, 83));
		add(wi.makeButton("home.png", 542, 44, 52, 52));

		JLabel step1 = new JLabel("Step1. 적립");
		step1.setBounds(52, 208, 150, 30);
		step1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		add(step1);

		JLabel step2 = new JLabel("Step2. 결제 방식");
		step2.setBounds(52, 478, 150, 30);
		step2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		add(step2);
		
		add(wi.makeLabel("save.png", 73,248,158,141));
		add(wi.makeLabel("join.png", 417,248,158,141));
		add(wi.makeLabel("notsave.png", 245,248,158,141));
		add(wi.makeButton("card.png", 73,519,158,141));
		add(wi.makeButton("point.png", 245,519,158,141));
 

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
		new Step2();
	}
}
