package com.java.HW3.q2;

import java.util.ArrayList;
import java.util.List;

public class DeepCloneDemo{
	public static void main(String[] args) throws CloneNotSupportedException {
		ArrayList<String> address=new ArrayList<>();
		address.add("Chicao");
		address.add("New York");
		PersonDeepClone p1=new PersonDeepClone(1,"cai",address);
		PersonDeepClone p2=p1.clone();
		System.out.println(p1.getAddress()==p2.getAddress()); //false;
	}
	
}

class PersonDeepClone implements Cloneable{
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

	public PersonDeepClone(int id, String name, List<String> address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public PersonDeepClone clone() throws CloneNotSupportedException {
		PersonDeepClone p1= (PersonDeepClone) super.clone();
		if(this.address!=null) {
			p1.address=new ArrayList<String>();
			for(String s:this.address) {
				p1.address.add(s);
			}
			
		}
		return p1;
	}
	
}
