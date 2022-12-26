package kiosk.logout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import kiosk.TouchToPlaceAnOrder;
import kiosk.tools.WithImage;

public class KioskHomeBtn extends JButton implements ActionListener {

	String root = "images/KioskImages/2_1. touchScreen";
	WithImage wi = new WithImage(root);
	TouchToPlaceAnOrder frame;

	public KioskHomeBtn(TouchToPlaceAnOrder frame) {
		this.frame = frame;
		
		setBorderPainted(false);
		setContentAreaFilled(false);
		setIcon(new ImageIcon(wi.readImage(root + "/home.png", 52, 52)));
		setBounds(542, 44, 52, 52);

		addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			new KioskEndFrame(frame);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
