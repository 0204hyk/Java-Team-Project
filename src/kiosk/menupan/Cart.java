package kiosk.menupan;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import kiosk.tools.WithImage;

public class Cart extends JScrollPane {
	String root = "images/KioskImages/3. 메뉴선택";
	WithImage wi = new WithImage(root);
	
	public Cart() {
//		JLabel menuBg = wi.makeLabel("wholeMenu.png", 0,0,505,190);
//		setViewportView(menuBg);
		
		setOpaque(false);
		setBorder(null);
		getViewport().setLayout(null);
		setVisible(true);
		getViewport().setOpaque(false);
		setBounds(25, 760, 505, 185);
		setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
//		setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
		
	
	}

}
