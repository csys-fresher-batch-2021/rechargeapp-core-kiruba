package in.kiruba.model;

import java.time.LocalDate;

public class Recharge {
	private int userId;
	private int amount;
	private String status;
	private LocalDate date;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Recharge(int userId, int amount, String status) {
		super();
		this.userId = userId;
		this.amount = amount;
		this.status = status;
		
	}
	@Override
	public String toString() {
		return "Recharge [userId=" + userId + ", amount=" + amount + ", status=" + status + ", date=" + date + "]";
	}
	

}
