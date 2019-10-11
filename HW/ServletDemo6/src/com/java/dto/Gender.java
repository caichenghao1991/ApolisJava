package com.java.dto;

public enum Gender{
	MALE('M'), FEMALE('F');
	private char val;
	
	private Gender(char c){
		this.val= c;
	}
	
	public char getVal() {
		return val;
	}
}