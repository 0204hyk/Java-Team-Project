package kiosk.menuFrame.southPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import kiosk.tools.WithImage;


public class South_CenterPanel extends JPanel {

	JButton paymentButton = new JButton();
	JButton cancelButton = new JButton();

	String root = "images/KioskImages/3. 메뉴선택";
	WithImage wi = new WithImage(root);

	public South_CenterPanel() {

		setLayout(new GridLayout(0, 1));

		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout(0, 10));

		panel.add(paymentButton(), BorderLayout.NORTH);
		panel.add(cancelButton(), BorderLayout.CENTER);
		panel.add(blank(), BorderLayout.SOUTH);

		add(panel);

		panel.setBackground(Color.white);

	}

	public JButton blank() {
		JButton blank = new JButton();

		blank.setPreferredSize(new Dimension(50, 40));

		try {
			BufferedImage logoBufferedImage = ImageIO
					.read(new File("images/KioskImages/3_메뉴선택/menuImages/buttonBlank.png"));
			blank.setIcon(new ImageIcon(logoBufferedImage));

			blank.setBorderPainted(false);
			blank.setBackground(Color.white); // Opaque 사용위해서 아무색이나 지정
			blank.setOpaque(false);

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return blank;

	}

	public JButton paymentButton() {

		return wi.makeButton("pay.png", 548, 760, 78, 93);

	}

	public JButton cancelButton() {
		return wi.makeButton("deleteAll.png", 548,866,78,71);

	}
}
