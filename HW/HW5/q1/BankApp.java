package com.java.HW3.q1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class BankApp {
	public static void main(String[] args) {	
		BankService.initializeTables();
		BankService test = new BankService();
		
		
		System.out.println(test.getAccountByID(1).toString());
		System.out.println(test.getCustomerByID(203).toString());
		test.addMoney(2, 50f);		
		test.deductMoney(2, 20f);		
		test.transferMoney(2, 3, 100f);
		test.deleteAccount(3);	
		
		Thread thread1 =new Thread(new Runnable() {			
			@Override
			public void run() {				
				test.deductMoney(1, 300f);	
			}
		});
		Thread thread2 =new Thread(()->test.deductMoney(1, 300f));	
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(test.getAccountByID(1).toString());
		test.executeUpdate("drop table account");
		test.executeUpdate("drop table customer");
	}
}
