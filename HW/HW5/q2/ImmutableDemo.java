package com.java.HW3.q2;

import java.util.ArrayList;
import java.util.List;

public class ImmutableDemo {
	public static void main(String[] args) {
		ArrayList<String> address=new ArrayList<>();
		address.add("Chicao");
		address.add("New York");
		PersonImmutable person=new PersonImmutable(1,"cai",address);
		
		int id=person.getId();
		id=2;
		ArrayList<String> address2=(ArrayList<String>) person.getAddress();
		address2.set(1, "Washinton");
		
		System.out.println(person.id);  //1
		System.out.println(person.getAddress().get(1));  //NewYork

	}
}
final class PersonImmutable {
	final int id;
	final String name;
	final List<String> address;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<String> getAddress() {
		List<String> addressCopy=new ArrayList<String>();
		for(String s:address) {
			addressCopy.add(s);
		}
		return addressCopy;
	}

	public PersonImmutable(int id, String name, List<String> address) {
		super();
		this.id = id;
		this.name = name;
		this.address=new ArrayList<String>();
		for(String s:address) {			
			this.address.add(s);
		}
	}
	
}
