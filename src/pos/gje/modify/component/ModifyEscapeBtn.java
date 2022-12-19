package pos.gje.modify.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pos.gje.modify.ModifyFrame;
import pos.kjh.ProductManagementJFrame;

public class ModifyEscapeBtn extends JButton implements ActionListener{
	ProductManagementJFrame mainFrame;
	ModifyFrame modifyFrame;
	public ModifyEscapeBtn(ProductManagementJFrame mainFrame, ModifyFrame modifyFrame) {
		this.mainFrame = mainFrame;
		this.modifyFrame = modifyFrame;
		try {
			File file = new File("images/PosImages/상품 관리 이미지/닫기 버튼.png");
			BufferedImage bufferedImage = ImageIO.read(file);
			Image scaledImage = bufferedImage.getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING);
			ImageIcon btnImage = new ImageIcon(scaledImage);
			setIcon(btnImage);
			setBounds(840, 10, 50, 50);
			setContentAreaFilled(false);	// 버튼 배경 지우기
			setBorderPainted(false);	// 버튼 테두리 지우기
			setFocusable(false);	
			
			addActionListener(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		mainFrame.setEnabled(true);
		modifyFrame.dispose();
	}
	
	
}
