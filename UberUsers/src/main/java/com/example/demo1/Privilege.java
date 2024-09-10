package com.example.demo1;

public class Privilege {
	
	private Integer privilege_id;
	private String user_type;
	private String payment_mode;
	private Integer current_discount;
	
	public Integer getPrivilege_id() {
		return privilege_id;
	}
	public void setPrivilege_id(Integer privilege_id) {
		this.privilege_id = privilege_id;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public Integer getCurrent_discount() {
		return current_discount;
	}
	public void setCurrent_discount(Integer current_discount) {
		this.current_discount = current_discount;
	}

}
