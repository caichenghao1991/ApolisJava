package com.java.HW3.q2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class PersonSortHashDemo {
	public static void main(String[] args) {
		ArrayList<String> address=new ArrayList<>();
		address.add("Chicao");
		address.add("New York");
		Set<PersonSortHash> set= new TreeSet<>();//Set -> SortedSet -> TreeSet
		set.add(new PersonSortHash(1,"hao",address));
		set.add(new PersonSortHash(2,"cai",address));
		set.add(new PersonSortHash(5,"cai",address));
		set.add(new PersonSortHash(3,"kai",address));
		System.out.println(set);  // 2 cai    1 hao  3 kai		
	}	
}
class PersonSortHash  implements Comparable<PersonSortHash>{
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
	public PersonSortHash(int id, String name, List<String> address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "PersonSortHash [id=" + id + ", name=" + name +  "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonSortHash other = (PersonSortHash) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	
	public int compareTo(PersonSortHash p) {
	//	return this.id- o.id;
		if(this.getName()!=null) {//NullPOinterException??
		return this.name.compareTo(p.getName());
		}
		else {
			return 1;
		}
		//return o.name.compareTo(this.name);
	}
	
	
}