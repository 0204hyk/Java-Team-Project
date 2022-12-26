package kiosk.menupan;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import database.kiosk.GetImageInfo;
import kiosk.byoption.All_1;
import kiosk.byoption.NoDecaf_7;
import kiosk.byoption.NoHotMilk_4;
import kiosk.byoption.NoHot_3;
import kiosk.byoption.NoMilk_2;
import kiosk.byoption.OnlyDecafShotCup_6;
import kiosk.byoption.OnlyShotCup_5;
import kiosk.byoption.OnlyShotIceCup_8;
import kiosk.byoption.TopImage;
import kiosk.tools.WithImage;

public class MakeMenuButton extends JButton implements ActionListener {
	DecimalFormat df = new DecimalFormat("#,###");

	String menu;
	int optionNum;
	Options frame;
	
	public MakeMenuButton(int ctgNum, int optionNum, String menu, int x, int y) {
	      this.optionNum = optionNum;
	      this.menu = menu;

	      String root = "";
	      if (ctgNum == 1) {
	         setIcon(new ImageIcon("images/KioskImages/menu/defaultimage.png"));
	         GetImageInfo gi = new GetImageInfo(menu);
	         JLabel price = new JLabel("￦" + df.format(gi.getMenuPrice()));
	         price.setHorizontalAlignment(JLabel.CENTER);
	         add(price);
	         setLayout(null);
	         setBounds(x, y, 155, 155);
	         setBorderPainted(false);
		     setContentAreaFilled(false);
	         setVisible(true);
	         addActionListener(this);

	      }else {
	         
	      if (ctgNum == 2) {
	         root = "images/KioskImages/menu/coffee ";
	      } else if (ctgNum == 3) {
	         root = "images/KioskImages/menu/frappe ";
	      } else if (ctgNum == 4) {
	         root = "images/KioskImages/menu/noncoffee ";
	      } else if (ctgNum == 5) {
	         root = "images/KioskImages/menu/ade ";
	      } 
	      

	      WithImage wi = new WithImage(root);
	      GetImageInfo gi = new GetImageInfo(menu);

	      JLabel price = new JLabel("￦" + df.format(gi.getMenuPrice()));
	      price.setBounds(48, 131, 57, 16);
	      price.setFont(new Font("맑은 고딕", Font.BOLD, 15));
	      price.setForeground(new Color(15, 11, 65));
	      price.setHorizontalAlignment(JLabel.CENTER);
	      add(price);

	      setLayout(null);
	      setIcon(new ImageIcon(wi.readImage(root + "unselected/" + menu + ".png", 155, 155)));
	      setBounds(x, y, 155, 155);
	      setBorderPainted(false);
	      setContentAreaFilled(false);
	      setPressedIcon(new ImageIcon(wi.readImage(root + "selected/" + menu + ".png", 155, 155)));
	      setVisible(true);
	      addActionListener(this);

	      }
	   }

	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (optionNum == 1) {
			new All_1(new TopImage(menu), menu);
		} else if (optionNum == 2) {
			new NoMilk_2(new TopImage(menu), menu);
		} else if (optionNum == 3) {
			new NoHot_3(new TopImage(menu), menu);
		} else if (optionNum == 4) {
			new NoHotMilk_4(new TopImage(menu), menu);
		} else if (optionNum == 5) {
			new OnlyShotCup_5(new TopImage(menu), menu);
		} else if (optionNum == 6) {
			new OnlyDecafShotCup_6(new TopImage(menu), menu);
		} else if (optionNum == 7) {
			new NoDecaf_7(new TopImage(menu), menu);
		} else if (optionNum == 8) {
			new OnlyShotIceCup_8(new TopImage(menu), menu);
		}
	}

}
