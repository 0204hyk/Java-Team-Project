package pos.main.exit_message;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ExitMessageBackgroundPanel extends JPanel{
	ExitMessageFrame frame;
	Image background;
	
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		g.drawImage(background, 0, 0, d.width, d.height, null);		
	}
	
	public ExitMessageBackgroundPanel(ExitMessageFrame frame, Image background) {
		this.background = background;
		setSize(new Dimension(background.getWidth(null), background.getHeight(null)));
		setLayout(null);
		setSize(500, 250);
		
		ExitAcceptButton acceptBtn = new ExitAcceptButton();
		acceptBtn.setLocation(80, 140);
		
		ExitRejectButton rejectBtn = new ExitRejectButton(frame);
		rejectBtn.setLocation(280, 140);
		
		add(acceptBtn);
		add(rejectBtn);
	}
}
