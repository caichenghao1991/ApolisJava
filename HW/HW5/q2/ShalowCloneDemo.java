package com.java.HW3.q2;

import java.util.ArrayList;
import java.util.List;

public class ShalowCloneDemo{
	public static void main(String[] args) throws CloneNotSupportedException {
		ArrayList<String> address=new ArrayList<>();
		address.add("Chicao");
		address.add("New York");
		PersonShalowClone p1=new PersonShalowClone(1,"cai",address);
		PersonShalowClone p2=p1.clone();
		System.out.println(p1.getAddress()==p2.getAddress()); //true;
	}
	
}

class PersonShalowClone implements Cloneable{
	private int id;
	private String name;
	private List<String> address;

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

	public List<String> getAddress() {
		return address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}

	public PersonShalowClone(int id, String name, List<String> address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public PersonShalowClone clone() throws CloneNotSupportedException {
		PersonShalowClone p1= (PersonShalowClone) super.clone();//shalow copy		
		return p1;
	}
	
}
