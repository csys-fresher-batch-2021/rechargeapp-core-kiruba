package in.kiruba.model;

import java.util.Date;

public class AmountPayable {

	private Long mobileNo;
	private int amount;
	private long cardNumber;
	private Date expiryMonth;
	private Date expiryYear;
	private int cvv;
	private String nameOnCard;

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(Date expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public Date getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(Date expiryYear) {
		this.expiryYear = expiryYear;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public AmountPayable(Long mobileNo, int amount, long cardNumber, Date expiryMonth, Date expiryYear, int cvv,
			String nameOnCard) {
		super();
		this.mobileNo = mobileNo;
		this.amount = amount;
		this.cardNumber = cardNumber;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.cvv = cvv;
		this.nameOnCard = nameOnCard;
	}

	@Override
	public String toString() {
		return "AmountPayable [mobileNo=" + mobileNo + ", amount=" + amount + ", cardNumber=" + cardNumber
				+ ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear + ", cvv=" + cvv + ", nameOnCard="
				+ nameOnCard + "]";
	}

}
