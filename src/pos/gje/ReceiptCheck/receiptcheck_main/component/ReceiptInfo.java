package pos.gje.ReceiptCheck.receiptcheck_main.component;


public class ReceiptInfo {
	private String menu_name;
	private String menu_option;
	private int menu_qty;
	private int price;
	
	public ReceiptInfo() {}

	
	public ReceiptInfo(String menu_name, String menu_option, int menu_qty, int price){
		this.menu_name = menu_name;
		this.menu_option = menu_option;
		this.menu_qty = menu_qty;
		this.price = price;
		
	}
	public String getMenu_name() {
		return menu_name;
	}
	

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}


	public String getMenu_option() {
		return menu_option;
	}


	public void setMenu_option(String menu_option) {
		this.menu_option = menu_option;
	}


	public int getMenu_qty() {
		return menu_qty;
	}


	public void setMenu_qty(int menu_qty) {
		this.menu_qty = menu_qty;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("%s\t%d\t%d/nㄴ%s/n",menu_name, menu_qty, price, menu_option);
	}


	
	
}
