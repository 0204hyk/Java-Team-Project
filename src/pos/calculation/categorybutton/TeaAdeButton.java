package pos.calculation.categorybutton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TeaAdeButton extends JButton {

	
	JPanel nonCoffeePanel;
	JPanel coffeePanel;
	JPanel teaAdePanel;
	JPanel frappeBiendedPanel;
	
	
	public TeaAdeButton(JPanel nonCoffeePanel, JPanel coffeePanel, JPanel teaAdePanel, JPanel frappeBiendedPanel) {
		this.coffeePanel = coffeePanel;
		this.nonCoffeePanel = nonCoffeePanel;
		this.teaAdePanel = teaAdePanel;
		this.frappeBiendedPanel = frappeBiendedPanel;
		setBounds(840, 110, 150, 100);
		setText("티/에이드");
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				coffeePanel.setVisible(false);
				nonCoffeePanel.setVisible(false);
				frappeBiendedPanel.setVisible(false);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				teaAdePanel.setVisible(true);
			}
		});
		
	}
}
