package pos.calculation.popup;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class OptionMenu extends JFrame {
	
	
	public OptionMenu() {
	

		JPanel optionPanel = new JPanel();
		optionPanel.setBounds(0, 0, 600, 500);
		JPanel textPanel = new JPanel();
		JTextArea text = new JTextArea();
		text.setBounds(200, 200, 200, 200);
		textPanel.add(text);
		JButton[] optionBtns = new JButton[20];
		for (int i = 0; i < 20; ++i) {
			optionBtns[i] = new JButton("");
			optionBtns[i].setBounds(0, 0, 150, 100);
			optionPanel.add(optionBtns[i]);
		
		}
		
		
		add(optionPanel);
		add(textPanel);
		setLayout(new GridLayout(2, 0));
		setSize(600, 600);
		setLocation(500, 150);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new OptionMenu();
	}
}
