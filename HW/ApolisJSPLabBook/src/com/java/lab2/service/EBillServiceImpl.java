package com.java.lab2.service;


import java.util.ArrayList;


import com.java.lab2.dao.EBillDaoImpl;
import com.java.lab2.dto.Bill;

public class EBillServiceImpl {
	EBillDaoImpl impl=new EBillDaoImpl();
	public boolean createBill(Bill bill) {		
		return impl.createBill(bill);
	}
	public ArrayList<Bill> searchBill(int custId) {	
		return impl.searchBill(custId);
	}
}
