package database.model;

public class Menu {

	Integer menu_number;
	String menu_name;
	Integer category_number;
	Integer option_category_number;
	Integer price;
	

	public Menu() {
		
	}


	public Integer getMenu_number() {
		return menu_number;
	}


	public void setMenu_number(Integer menu_number) {
		this.menu_number = menu_number;
	}


	public String getMenu_name() {
		return menu_name;
	}


	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}


	public Integer getCategory_number() {
		return category_number;
	}


	public void setCategory_number(Integer category_number) {
		this.category_number = category_number;
	}


	public Integer getOption_category_number() {
		return option_category_number;
	}


	public void setOption_category_number(Integer option_category_number) {
		this.option_category_number = option_category_number;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
	
}
