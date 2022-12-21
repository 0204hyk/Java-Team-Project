package pos.kjh;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NotSelectedFrame extends JFrame{

	static ProductManagementJFrame p;

	static JButton ok;

	public static JButton okButton() throws IOException {
		ok = p.btnImage("images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼.png",
				"images/PosImages/상품 관리 이미지/멘트만 있는 안내 창 확인 버튼 클릭.png", 150, 115 , 100, 50);



		return ok;
	}

	public NotSelectedFrame() throws IOException {
		add(okButton());
		add(new NotSelectedJPenel());
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		setBackground(Color.white);
		setUndecorated(true); 
		setSize(400, 200);
		setLayout(null); 
		setVisible(true); 
		setResizable(false); 
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) throws IOException {
		new NotSelectedFrame();
	}
}
