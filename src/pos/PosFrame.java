package pos;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JFrame;

import pos.kjh.TeamInfoFrame;
import pos.main.exit_message.ExitMessageFrame;
import pos.main.main_component.ClosingButton;
import pos.main.main_component.ExitButton;
import pos.main.main_component.ProductManagementButton;
import pos.main.main_component.ReceiptCheckButton;
import pos.main.main_component.SalesSummaryButton;
import pos.main.main_component.TeamInfoButton;

public class PosFrame extends JFrame {
	
	public PosFrame() {
		
		TeamInfoButton TeamInfoBtn = new TeamInfoButton();
		TeamInfoBtn.setLocation(115, 175);
		
		ReceiptCheckButton receiptCheckBtn = new ReceiptCheckButton();
		receiptCheckBtn.setLocation(515, 405);
		
		ProductManagementButton productManagementBtn = new ProductManagementButton();
		productManagementBtn.setLocation(515, 115);
		
		SalesSummaryButton salesSummaryBtn = new SalesSummaryButton();
		salesSummaryBtn.setLocation(805, 405);
		
		ClosingButton closingBtn = new ClosingButton();
		closingBtn.setLocation(805, 115);
		
		ExitMessageFrame exitFrame = new ExitMessageFrame();
		ExitButton exitBtn = new ExitButton(exitFrame);
		exitBtn.setLocation(1125, 10);
		
		add(TeamInfoBtn);
		add(receiptCheckBtn);
		add(productManagementBtn);
		add(salesSummaryBtn);
		add(closingBtn);
		add(exitBtn);
		
		setUndecorated(true);
		setTitle("POS 메인화면");
		setSize(1200, 800);
		getContentPane().setBackground(new Color(64, 64, 64));	// 프레임 백그라운드 컬러 설정
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}
}
