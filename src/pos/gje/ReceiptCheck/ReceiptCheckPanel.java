package pos.gje.ReceiptCheck;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ReceiptCheckPanel extends JPanel{
	JScrollPane scrollPane; 
    ImageIcon icon;
	  
	  public ReceiptCheckPanel() {
		  icon = new ImageIcon("src/receiptImages/날짜별 영수증 리스트 기본 틀.png");
	       
	        //배경 Panel 생성후 컨텐츠페인으로 지정      
	        JPanel background = new JPanel() {
	            public void paintComponent(Graphics g) {
	                // Approach 1: Dispaly image at at full size
	                g.drawImage(icon.getImage(), 0, 0, null);
	                // Approach 2: Scale image to size of component
	                // Dimension d = getSize();
	                // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
	                // Approach 3: Fix the image position in the scroll pane
	                // Point p = scrollPane.getViewport().getViewPosition();
	                // g.drawImage(icon.getImage(), p.x, p.y, null);
	                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
	                super.paintComponent(g);
	            }
	        };
	       
	       
	       
	        JButton button = new JButton("버튼");
	        background.add(button);
	        scrollPane = new JScrollPane(background);
	        //setContentPane(scrollPane);
			setLayout(null);
			setBounds(75, 80, 500, 550);		
			setBackground(Color.white);
	  }
	  
	public static JPanel listPanel() {
		
		
		// 메인 Panel
	    
	    
		JPanel listPanel = new JPanel();
		
		// 리스트 번호들
		
		// 영수증 리스트
		
		// 기본 틀
		
		
		
		

		
		

		
		// 패널의 레이아웃 설정
		listPanel.setLayout(null);
		listPanel.setBounds(75, 80, 500, 550);		
		listPanel.setBackground(Color.white);
		
		
		return listPanel;
	}
	

	

}
