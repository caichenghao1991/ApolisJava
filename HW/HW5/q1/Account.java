package com.java.HW3.q1;

import java.util.*;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Account {
	private int id;
	private float amount;
	private ArrayList<Integer> custList=new ArrayList<>();
	private Type type;
	private Long accountNumber;
	static BankService bankService=new BankService();


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public ArrayList<Integer> getCustList() {
		return custList;
	}
	public void setCustList(ArrayList<Integer> custList) {
		this.custList = custList;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}



/*
	public static HashMap<Integer, Account> getAccountRepo() {
		return accountRepo;
	}
	public static void setAccountRepo(HashMap<Integer, Account> accountRepo) {
		Account.accountRepo = accountRepo;
	}*/
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
		Account other = (Account) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public Account() {
		super();
	}
	
	public Account(int id, float amount, ArrayList<Integer> custList, Type type, Long accountNumber) {
		super();
		this.id = id;
		this.amount = amount;
		if(custList!=null) {
			this.custList = custList;
		}	
		this.type = type;
		this.accountNumber = accountNumber;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", amount=" + amount + ", custList=" + custList + ", type=" + type
				+ ", accountNumber=" + accountNumber + "]";
	}
	
	
	public static boolean addAccount(int id, float amount, ArrayList<Integer> custList,  Type type, Long accountNumber) {		
		if(bankService.getAccountByID(id)!=null) {
			System.out.println("Account already exist");
			return false;
		}else {		
			Account account=new Account(id, amount, custList, type, accountNumber);
			System.out.print("Account added:");
			System.out.println(account.toString());	
			return true;
		}
		
	}
	public  boolean addCust(int id,ArrayList<Integer> custList) {
		if(bankService.getAccountByID(id)!=null) {
			if(custList!=null) {
				for(int custId:custList) {
					if(!bankService.getAccountByID(id).getCustList().contains(custId)) {
						bankService.getAccountByID(id).getCustList().add(custId);
					}
				}	
			}					
			System.out.println("Account custId updated");
			return true;
		}else {				
			System.out.print("Account does not exist");
			return false;
		}
	}
	public static boolean deleteAccount(int id) {		
		if(bankService.getAccountByID(id)!=null) {
			System.out.println("account id:"+id+" deleted.");
			return true;
		}else {
			System.out.println("account don't exist");
			return false;
		}
	}
	
	public static boolean checkAccountExist(int id) {
		if(bankService.getAccountByID(id)!=null) {
			return true;
		}
		return false;
	}
	public static Account getAccount(int id) {
		return bankService.getAccountByID(id);
		
	}
	
	public void addMoney(float amount) {
		setAmount(getAmount()+amount);
		System.out.println(amount+" added to account: "+getId()+". Current Balance:"+getAmount());
	}
	public void deductMoney(float amount) {
		setAmount(getAmount()-amount);
		System.out.println(amount+" deducted to account: "+getId()+". Current Balance:"+getAmount());
	}
	public void transferMoney(int id, float amount) {
		if(bankService.getAccountByID(id)!=null) {
			setAmount(getAmount()-amount);
			System.out.println(amount+" deducted from account:"+this.id
					+". Current Balance:"+this.amount);
			Account account2=bankService.getAccountByID(id);
			account2.setAmount(account2.getAmount()+amount);
			System.out.println(amount+" added to account:"+id
					+". Current Balance:"+account2.getAmount());
		}else {
			System.out.println("Account:"+id+"does not exist");
		}				
	}
}
enum Type
{ 
    SAVING,CURRENT; 

} 