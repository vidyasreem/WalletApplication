package com.cg.paymentapp.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Benificiary")
public class BenificiaryDetails {
	@Id
	@Column(length=5)
	private int benificiaryId;
	@Column(length=20)
	private String name;
	@Column(length=10)
	private String mobileNumber;
	
	public int getBenificiaryId() {
		return benificiaryId;
	}
	public void setBenificiaryId(int benificiaryId) {
		this.benificiaryId = benificiaryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "BenificiaryDetails [benificiaryId=" + benificiaryId + ", name=" + name + ", mobileNumber="
				+ mobileNumber + "]";
	}
	

}

