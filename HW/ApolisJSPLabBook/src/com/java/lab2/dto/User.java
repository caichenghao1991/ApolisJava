package com.java.lab2.dto;


public class User {

	Integer custId;
	String username;
	String address;
	public User(Integer custId, String username, String address) {
		super();
		this.custId = custId;
		this.username = username;
		this.address = address;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [custId=" + custId + ", username=" + username + ", address=" + address + "]";
	} 
	
	
}