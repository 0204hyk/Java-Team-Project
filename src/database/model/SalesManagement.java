package database.model;

public class SalesManagement {

	Integer sales_number;
	Integer menu_number;
	Integer option_number;
	Integer product_qty;
	Integer total_price;
	
	
	public SalesManagement() {
		
	}


	public Integer getSales_number() {
		return sales_number;
	}


	public void setSales_number(Integer sales_number) {
		this.sales_number = sales_number;
	}


	public Integer getMenu_number() {
		return menu_number;
	}


	public void setMenu_number(Integer menu_number) {
		this.menu_number = menu_number;
	}


	public Integer getOption_number() {
		return option_number;
	}


	public void setOption_number(Integer option_number) {
		this.option_number = option_number;
	}


	public Integer getProduct_qty() {
		return product_qty;
	}


	public void setProduct_qty(Integer product_qty) {
		this.product_qty = product_qty;
	}


	public Integer getTotal_price() {
		return total_price;
	}


	public void setTotal_price(Integer total_price) {
		this.total_price = total_price;
	}
	
	
}
