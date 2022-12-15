package database.model;

import java.sql.Date;

public class Sales {

	
	Integer sales_number;
	String member_phonenumber;
	Date saleDate;
	
	public Sales() {
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
	
	
}
