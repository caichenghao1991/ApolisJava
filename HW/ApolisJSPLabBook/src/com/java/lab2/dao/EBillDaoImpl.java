package com.java.lab2.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Optional;

import com.java.lab2.dto.Bill;
import com.java.lab2.dto.User;
import com.java.util.Month;
import com.java.util.OracleBaseDao;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

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
	public ArrayList<Bill> searchBill(int custId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Bill> resList=new ArrayList<>();
		String sql = "SELECT * FROM billdetails where consumer_num = ?";
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, custId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int bill_num=rs.getInt("bill_num");
				Double cur_reading=rs.getDouble("cur_reading");
				Double unitConsumed=rs.getDouble("unitConsumed");
				Double netAmount=rs.getDouble("netAmount");
				String month=rs.getString("bill_date");
				month=month.split("-")[1];
				month=Month.getValueByCode(month);
				Bill bill=new Bill(custId, cur_reading, unitConsumed, netAmount, month, bill_num);
				resList.add(bill);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return resList;
	}
	/*public static void main(String[] args) {
		EBillDaoImpl impl=new EBillDaoImpl();
		for(Bill b:impl.searchBill(1)) {
			System.out.println(b.toString());
		};
		
	}*/
}
