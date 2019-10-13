package com.java.lab2.dto;

public class Bill {
	Integer custId;
	Double currentReading;
	Double unitConsumed;
	Double netAmount;
	String month;
	Integer bill_num;
	public Bill(Integer consumerId, double currentReading, double unitConsumed, double netAmount) {
		super();
		this.custId = consumerId;
		this.currentReading = currentReading;
		this.unitConsumed = unitConsumed;
		this.netAmount = netAmount;
	}
	
	
	
	public Bill(Integer custId, Double currentReading, Double unitConsumed, Double netAmount, String month,
			Integer bill_num) {
		super();
		this.custId = custId;
		this.currentReading = currentReading;
		this.unitConsumed = unitConsumed;
		this.netAmount = netAmount;
		this.month = month;
		this.bill_num = bill_num;
	}



	public Integer getBill_num() {
		return bill_num;
	}



	public void setBill_num(Integer bill_num) {
		this.bill_num = bill_num;
	}



	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getConsumerId() {
		return custId;
	}
	public void setConsumerId(Integer consumerId) {
		this.custId = consumerId;
	}
	public Double getCurrentReading() {
		return currentReading;
	}
	public void setCurrentReading(Double currentReading) {
		this.currentReading = currentReading;
	}
	public Double getUnitConsumed() {
		return unitConsumed;
	}
	public void setUnitConsumed(Double unitConsumed) {
		this.unitConsumed = unitConsumed;
	}
	public Double getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}



	@Override
	public String toString() {
		return "Bill [custId=" + custId + ", currentReading=" + currentReading + ", unitConsumed=" + unitConsumed
				+ ", netAmount=" + netAmount + ", month=" + month + ", bill_num=" + bill_num + "]";
	}



	
}
