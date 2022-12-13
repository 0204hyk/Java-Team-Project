package pos.calculation.categorybutton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NonCoffeeButton extends JButton{

	JPanel nonCoffeePanel;
	JPanel coffeePanel;
	JPanel teaAdePanel;
	JPanel frappeBiendedPanel;
	
	public NonCoffeeButton(JPanel coffeePanel, JPanel nonCoffeePanel, JPanel teaAdePanel, JPanel frappeBiendedPanel) {
		this.coffeePanel =  coffeePanel;
		this.nonCoffeePanel = nonCoffeePanel;
		this.teaAdePanel = teaAdePanel;
		this.frappeBiendedPanel = frappeBiendedPanel;
		
		setBounds(695, 110, 150, 100);
		setText("논커피");
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				coffeePanel.setVisible(false);
				teaAdePanel.setVisible(false);
				frappeBiendedPanel.setVisible(false);
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				nonCoffeePanel.setVisible(true);
			}
			
		});
	}
}
