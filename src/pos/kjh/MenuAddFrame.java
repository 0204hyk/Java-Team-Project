package pos.kjh;

import java.awt.Dimension;
import java.awt.Graphics;
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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MenuAddFrame extends JFrame{
	
	JScrollPane scrollPane;
	ImageIcon icon;
	
	public JTextField nameAdd() {
		JTextField menuName = new JTextField();

		menuName.setBounds(190, 115, 700, 49);
		menuName.setOpaque(false);
		menuName.setFont(menuName.getFont().deriveFont(20.0f));
		menuName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		return menuName;
	}
	
	public JTextField priceAdd() {
		JTextField menuPrice = new JTextField();

		menuPrice.setBounds(190, 230, 700, 49);
		menuPrice.setOpaque(false);
		menuPrice.setFont(menuPrice.getFont().deriveFont(20.0f));
		menuPrice.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		return menuPrice;
	}
	
	public JButton fixBtn() throws IOException{
		JButton fixBtn = new JButton();

		BufferedImage bufferedfixBtnImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/메뉴 추가 창 확인 버튼.png"));
		Image fixBtnImage = bufferedfixBtnImage.getScaledInstance(100,50, Image.SCALE_SMOOTH);
		fixBtn.setIcon(new ImageIcon(fixBtnImage));
		fixBtn.setBounds(750,450, 100,50);

		fixBtn.setBorderPainted(false);
		fixBtn.setContentAreaFilled(false);
		fixBtn.setFocusPainted(false);

		BufferedImage bufferedBtnClickImage = ImageIO.read(new File("images/PosImages/상품 관리 이미지/메뉴 추가 창 확인 버튼 클릭.png"));
		Image btnClickImage = bufferedBtnClickImage.getScaledInstance(100,50, Image.SCALE_SMOOTH);
		Icon btnClickIcon = new ImageIcon(btnClickImage);
		
		fixBtn.setPressedIcon(btnClickIcon);
		
		fixBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String addMenu = "INSERT INTO menu VALUES" + nameAdd();
					new AddFix();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
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
		coffee.setBounds(180, 295, 90, 70);
		coffee.setFont(coffee.getFont().deriveFont(20.0f));
		coffee.setBorderPainted(false);
		coffee.setContentAreaFilled(false);
		coffee.setFocusPainted(false);

		JRadioButton nonCoffee = new JRadioButton("Non Coffee");
		nonCoffee.setBounds(280, 295, 140, 70);
		nonCoffee.setFont(coffee.getFont().deriveFont(20.0f));
		nonCoffee.setBorderPainted(false);
		nonCoffee.setContentAreaFilled(false);
		nonCoffee.setFocusPainted(false);

		JRadioButton teaAde = new JRadioButton("Tea, Ade");
		teaAde.setBounds(420, 295, 110, 70);
		teaAde.setFont(coffee.getFont().deriveFont(20.0f));
		teaAde.setBorderPainted(false);
		teaAde.setContentAreaFilled(false);
		teaAde.setFocusPainted(false);

		JRadioButton frappeBlended = new JRadioButton("Frappe, Blended");
		frappeBlended.setBounds(540, 295, 190, 70);
		frappeBlended.setFont(coffee.getFont().deriveFont(20.0f));
		frappeBlended.setBorderPainted(false);
		frappeBlended.setContentAreaFilled(false);
		frappeBlended.setFocusPainted(false);

		categoryBtnGroup.add(frappeBlended);
		categoryBtnGroup.add(teaAde);
		categoryBtnGroup.add(nonCoffee);
		categoryBtnGroup.add(coffee);

		
		
		
		// 옵션 분류
		ButtonGroup optionBtnGroup = new ButtonGroup();

		JRadioButton option1 = new JRadioButton("Coffee");
		coffee.setBounds(180, 295, 90, 70);
		coffee.setFont(coffee.getFont().deriveFont(20.0f));
		coffee.setBorderPainted(false);
		coffee.setContentAreaFilled(false);
		coffee.setFocusPainted(false);

		JRadioButton option2 = new JRadioButton("Non Coffee");
		nonCoffee.setBounds(280, 295, 140, 70);
		nonCoffee.setFont(coffee.getFont().deriveFont(20.0f));
		nonCoffee.setBorderPainted(false);
		nonCoffee.setContentAreaFilled(false);
		nonCoffee.setFocusPainted(false);

		JRadioButton option3 = new JRadioButton("Tea, Ade");
		teaAde.setBounds(420, 295, 110, 70);
		teaAde.setFont(coffee.getFont().deriveFont(20.0f));
		teaAde.setBorderPainted(false);
		teaAde.setContentAreaFilled(false);
		teaAde.setFocusPainted(false);

		JRadioButton option4 = new JRadioButton("Frappe, Blended");
		frappeBlended.setBounds(540, 295, 190, 70);
		frappeBlended.setFont(coffee.getFont().deriveFont(20.0f));
		frappeBlended.setBorderPainted(false);
		frappeBlended.setContentAreaFilled(false);
		frappeBlended.setFocusPainted(false);

		categoryBtnGroup.add(frappeBlended);
		categoryBtnGroup.add(teaAde);
		categoryBtnGroup.add(nonCoffee);
		categoryBtnGroup.add(coffee);
		
		
		
		
		
		
		icon = new ImageIcon("images/PosImages/상품 관리 이미지/메뉴 추가 창 기본 틀.png");

		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(icon.getImage(), 0, 0, d.width, d.height,null);
				setOpaque(false); 
				super.paintComponent(g);
			}
		};

		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);
		

		background.add(fixBtn());
		background.setBounds(0, 0, 900, 550);


		add(close());
		add(priceAdd());
		add(nameAdd());
		add(frappeBlended);
		add(teaAde);
		add(nonCoffee);
		add(coffee);
		add(background);


		background.setLayout(null);
		
		setLayout(null);
		setUndecorated(true);
		setResizable(false);
		setSize(900, 550);
		setLocationRelativeTo(null);
		setVisible(true);

	}



	public static void main(String[] args) throws IOException {
		new MenuAddFrame();
	}
}
