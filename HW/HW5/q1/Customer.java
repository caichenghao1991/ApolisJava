package com.java.HW3.q1;

import java.util.HashMap;

public class Customer {
	private int id;
	private String name;
	private String mobile;
	private String email;
	private String username;
	private String password;
	private String address;
	static BankService bankService=new BankService();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", username="
				+ username + ", password=" + password + ", address=" + address + "]";
	}
	public Customer(int id, String name, String mobile, String email, String username, String password,
			String address) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.username = username;
		this.password = password;
		this.address = address;
	}
	
	public static boolean addCustomer(int id, String name, String mobile, String email, String username, String password,
			String address) {
		if(bankService.getCustomerByID(id)!=null) {
			System.out.println("Customer already exist");
			return false;
		}else {		
			Customer cust=new Customer(id, name, mobile, email, username, password, address);
			System.out.print("Account added:");
			System.out.println(cust.toString());	
			return true;
		}
		
	}
	
	
	
}
