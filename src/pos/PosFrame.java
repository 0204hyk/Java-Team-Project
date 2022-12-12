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
		calculationBtn.setLocation(95, 70);
		
		ReceiptCheckButton receiptCheckBtn = new ReceiptCheckButton();
		receiptCheckBtn.setLocation(445, 70);
		
		ProductManagementButton productManagementBtn = new ProductManagementButton();
		productManagementBtn.setLocation(795, 70);
		
		SalesSummaryButton salesSummaryBtn = new SalesSummaryButton();
		salesSummaryBtn.setLocation(95, 400);
		
		ClosingButton closingBtn = new ClosingButton();
		closingBtn.setLocation(445, 400);
		
		ExitMessageFrame messageFrame = new ExitMessageFrame();
		ExitButton exitBtn = new ExitButton(messageFrame);
		exitBtn.setLocation(795, 400);
		
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
