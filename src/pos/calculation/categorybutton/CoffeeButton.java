package pos.calculation.categorybutton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import pos.calculation.menubutton.CoffeeMenu;
import pos.calculation.menubutton.FrappeBlendedMenu;
import pos.calculation.menubutton.NonCoffeeMenu;
import pos.calculation.menubutton.TeaAdeMenu;

public class CoffeeButton extends JButton{
	
	JPanel nonCoffeePanel;
	JPanel coffeePanel;
	JPanel teaAdePanel;
	JPanel frappeBiendedPanel;
	
	public CoffeeButton(JPanel nonCoffeePanel, JPanel coffeePanel, JPanel teaAdePanel, JPanel frappeBiendedPanel) {
		this.coffeePanel = coffeePanel;
		this.nonCoffeePanel =  nonCoffeePanel;
		this.teaAdePanel = teaAdePanel;
		this.frappeBiendedPanel = frappeBiendedPanel;
		
		setBounds(550, 110, 150, 100);
		setText("커피");
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nonCoffeePanel.setVisible(false);
				teaAdePanel.setVisible(false);
				frappeBiendedPanel.setVisible(false);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				coffeePanel.setVisible(true);
			}
			
		});
	}

	
	
}
