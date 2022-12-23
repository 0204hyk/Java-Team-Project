package pos.closing.closing_message.container;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import pos.PosFrame;
import pos.closing.closing_main.ClosingFrame;
import pos.closing.closing_message.ClosingMessageFrame;
import pos.closing.closing_message.component.ClosingAcceptButton;
import pos.closing.closing_message.component.ClosingRejectButton;

public class ClosingBackgroundPanel extends JPanel {
	// 마감확인안내창 배경 이미지 프레임
	ClosingFrame mainFrame;
	ClosingMessageFrame frame;
	Image background;
	
	public void paintComponent(Graphics g) {
		// 이미지 그리기
		Dimension d = getSize();
		g.drawImage(background, 0, 0, d.width, d.height, null);		
	}	
	
	public ClosingBackgroundPanel(ClosingFrame mainFrame, ClosingMessageFrame frame, Image background) {
		this.background = background;
		setSize(new Dimension(background.getWidth(null), background.getHeight(null)));
		setLayout(null);
		setSize(500, 250);
		
		ClosingAcceptButton acceptBtn = new ClosingAcceptButton(mainFrame, frame);
		acceptBtn.setLocation(80, 140);

		ClosingRejectButton rejectBtn = new ClosingRejectButton(mainFrame,frame);
		rejectBtn.setLocation(280, 140);
		
		add(acceptBtn);
		add(rejectBtn);
	}

}
