package pos.receipt_check.ReceiptCheck.receiptcheck_main.component;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;

import pos.receipt_check.ReceiptCheck.receiptcheck_main.List;
import pos.receipt_check.ReceiptCheck.receiptcheck_main.ReceiptCheckFrame;

public class ReceiptCheckEscapeButton extends JButton implements ActionListener{
	
	ReceiptCheckFrame f;
	RefundButton r;
	OutputButton o;
	
	public ReceiptCheckEscapeButton(ReceiptCheckFrame f, RefundButton r, OutputButton o) {
		this.f = f;
		this.r = r;
		this.o = o;
		
		try {
			// 버튼에 이미지 삽입
			File file = new File("images/PosImages/영수증 조회 이미지/돌아가기 버튼.png");
			BufferedImage bufferedImage = ImageIO.read(file);
			Image scaledImage = bufferedImage.getScaledInstance(180, 80, Image.SCALE_AREA_AVERAGING);
			ImageIcon btnImage = new ImageIcon(scaledImage);
			setIcon(btnImage);
			setSize(180, 80);
			setContentAreaFilled(false);	// 버튼 배경 지우기
			setBorderPainted(false);	// 버튼 테두리 지우기
			setFocusable(false);	
			
			// 버튼 클릭 했을 때 변하는 이미지 삽입
			File f2 = new File("images/PosImages/영수증 조회 이미지/돌아가기 버튼 클릭.png");
			BufferedImage bufferedImage2 = ImageIO.read(f2);
			Image scaledImage2 = bufferedImage2.getScaledInstance(180, 80, Image.SCALE_AREA_AVERAGING);
			ImageIcon btnImage2 = new ImageIcon(scaledImage2);
			setPressedIcon(btnImage2);			
			
			addActionListener(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 뒤로가기 누르면 창 꺼지게
		f.dispose();
		
		// table 초기화
		List table = new List();
		List.contents.setNumRows(0);
		
		// 영수증 출력 창 초기화
		JTextArea a = PrintScroll.p;
		a.setText("");
		
		// 버튼 초기화
		r.setEnabled(false);
		o.setEnabled(false);

		
	}

}
