package database.model;

public class Payment {

	
	Integer sales_number;
	Integer payment_type;
	Integer price;
	
	public Payment() {
		
	}

	public Integer getSales_number() {
		return sales_number;
	}

	public void setSales_number(Integer sales_number) {
		this.sales_number = sales_number;
	}

	public Integer getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(Integer payment_type) {
		this.payment_type = payment_type;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
