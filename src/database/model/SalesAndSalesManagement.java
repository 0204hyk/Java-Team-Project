package database.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesAndSalesManagement {

	private Integer sales_number;
	private String member_phonenumber;
	private Date saleDate;
	private Integer menu_number;
	private Integer option_number;
	private Integer product_qty;
	private Integer total_price;
	
	
	public SalesAndSalesManagement(ResultSet rs) throws SQLException {
		sales_number = rs.getInt(1);
		member_phonenumber = rs.getString(2);
		saleDate = rs.getDate(3);
		menu_number = rs.getInt(4);
		option_number = rs.getInt(5);
		product_qty = rs.getInt(6);
		total_price = rs.getInt(7);
	}
	


	public Integer getSales_number() {
		return sales_number;
	}


	public void setSales_number(Integer sales_number) {
		this.sales_number = sales_number;
	}


	public String getMember_phonenumber() {
		return member_phonenumber;
	}


	public void setMember_phonenumber(String member_phonenumber) {
		this.member_phonenumber = member_phonenumber;
	}


	public Date getSaleDate() {
		return saleDate;
	}


	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
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
