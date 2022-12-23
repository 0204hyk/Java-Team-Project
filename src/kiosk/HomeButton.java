package kiosk;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import kiosk.menupan.ChoiceMenu;
import kiosk.menupan.Options;
import kiosk.tools.WithImage;

public class HomeButton extends JButton implements ActionListener {

	String root = "images/KioskImages/2_1. touchScreen";
	WithImage wi = new WithImage(root);

	public HomeButton() {
		add(wi.makeButton("home.png", 542, 44, 52, 52));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		Options.choiceMenu = new ChoiceMenu();
	}

}
