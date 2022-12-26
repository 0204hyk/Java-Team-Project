package kiosk;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

import kiosk.logout.KioskHomeBtn;
import kiosk.menupan.ChoiceMenu;
import kiosk.menupan.Options;
import kiosk.tools.WithImage;

public class TouchToPlaceAnOrder extends JFrame {
	String root = "images/KioskImages/2_1. touchScreen";
	JButton pic;
	Timer tm;
	int x = 0;

	WithImage wi = new WithImage(root);
	String[] list = { root + "/poster1.png", root + "/poster2.png", root + "/poster3.png", root + "/poster4.png",
			root + "/poster5.png" };

	public KioskHomeBtn home = new KioskHomeBtn(this); 
	public TouchToPlaceAnOrder() {
		setUndecorated(true);
		add(home);
		
		add(wi.makeLabel("hy.png", 53, 23, 60, 83));
		add(wi.makeLabel("touchScreen.png", 38, 752, 573, 83));

		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);

		pic = new JButton();
		pic.setBounds(0, 0, 650, 920);

		setImageSize(4);

		tm = new Timer(4000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setImageSize(x);
				x += 1;
				if (x >= list.length)
					x = 0;
			}
		});

		pic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Options.choiceMenu = new ChoiceMenu();
				
			}
		});
		
		pic.setBorderPainted(false);
		pic.setContentAreaFilled(false);
		
		add(pic);
		tm.start();
		
		setLayout(null);
		setSize(650, 950);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void setImageSize(int i) {
		ImageIcon icon = new ImageIcon(list[i]);
		Image newImg = icon.getImage().getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newImc = new ImageIcon(newImg);
		pic.setIcon(newImc);
	}


	public static void main(String[] args) {
		new TouchToPlaceAnOrder();

	}
}
