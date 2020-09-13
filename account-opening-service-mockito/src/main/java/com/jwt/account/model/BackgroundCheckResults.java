package com.jwt.account.model;

public class BackgroundCheckResults {

	private String riskProfile;
	private long upperAccountLimit;

	public BackgroundCheckResults(String riskProfile, long upperAccountLimit) {
		this.riskProfile = riskProfile;
		this.upperAccountLimit = upperAccountLimit;
	}

	public BackgroundCheckResults() {
		// TODO Auto-generated constructor stub
	}

	public String getRiskProfile() {
		return riskProfile;
	}

	public void setRiskProfile(String riskProfile) {
		this.riskProfile = riskProfile;
	}

	public long getUpperAccountLimit() {
		return upperAccountLimit;
	}

	public void setUpperAccountLimit(long upperAccountLimit) {
		this.upperAccountLimit = upperAccountLimit;
	}

}
