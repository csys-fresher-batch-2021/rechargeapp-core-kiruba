package in.kiruba.model;

public class AdditionalPlan { 
	
	private int plan;
	private String network;
	private String validity;
	private String data;
	private String subscription;
	private int userId;
	private long mobileNumber;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getPlan() {
		return plan;
	}
	public void setPlan(int plan) {
		this.plan = plan;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getSubscription() {
		return subscription;
	}
	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}
	
	public AdditionalPlan(int plan, String network, String validity, String data, String subscription, int userId,
			long mobileNumber) {
		super();
		this.plan = plan;
		this.network = network;
		this.validity = validity;
		this.data = data;
		this.subscription = subscription;
		this.userId = userId;
		this.mobileNumber = mobileNumber;
	}
	public AdditionalPlan(int plan, String network, String validity, String data, String subscription) {
		super();
		this.plan = plan;
		this.network = network;
		this.validity = validity;
		this.data = data;
		this.subscription = subscription;
	}
	@Override
	public String toString() {
		return "AdditionalPlan [plan=" + plan + ", network=" + network + ", validity=" + validity + ", data=" + data
				+ ", subscription=" + subscription + ", userId=" + userId + ", mobileNumber=" + mobileNumber + "]";
	}
	

}
