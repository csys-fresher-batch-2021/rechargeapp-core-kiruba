package in.kiruba.model;

import java.util.Date;

public class PaymentDetail {
	
	private int userId;
	private String network;
	private int amount;
	private long mobileNumber;
	private int plan;
	private  Date date;
	private int validity;
	
	
	
	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public int getPlan() {
		return plan;
	}

	public void setPlan(int plan) {
		this.plan = plan;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNetwork() {
		return network;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setNetwork(String network) {
		this.network = network;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public PaymentDetail(int userId, String network, int amount,int validity, long mobileNumber) {
		super();
		this.userId = userId;
		this.network = network;
		this.amount = amount;
		this.validity=validity;
		this.mobileNumber = mobileNumber;
	}
	

	
	public PaymentDetail(int userId, String network, long mobileNumber, int plan, int validity,Date date) {
		super();
		this.userId = userId;
		this.network = network;
		this.mobileNumber = mobileNumber;
		this.plan = plan;
		this.date = date;
		this.validity=validity;
	}

	@Override
	public String toString() {
		return "PaymentDetail [userId=" + userId + ", network=" + network + ", amount=" + amount + ", mobileNumber="
				+ mobileNumber + ", plan=" + plan + ", date=" + date + ", validity=" + validity + "]";
	}
	
	

}
