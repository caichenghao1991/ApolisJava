package com.java.lab5.dao;


import com.java.lab5.dto.Bill;

import com.java.util.OracleBaseDao;

public class EBillDaoImpl extends OracleBaseDao {


	public boolean createBill(Bill bill) {		
		if (bill.getConsumerId() != null && bill.getCurrentReading()!= null && bill.getNetAmount()!= null 
				&& bill.getUnitConsumed()!=null) {
				
			/*int flag=executeUpdate("insert into billdetails values(seq_bill_num.nextval,?, ?,?,?,sysdate)",bill.getConsumerId(),
					bill.getCurrentReading(),bill.getUnitConsumed(),bill.getNetAmount());*/
			
			int id=bill.getConsumerId();
			System.out.println("bill"+id);
			int flag=executeUpdate("insert into billdetails values(seq_bill_num.nextval,?, ?,?,?,sysdate)",
					id,bill.getCurrentReading(),bill.getUnitConsumed(),bill.getNetAmount());
			if(flag==1) {
				return true;
			}				
		}
	return false;
	}
}
