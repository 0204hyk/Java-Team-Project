package pos.calculation.popup;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExistFrame {

	public ExistFrame() {
		JFrame f = new JFrame();
		JButton btn = new JButton();
		btn.setBounds(440, 10, 50, 50);
		try {
			BufferedImage image = ImageIO.read(new File("images/PosImages/계산 파트 이미지/안내 멘트 창 닫기 버튼.png"));
			Image click = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			btn.setIcon(new ImageIcon(click));
			btn.setBorder(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				f.dispose();
			}
		});
		
		
		
		
		f.add(btn);
		f.setLayout(null);
		f.setSize(500, 300);
		f.setLocation(500, 250);
		f.setVisible(true);
	}

	

}
