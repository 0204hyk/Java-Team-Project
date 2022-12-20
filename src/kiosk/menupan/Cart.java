package kiosk.menupan;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import kiosk.byoption.AMenu;
import kiosk.tools.WithImage;

public class Cart extends JScrollPane {
	String root = "images/KioskImages/3. 메뉴선택";
	WithImage wi = new WithImage(root);
	
	public Cart() {
		
		JLabel menuBg = wi.makeLabel("wholeMenu.png", 25, 760, 505, 391);
		setViewportView(menuBg);
		setOpaque(false);
		getViewport().setOpaque(false);
		setBounds(25, 760, 505, 391);
	}

}
