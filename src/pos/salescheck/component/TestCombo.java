package pos.salescheck.component;

import java.util.ArrayList;

import javax.swing.JComboBox;

public class TestCombo extends JComboBox {

	
	public TestCombo() {
		ArrayList<String> year = new ArrayList<>();
		String date[] = {"사과", "포도"};
		
		
		add(new JComboBox(date));
		setBounds(100, 100, 50, 50);
		
		
	}
}
