package in.kiruba.model;

public class PaymentDetail {
	
	private int userId;
	private String network;
	private int amount;
	private long mobileNumber;
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
	
	public PaymentDetail(int userId, String network, int amount, long mobileNumber) {
		super();
		this.userId = userId;
		this.network = network;
		this.amount = amount;
		this.mobileNumber = mobileNumber;
	}

	
	@Override
	public String toString() {
		return "PaymentDetail [userId=" + userId + ", network=" + network + ", amount=" + amount + ", mobileNumber="
				+ mobileNumber + "]";
	}
	
	

}
