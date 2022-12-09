package pos.closing.closing_message.container;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import pos.closing.closing_message.ClosingMessageFrame;
import pos.closing.closing_message.component.AcceptButton;
import pos.closing.closing_message.component.RejectButton;

public class BackgroundPanel extends JPanel {
	ClosingMessageFrame frame;
	private Image background;
	
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(background, 0, 0, d.width, d.height, null);		
	}	
	
	public BackgroundPanel(ClosingMessageFrame frame, Image background) {
		this.background = background;
		setSize(new Dimension(background.getWidth(null), background.getHeight(null)));
		setLayout(null);
		setSize(500, 250);
		
		AcceptButton acceptBtn = new AcceptButton();
		acceptBtn.setLocation(80, 140);

		RejectButton rejectBtn = new RejectButton(frame);
		rejectBtn.setLocation(280, 140);
		
		add(acceptBtn);
		add(rejectBtn);
	}

}
