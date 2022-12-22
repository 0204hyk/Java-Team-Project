package pos.product_management.menu02_add.panel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import pos.product_management.menu01_main.ProductManagementJFrame;
import pos.product_management.menu02_add.MenuAddFrame;
import pos.product_management.menu02_add.component.MenuAddButton;
import pos.product_management.menu02_add.message_frame.AddFix;
import pos.product_management.menu02_add.message_frame.MenuNameInput;

public class AddBackgroundImagePanel extends JPanel{
	
	ProductManagementJFrame mainFrame;
	MenuAddFrame frame;
	
	public JTextField nameField;
	public JFormattedTextField priceField;
	
	public JRadioButton coffee;
	public JRadioButton nonCoffee;
	public JRadioButton ade;
	public JRadioButton frappe;
	 
	public JRadioButton option1;
	public JRadioButton option2;
	public JRadioButton option3;
	public JRadioButton option4;
	public JRadioButton option5;
	public JRadioButton option6;
	public JRadioButton option7;		
	public JRadioButton option8;		


	
	public void paintComponent(Graphics g) {
		Dimension d = getSize();
		ImageIcon image = new ImageIcon
				("images/PosImages/상품 관리 이미지/메뉴 추가 창 기본 틀.png");
		g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
	}
	
	public AddBackgroundImagePanel(ProductManagementJFrame mainFrame, MenuAddFrame frame) {
		this.mainFrame = mainFrame;
		this.frame = frame;
		
		setLayout(null); 
		setSize(900, 550);
		
		nameField = new JTextField();
		nameField.setBounds(190, 105, 700, 49);
		nameField.setOpaque(false);
		nameField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		nameField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		priceField = new JFormattedTextField(new NumberFormatter());
		priceField.setBounds(190, 213, 700, 49);
		priceField.setOpaque(false);
		priceField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		priceField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		
		// 카테고리 분류
		ButtonGroup categoryBtnGroup = new ButtonGroup();

		coffee = new JRadioButton("Coffee");
		coffee.setBounds(180, 290, 90, 70);
		coffee.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		coffee.setBorderPainted(false);
		coffee.setContentAreaFilled(false);
		coffee.setFocusPainted(false);
		coffee.setSelected(true);

		nonCoffee = new JRadioButton("Non Coffee");
		nonCoffee.setBounds(280, 290, 140, 70);
		nonCoffee.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		nonCoffee.setBorderPainted(false);
		nonCoffee.setContentAreaFilled(false);
		nonCoffee.setFocusPainted(false);

		ade = new JRadioButton("Ade");
		ade.setBounds(450, 290, 110, 70);
		ade.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		ade.setBorderPainted(false);
		ade.setContentAreaFilled(false);
		ade.setFocusPainted(false);

		frappe = new JRadioButton("Frappe");
		frappe.setBounds(540, 290, 190, 70);
		frappe.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		frappe.setBorderPainted(false);
		frappe.setContentAreaFilled(false);
		frappe.setFocusPainted(false);

		categoryBtnGroup.add(frappe);
		categoryBtnGroup.add(ade);
		categoryBtnGroup.add(nonCoffee);
		categoryBtnGroup.add(coffee);
		
		
		// 옵션 분류
		ButtonGroup optionBtnGroup = new ButtonGroup();
		
		option1 = new JRadioButton("모든 옵션");
		option1.setBounds(180, 370, 150, 35);
		option1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		option1.setBorderPainted(false);
		option1.setContentAreaFilled(false);
		option1.setFocusPainted(false);
		option1.setSelected(true);

		option2 = new JRadioButton("우유 X");
		option2.setBounds(180, 400, 150, 35);
		option2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		option2.setBorderPainted(false);
		option2.setContentAreaFilled(false);
		option2.setFocusPainted(false);

		option3 = new JRadioButton("Ice Only");
		option3.setBounds(180, 430, 150, 35);
		option3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		option3.setBorderPainted(false);
		option3.setContentAreaFilled(false);
		option3.setFocusPainted(false);

		option4 = new JRadioButton("Ice Only, 우유 X");
		option4.setBounds(330, 370, 180, 35);
		option4.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		option4.setBorderPainted(false);
		option4.setContentAreaFilled(false);
		option4.setFocusPainted(false);
		
		option5 = new JRadioButton("샷, 사이즈");
		option5.setBounds(330, 400, 150, 35);
		option5.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		option5.setBorderPainted(false);
		option5.setContentAreaFilled(false);
		option5.setFocusPainted(false);
		
		option6 = new JRadioButton("디카페인, 샷, 사이즈");
		option6.setBounds(330, 430, 210, 35);
		option6.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		option6.setBorderPainted(false);
		option6.setContentAreaFilled(false);
		option6.setFocusPainted(false);
		
		option7 = new JRadioButton("디카페인 X");
		option7.setBounds(550, 370, 150, 35);
		option7.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		option7.setBorderPainted(false);
		option7.setContentAreaFilled(false);
		option7.setFocusPainted(false);		
		
		option8 = new JRadioButton("Ice Only, 샷, 사이즈");
		option8.setBounds(550, 400, 210, 35);
		option8.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		option8.setBorderPainted(false);
		option8.setContentAreaFilled(false);
		option8.setFocusPainted(false);		

		optionBtnGroup.add(option1);
		optionBtnGroup.add(option2);
		optionBtnGroup.add(option3);
		optionBtnGroup.add(option4);
		optionBtnGroup.add(option5);
		optionBtnGroup.add(option6);
		optionBtnGroup.add(option7);
		optionBtnGroup.add(option8);
		
		try {
			MenuAddButton menuAddBtn = new MenuAddButton(frame, this, new AddFix(mainFrame, frame));
			
			JButton closeBtn = new JButton();
			BufferedImage bufferedcloseBtnImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/닫기 버튼.png"));
			Image closeBtnImage = bufferedcloseBtnImage.getScaledInstance(50,50, Image.SCALE_SMOOTH);
			closeBtn.setIcon(new ImageIcon(closeBtnImage));
			closeBtn.setBounds(840,10,50,50);
			closeBtn.setBorderPainted(false);
			closeBtn.setContentAreaFilled(false);
			closeBtn.setFocusPainted(false);
			closeBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					mainFrame.addBtn.setEnabled(true);
					mainFrame.setEnabled(true);
					frame.dispose();
				}
			});

			add(closeBtn);
			add(menuAddBtn);	
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		add(nameField);
		add(priceField);
		add(coffee);
		add(nonCoffee);
		add(ade);
		add(frappe);
		add(option1);
		add(option2);
		add(option3);
		add(option4);
		add(option5);
		add(option6);
		add(option7);
		add(option8);
		
	}

}
