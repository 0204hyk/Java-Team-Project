package pos;

import java.awt.Color;

import javax.swing.JFrame;

import pos.main.exit_message.ExitMessageFrame;
import pos.main.main_component.CalculationButton;
import pos.main.main_component.ClosingButton;
import pos.main.main_component.ExitButton;
import pos.main.main_component.ProductManagementButton;
import pos.main.main_component.ReceiptCheckButton;
import pos.main.main_component.SalesSummaryButton;

public class PosFrame extends JFrame {
	
	public PosFrame() {
		
		CalculationButton calculationBtn = new CalculationButton();
		calculationBtn.setLocation(105, 155);
		
		ReceiptCheckButton receiptCheckBtn = new ReceiptCheckButton();
		receiptCheckBtn.setLocation(515, 395);
		
		ProductManagementButton productManagementBtn = new ProductManagementButton();
		productManagementBtn.setLocation(515, 105);
		
		SalesSummaryButton salesSummaryBtn = new SalesSummaryButton();
		salesSummaryBtn.setLocation(805, 395);
		
		ClosingButton closingBtn = new ClosingButton();
		closingBtn.setLocation(805, 105);
		
		ExitMessageFrame exitFrame = new ExitMessageFrame();
		ExitButton exitBtn = new ExitButton(exitFrame);
		exitBtn.setLocation(1125, 10);
		
		add(calculationBtn);
		add(receiptCheckBtn);
		add(productManagementBtn);
		add(salesSummaryBtn);
		add(closingBtn);
		add(exitBtn);
		
		setTitle("POS 메인화면");
		setSize(1200, 800);
		getContentPane().setBackground(new Color(64, 64, 64));	// 프레임 백그라운드 컬러 설정
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}
