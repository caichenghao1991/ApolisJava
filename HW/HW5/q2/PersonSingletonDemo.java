package com.java.HW3.q2;

import java.util.ArrayList;
import java.util.List;

public class PersonSingletonDemo {
	public static void main(String[] args) {
		ArrayList<String> address=new ArrayList<>();
		address.add("Chicao");
		address.add("New York");
	    PersonSingleton person= PersonSingleton.getInstance(1,"cai",address);
	    PersonSingleton person2= PersonSingleton.getInstance(2,"cai",address);	   	    
	    System.out.println(person==person2);  //true
	}
}
class PersonSingleton{
	private int id;
	private String name;
	private List<String> address;
	public static  PersonSingleton person;
	
	private PersonSingleton(int id, String name, List<String> address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public static PersonSingleton getInstance(int id, String name, List<String> address){
	    	if(person==null) {
	    		person=new PersonSingleton(id,name,address);
	    	}
	        return person;
	    }

	@Override
	public String toString() {
		return "PersonSingleton [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
}
