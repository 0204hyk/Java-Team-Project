package kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Kiosk_Step1_Step2 extends JFrame {

	public Kiosk_Step1_Step2() {

		add(hyLogo());
		add(home());

		JLabel step1 = new JLabel("Step1. 적립");
		step1.setBounds(52, 208, 150, 30);
		step1.setFont(new Font("맑은 고딕", Font.BOLD, 17));

		add(step1);

		add(buttons("KioskImages/5. step1, step2/save.png")).setLocation(73, 248);
		add(buttons("KioskImages/5. step1, step2/notsave.png")).setLocation(245, 248);
		add(buttons("KioskImages/5. step1, step2/join.png")).setLocation(417, 248);
		add(buttons("KioskImages/5. step1, step2/card.png")).setLocation(73, 519);
		add(buttons("KioskImages/5. step1, step2/point.png")).setLocation(245, 519);
		add(buttons("KioskImages/5. step1, step2/gifticon.png")).setLocation(417, 519);

		JLabel step2 = new JLabel("Step2. 결제 방식");
		step2.setBounds(52, 478, 150, 30);
		step2.setFont(new Font("맑은 고딕", Font.BOLD, 17));

		add(step2);

		add(pay());
		add(cancel());
		
		setLayout(null);
		setSize(650, 950);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		

		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
	}

	public JLabel hyLogo() {

		JLabel hy = new JLabel();
		try {
			BufferedImage bufferedImage =
					ImageIO.read(new File("KioskImages/5. step1, step2/hy.png"));

			Image scaledImage = bufferedImage.getScaledInstance(60, 83, Image.SCALE_SMOOTH);

			hy.setIcon(new ImageIcon(scaledImage));
		} catch (Exception e) {
			e.printStackTrace();
		}

		hy.setBounds(52, 25, 60, 83);
		return hy;

	}

	public JLabel home() {

		JLabel home = new JLabel();
		try {
			BufferedImage bufferedImage =
					ImageIO.read(new File("KioskImages/5. step1, step2/home.png"));

			Image scaledImage = bufferedImage.getScaledInstance(52, 52, Image.SCALE_SMOOTH);

			home.setIcon(new ImageIcon(scaledImage));
		} catch (Exception e) {
			e.printStackTrace();
		}

		home.setBounds(542, 44, 52, 52);
		return home;

	}

	public JButton buttons(String root) {

		JButton b = new JButton();
		try {
			BufferedImage bufferedImage =
					ImageIO.read(new File(root));

			Image scaledImage = bufferedImage.getScaledInstance(158, 141, Image.SCALE_SMOOTH);

			b.setIcon(new ImageIcon(scaledImage));
		} catch (Exception e) {
			e.printStackTrace();
		}

		b.setBorderPainted(false);
//		b.setFocusPainted(true);
		b.setContentAreaFilled(false);
		b.setSize(158, 141);
		return b;

	}

	public JButton pay() {

		JButton pay = new JButton();
		try {
			BufferedImage bufferedImage =
					ImageIO.read(new File("KioskImages/5. step1, step2/pay.png"));

			Image scaledImage = bufferedImage.getScaledInstance(192, 67, Image.SCALE_SMOOTH);

			pay.setIcon(new ImageIcon(scaledImage));
		} catch (Exception e) {
			e.printStackTrace();
		}

		pay.setBounds(324, 771, 192, 67);
		
		pay.setBorderPainted(false);
		pay.setFocusPainted(true);
		pay.setContentAreaFilled(false);
		return pay;

	}

	public JButton cancel() {

		JButton cancel = new JButton();
		try {
			BufferedImage bufferedImage =
					ImageIO.read(new File("KioskImages/5. step1, step2/ordercancel.png"));

			Image scaledImage = bufferedImage.getScaledInstance(192, 67, Image.SCALE_SMOOTH);

			cancel.setIcon(new ImageIcon(scaledImage));
		} catch (Exception e) {
			e.printStackTrace();
		}

		cancel.setBounds(113, 771, 192, 67);
		
		cancel.setBorderPainted(false);
		cancel.setFocusPainted(true);
		cancel.setContentAreaFilled(false);
		return cancel;

	}

	public static void main(String[] args) {
		new Kiosk_Step1_Step2();
	}
}
