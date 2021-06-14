package in.kiruba.model;

public class Plan {
	
	int scheme;
	String networkName;
	String validity;
	String data;
	String subscriptions;
	public int getscheme() {
		return scheme;
	}
	public void setscheme(int scheme) {
		this.scheme = scheme;
	}
	public String getNetworkName() {
		return networkName;
	}
	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public Plan(int scheme, String networkName, String validity, String data, String subscriptions) {
		super();
		this.scheme = scheme;
		this.networkName = networkName;
		this.validity = validity;
		this.data = data;
		this.subscriptions = subscriptions;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(String subscriptions) {
		this.subscriptions = subscriptions;
	}
	@Override
	public String toString() {
		return "scheme [scheme=" + scheme + ", networkName=" + networkName + ", validity=" + validity + ", data=" + data
				+ ", subscriptions=" + subscriptions + "]";
	}
	

}
