package pos.kjh;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

import pos.ImagePanel;
import pos.ImageScaledTool;

public class MenuAddFrame extends JFrame{
	
	JScrollPane scrollPane;
	ImageIcon icon;
	JTextField nameField = nameAdd();
	JFormattedTextField priceField = priceAdd();
	AddFix addfix = new AddFix(this);
	
	public JTextField nameAdd() {
		JTextField menuName = new JTextField();

		menuName.setBounds(190, 105, 700, 49);
		menuName.setOpaque(false);
		menuName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		menuName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		return menuName;
	}
	
	// 숫자만 입력 받는 텍스트 필드
	public JFormattedTextField priceAdd() {
		JFormattedTextField menuPrice = new JFormattedTextField(new NumberFormatter());
				
		menuPrice.setBounds(190, 213, 700, 49);
		menuPrice.setOpaque(false);
		menuPrice.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		menuPrice.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		return menuPrice;
	}
	
	public JButton fixBtn() throws IOException{
		JButton fixBtn = new JButton();
		
		BufferedImage bufferedfixBtnImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/메뉴 추가 창 확인 버튼.png"));
		Image fixBtnImage = bufferedfixBtnImage.getScaledInstance(150,75, Image.SCALE_SMOOTH);
		fixBtn.setIcon(new ImageIcon(fixBtnImage));
		fixBtn.setBounds(720, 450, 150, 75);

		fixBtn.setBorderPainted(false);
		fixBtn.setContentAreaFilled(false);
		fixBtn.setFocusPainted(false);

		BufferedImage bufferedBtnClickImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/메뉴 추가 창 확인 버튼 클릭.png"));
		Image btnClickImage = bufferedBtnClickImage.getScaledInstance(150,75, Image.SCALE_SMOOTH);
		Icon btnClickIcon = new ImageIcon(btnClickImage);
		
		fixBtn.setPressedIcon(btnClickIcon);
		
		fixBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String addMenu = "INSERT INTO menu VALUES";
				addfix.setVisible(true);
			}
		});

		return fixBtn;
	}
	
	public JButton close() throws IOException {
		
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
				dispose();
			}
		});

		return closeBtn;
	}


	public MenuAddFrame() throws IOException {
		
		// 카테고리 분류
		ButtonGroup categoryBtnGroup = new ButtonGroup();

		JRadioButton coffee = new JRadioButton("Coffee");
		coffee.setBounds(180, 290, 90, 70);
		coffee.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		coffee.setBorderPainted(false);
		coffee.setContentAreaFilled(false);
		coffee.setFocusPainted(false);
		coffee.setSelected(true);

		JRadioButton nonCoffee = new JRadioButton("Non Coffee");
		nonCoffee.setBounds(280, 290, 140, 70);
		nonCoffee.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		nonCoffee.setBorderPainted(false);
		nonCoffee.setContentAreaFilled(false);
		nonCoffee.setFocusPainted(false);

		JRadioButton teaAde = new JRadioButton("Tea, Ade");
		teaAde.setBounds(420, 290, 110, 70);
		teaAde.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		teaAde.setBorderPainted(false);
		teaAde.setContentAreaFilled(false);
		teaAde.setFocusPainted(false);

		JRadioButton frappeBlended = new JRadioButton("Frappe, Blended");
		frappeBlended.setBounds(540, 290, 190, 70);
		frappeBlended.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		frappeBlended.setBorderPainted(false);
		frappeBlended.setContentAreaFilled(false);
		frappeBlended.setFocusPainted(false);

		categoryBtnGroup.add(frappeBlended);
		categoryBtnGroup.add(teaAde);
		categoryBtnGroup.add(nonCoffee);
		categoryBtnGroup.add(coffee);
		
		
		// 옵션 분류
		ButtonGroup optionBtnGroup = new ButtonGroup();
		JRadioButton option1 = new JRadioButton("모든 옵션");
		option1.setBounds(180, 370, 150, 35);
		option1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		option1.setBorderPainted(false);
		option1.setContentAreaFilled(false);
		option1.setFocusPainted(false);
		option1.setSelected(true);

		JRadioButton option2 = new JRadioButton("우유 X");
		option2.setBounds(180, 400, 150, 35);
		option2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		option2.setBorderPainted(false);
		option2.setContentAreaFilled(false);
		option2.setFocusPainted(false);

		JRadioButton option3 = new JRadioButton("Ice Only");
		option3.setBounds(180, 430, 150, 35);
		option3.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		option3.setBorderPainted(false);
		option3.setContentAreaFilled(false);
		option3.setFocusPainted(false);

		JRadioButton option4 = new JRadioButton("Ice Only, 우유 X");
		option4.setBounds(330, 370, 180, 35);
		option4.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		option4.setBorderPainted(false);
		option4.setContentAreaFilled(false);
		option4.setFocusPainted(false);
		
		JRadioButton option5 = new JRadioButton("샷, 사이즈");
		option5.setBounds(330, 400, 150, 35);
		option5.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		option5.setBorderPainted(false);
		option5.setContentAreaFilled(false);
		option5.setFocusPainted(false);
		
		JRadioButton option6 = new JRadioButton("디카페인, 샷, 사이즈");
		option6.setBounds(330, 430, 210, 35);
		option6.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		option6.setBorderPainted(false);
		option6.setContentAreaFilled(false);
		option6.setFocusPainted(false);
		
		JRadioButton option7 = new JRadioButton("디카페인 X");
		option7.setBounds(550, 370, 150, 35);
		option7.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		option7.setBorderPainted(false);
		option7.setContentAreaFilled(false);
		option7.setFocusPainted(false);		
		
		JRadioButton option8 = new JRadioButton("Ice Only, 샷, 사이즈");
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

		JPanel background = new ImagePanel(ImageScaledTool.getScaledImage(
				"images/PosImages/상품 관리 이미지/메뉴 추가 창 기본 틀.png", 900, 550));
		
		background.add(fixBtn());	
		add(background);
		background.setSize(900, 550);
		
		
		add(close());
		add(nameField);
		add(priceField);
		add(frappeBlended);
		add(teaAde);
		add(nonCoffee);
		add(coffee);
		add(option1);
		add(option2);
		add(option3);
		add(option4);
		add(option5);
		add(option6);
		add(option7);
		add(option8);
		add(background);
		
		setLayout(null);
		setUndecorated(true);
		setResizable(false);
		setBackground(new Color(0, 0, 0, 0));	// 패널 배경 투명하게 하기
		setSize(900, 550);
		setLocationRelativeTo(null);
		setVisible(true);

	}



	public static void main(String[] args) throws IOException {
		new MenuAddFrame();
	}
}
