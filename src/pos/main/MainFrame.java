package pos.main;

import java.awt.Color;

import javax.swing.JFrame;

import pos.main.component.CalculationButton;
import pos.main.component.ClosingButton;
import pos.main.component.ExitButton;
import pos.main.component.ProductManagementButton;
import pos.main.component.ReceiptCheckButton;
import pos.main.component.SalesSummaryButton;

public class MainFrame extends JFrame {
	public MainFrame() {
		
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
		
		ExitButton exitBtn = new ExitButton();
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
