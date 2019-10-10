package com.java.HW3.q1;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.javafx.image.IntPixelAccessor;

import oracle.net.ano.SupervisorService;
import sun.swing.AccumulativeRunnable;



public class BankService extends OracleBaseDao{
	
	
	public static ArrayList<Integer> toList(String str) {
		ArrayList<Integer> list=new ArrayList<>();
		String[] ar=str.split(",");
		for(String x:ar) {
			try {
				list.add(Integer.parseInt(x));
			} catch (NumberFormatException e) {
				System.out.println("enter correct customer Id list");
			}			
		}		
		return list;
	}
	
	public void executeUpdate(String sql){
		super.executeUpdate(sql);
		
	}
	public void addAccount(int id, float amount, String custList,  Type type, Long accountNumber) {
		boolean flag=Account.addAccount(id, amount, toList(custList), type, accountNumber);	
		if(flag) {
			executeUpdate("insert into account values(?,?,?,?,?)",id,amount,custList,type.toString(),accountNumber);
		}
	}
	public void deleteAccount(int id){
		boolean flag=Account.deleteAccount(id);	
		if(flag) {
			executeUpdate("delete from account where id = ?",id);
		}
	}
	public void addMoney(int id,float amount) {
		
		if(Account.checkAccountExist(id)) {
			Account account=Account.getAccount(id);
			synchronized (this) {
				account.addMoney(amount);
				executeUpdate("update account set amount = ? where id = ?",account.getAmount(),id);
				try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
			}		
		}else {
			System.out.println("account:"+id+" doesn't exist");
		}
		
	}
	public void deductMoney(int id,float amount) {
		if(Account.checkAccountExist(id)) {
			Account account=Account.getAccount(id);
			synchronized (this) {
				account.deductMoney(amount);
				executeUpdate("update account set amount = ? where id = ?",account.getAmount(),id);
				try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
			}
		}else {
			System.out.println("account:"+id+" doesn't exist");
		}
	}
	
	public void transferMoney(int id1, int id2, float amount) {
		if(getAccountByID(id1)!=null &&getAccountByID(id2)!=null) {
			Account account1=getAccountByID(id1);
			Account account2=getAccountByID(id2);
			synchronized (this) {
				account1.transferMoney(id2, amount);
				String[] sql= {"update account set amount = ? where id = ?",
					"update account set amount = ? where id = ?"};
				Object[][] params= {{account1.getAmount(),id1},{account2.getAmount()+amount,id2}};
				executeUpdateTransaction(sql, params);
				try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
			}
		}else {
			System.out.println("account:"+id1+" or "+id2+" doesn't exist");
		}
	}
	public Account getAccountByID(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM account where id = ?";
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				float amount=rs.getFloat("amount");
				ArrayList<Integer> custList=toList(rs.getString("custList"));
				Type type=Type.valueOf(rs.getString("type"));
				Long accountNumber= rs.getLong("accountNumber");
				Account account=new Account(id, amount, custList, type, accountNumber);
				return account;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return null;
	}	
	public Customer getCustomerByID(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM customer where id = ?";
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String name=rs.getString("name");
				String mobile=rs.getString("mobile");
				String email=rs.getString("email");
				String username=rs.getString("username");
				String password=rs.getString("password");
				String address=rs.getString("address");				
				Customer customer=new Customer(id, name, mobile, email, username, password, address);
				return customer;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return null;
	}
	public boolean checkTableExist(String table) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) as c from all_tables where table_name =?";
		try {
			conn = super.getConnection();
			pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, table.toUpperCase());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if(rs.getInt("c")==1) {
					return true;
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return false;
	}

	public void addCustomer(int id, String name, String mobile, String email, String username,String password,String address) {
		boolean flag=Customer.addCustomer(id, name, mobile, email, username, password, address);
		if(flag) {
			executeUpdate("insert into customer values(?,?,?,?,?,?,?)",id,name, mobile, email, username, password, address);
		}
	}
	public static void initializeTables() {
		BankService test = new BankService();
		if(!test.checkTableExist("CUSTOMER")){
			test.executeUpdate("create table customer (id number primary key, name varchar(40),mobile varchar(40),"
				+ "email varchar(40),username varchar(40),password varchar(40),address varchar(40))");
			test.addCustomer(201, "Tom","2223334444", "tom@gmail.com","usertom","111111", "Chicago");
			test.addCustomer(202, "Mary","1115556666", "mary@gmail.com","usermary","222222", "New York");
			test.addCustomer(203, "Jack","7778889999", "jack@gmail.com","userjack","44444", "Boston");
		}
		if(!test.checkTableExist("ACCOUNT")){
			test.executeUpdate("create table account (id number primary key, amount number(15,2),"
					+ "custList varchar(1000),type varchar(10),accountNumber varchar(40))");
			test.addAccount(1, 500.0f,"201,202",Type.SAVING, 10001L);
			test.addAccount(2, 200.0f,"203,204",Type.CURRENT, 10002L);
			test.addAccount(3, 300.0f,"205,206",Type.CURRENT, 10003L);
		}
		
		
	}

}
