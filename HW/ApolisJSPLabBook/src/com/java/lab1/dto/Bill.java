package com.java.lab1.dto;

public class Bill {
	Integer custId;
	Double currentReading;
	Double unitConsumed;
	Double netAmount;
	public Bill(Integer consumerId, double currentReading, double unitConsumed, double netAmount) {
		super();
		this.custId = consumerId;
		this.currentReading = currentReading;
		this.unitConsumed = unitConsumed;
		this.netAmount = netAmount;
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
				+ ", netAmount=" + netAmount + "]";
	}
	
}
