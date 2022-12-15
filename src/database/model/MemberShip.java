package database.model;

import java.sql.Date;

public class MemberShip {

	String member_phonenumber;
	Integer member_point;
	Date member_join;
	
	
	public MemberShip() {
	}


	public String getMember_phonenumber() {
		return member_phonenumber;
	}


	public void setMember_phonenumber(String member_phonenumber) {
		this.member_phonenumber = member_phonenumber;
	}


	public Integer getMember_point() {
		return member_point;
	}


	public void setMember_point(Integer member_point) {
		this.member_point = member_point;
	}


	public Date getMember_join() {
		return member_join;
	}


	public void setMember_join(Date member_join) {
		this.member_join = member_join;
	}
	
	
}
