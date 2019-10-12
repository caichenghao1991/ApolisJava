package com.java.lab5.service;


import com.java.lab5.dao.EBillDaoImpl;
import com.java.lab5.dto.Bill;

public class EBillServiceImpl {
	EBillDaoImpl impl=new EBillDaoImpl();
	public boolean createBill(Bill bill) {		
		return impl.createBill(bill);
	}
}
