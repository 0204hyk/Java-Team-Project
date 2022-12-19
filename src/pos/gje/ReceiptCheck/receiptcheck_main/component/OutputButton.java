package pos.gje.ReceiptCheck.receiptcheck_main.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class OutputButton extends JButton implements ActionListener{

	public OutputButton() {		
		try {
			BufferedImage bufferedImage = ImageIO.read(new File("images/PosImages/영수증 조회 이미지/영수증 출력 버튼.png"));
			Image scaledImage = bufferedImage.getScaledInstance(250, 80, Image.SCALE_SMOOTH); // 크기 조정
			setIcon(new ImageIcon(scaledImage));
			
			BufferedImage bufferedImage2 = ImageIO.read(new File("images/PosImages/영수증 조회 이미지/영수증 출력 버튼 클릭.png"));
			Image scaledImage2 = bufferedImage2.getScaledInstance(250, 80, Image.SCALE_SMOOTH); // 크기 조정
			ImageIcon img = new ImageIcon(scaledImage2);
			setPressedIcon(img);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		
		setEnabled(false);
		setBounds(630, 670, 250, 80);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setOpaque(false);
		addActionListener(this);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		JFrame f = new JFrame();
//		
//		
//		
//		f.setSize(400, 300);
//		f.getContentPane().setBackground(new Color(64, 64, 64)); // 배경색
//		f.setLayout(null); 
//		f.setResizable(false); // 크기 조절 안되게
//		f.setLocationRelativeTo(null); // 가운데에 뜨게
//		f.setVisible(true);
//		
		
		JOptionPane.showMessageDialog(null, "영수증 출력 완료");
	}
	

}
