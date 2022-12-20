package pos.gje.ReceiptCheck.receiptcheck_main;


import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

 // 패널에 스크롤 test

public class Test1 {

 JFrame frame;
 JPanel jp_label, jp_btn;
 JScrollPane scroll;
 JLabel label;
 JButton btn ;
 int count =1;
 GridBagLayout Gbag = new GridBagLayout();
 GridBagConstraints gbc1;
 
	 Test1(){

	  frame = new JFrame();
	  frame.setLayout(null);    // 레이아웃을 NULL로 설정한다
	  frame.setSize(250,200);

	 

	  jp_label = new JPanel();

	  // 라벨이 들어갈 panel 은 레이아웃을 GridBag을 사용한다.
	  jp_label.setLayout(Gbag);  

	  jp_label.setBackground(Color.green);

	  label = new JLabel("0");
	  create_form(label, 0,0,30,10);  // GridBagLayout 을 위한 함수호출

	 

	  scroll = new JScrollPane(jp_label);  // 스크롤패널을 선언
	  scroll.setBounds(0,0,160,160);    // 프레임에 스크롤패널의 위치를 정한다

	 

	  jp_btn = new JPanel();   // 버튼 패널
	  jp_btn.setBounds(160,0,80,80);
	  btn = new JButton("add");  // 버튼 생성
	  btn.addActionListener(new Add());
	  jp_btn.add(btn);

	 

	  frame.add(scroll);   // 스크롤패널 추가
	  frame.add(jp_btn);  // 버튼 패널 추가 

	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setVisible(true);

	}

	// 버튼 리스너

	class Add implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
	       JLabel label1 = new JLabel(""+count);
	       JLabel label2 = new JLabel(""+count);
	       create_form(label1,count*30, 0,30,10);
	       create_form(label2,0,count++*30,30,10);

	  }

	}

	// 라벨 추가 

	public void create_form(Component cmpt, int x, int y, int w, int h){

	  GridBagConstraints gbc = new GridBagConstraints();
	  gbc.fill = GridBagConstraints.BOTH;
	  gbc.gridx = x;
	  gbc.gridy = y;
	  gbc.gridwidth = w;
	  gbc.gridheight = h;
	  this.Gbag.setConstraints(cmpt, gbc);
	  jp_label.add(cmpt);
	  jp_label.updateUI();

	}

	 public static void main(String[] args) {
		 Test1 bar = new  Test1();
	 }

	
}
	
