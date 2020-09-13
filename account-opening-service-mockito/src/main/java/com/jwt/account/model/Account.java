package com.jwt.account.model;

import java.util.Currency;
import java.util.Date;
import java.util.Set;

public class Account {

	private String id;
	private String firstName;
	private String lastName;
	private Date dob;
	private String taxId;
	private long totalInvestmentValue;
	private Currency ccy;
	private Set<String> investments;
	private long availableCash;
	private Date expectedRetirement;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public long getTotalInvestmentValue() {
		return totalInvestmentValue;
	}

	public void setTotalInvestmentValue(long totalInvestmentValue) {
		this.totalInvestmentValue = totalInvestmentValue;
	}

	public Currency getCcy() {
		return ccy;
	}

	public void setCcy(Currency ccy) {
		this.ccy = ccy;
	}

	public Set<String> getInvestments() {
		return investments;
	}

	public void setInvestments(Set<String> investments) {
		this.investments = investments;
	}

	public long getAvailableCash() {
		return availableCash;
	}

	public void setAvailableCash(long availableCash) {
		this.availableCash = availableCash;
	}

	public Date getExpectedRetirement() {
		return expectedRetirement;
	}

	public void setExpectedRetirement(Date expectedRetirement) {
		this.expectedRetirement = expectedRetirement;
	}

}
