package com.java.dto;

import java.time.LocalDate;

public class User {

	String username;
	String password;
	String address;
	Gender gender;
	String phone;
	LocalDate dob;
	
	
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
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getAddres() {
		return address;
	}
	public void setAddres(String address) {
		this.address = address;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", address=" + address + ", gender=" + gender
				+ ", phone=" + phone + ", dob=" + dob + "]";
	}
	
	
}

