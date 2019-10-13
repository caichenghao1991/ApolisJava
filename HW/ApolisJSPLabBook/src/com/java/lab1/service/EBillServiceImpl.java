package com.java.lab1.service;


import com.java.lab1.dao.EBillDaoImpl;
import com.java.lab1.dto.Bill;

public class EBillServiceImpl {
	EBillDaoImpl impl=new EBillDaoImpl();
	public boolean createBill(Bill bill) {		
		return impl.createBill(bill);
	}
}
