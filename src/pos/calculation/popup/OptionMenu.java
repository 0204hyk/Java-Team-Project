package pos.calculation.popup;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class OptionMenu {
	
	
	public OptionMenu() {
		JFrame f = new JFrame();
		JPanel optionPanel = new JPanel();
		GridLayout view = new GridLayout(2, 0);
		GridLayout grid = new GridLayout(4, 5);
		JButton complete = new JButton("완료");
		complete.setBounds(400, 430, 100, 150);
		
		JButton[] optionBtns = new JButton[20];
		JTextArea text =  new JTextArea();
		for (int i = 0; i < 20; ++i) {
			optionBtns[i] = new JButton("");
			optionBtns[i].setBounds(150, 150, 250, 150);
			optionPanel.add(optionBtns[i]);
			f.add(optionPanel);
		}
		
		f.add(optionPanel);
		f.add(text);
		f.add(complete);
		f.setLayout(null);
		f.setSize(500, 600);
		f.setLocation(500, 150);
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
		new OptionMenu();
	}
}
