package pos.closing.closing_message.container;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import pos.closing.closing_message.ClosingMessageFrame;
import pos.closing.closing_message.component.ClosingAcceptButton;
import pos.closing.closing_message.component.ClosingRejectButton;

public class ClosingBackgroundPanel extends JPanel {
	ClosingMessageFrame frame;
	Image background;
	
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(background, 0, 0, d.width, d.height, null);		
	}	
	
	public ClosingBackgroundPanel(ClosingMessageFrame frame, Image background) {
		this.background = background;
		setSize(new Dimension(background.getWidth(null), background.getHeight(null)));
		setLayout(null);
		setSize(500, 250);
		
		ClosingAcceptButton acceptBtn = new ClosingAcceptButton();
		acceptBtn.setLocation(80, 140);

		ClosingRejectButton rejectBtn = new ClosingRejectButton(frame);
		rejectBtn.setLocation(280, 140);
		
		add(acceptBtn);
		add(rejectBtn);
	}

}
