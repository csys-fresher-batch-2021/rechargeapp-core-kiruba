package in.kiruba.model;

import java.time.LocalDate;

public class SpecialOffer {
	int plan;
	int offer;
	String network;
	String validity;
	String data;
	String subscription;
	LocalDate date;

	public int getPlan() {
		return plan;
	}

	public void setPlan(int plan) {
		this.plan = plan;
	}

	public int getOffer() {
		return offer;
	}

	public void setOffer(int offer) {
		this.offer = offer;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public SpecialOffer(int plan, int offer, String network, String validity, String data, String subscription,
			LocalDate date) {
		super();
		this.plan = plan;
		this.offer = offer;
		this.network = network;
		this.validity = validity;
		this.data = data;
		this.subscription = subscription;
		this.date = date;
	}

	@Override
	public String toString() {
		return "SpecialOffer [plan=" + plan + ", offer=" + offer + ", network=" + network + ", validity=" + validity
				+ ", data=" + data + ", subscription=" + subscription + ", date=" + date + "]";
	}

}
