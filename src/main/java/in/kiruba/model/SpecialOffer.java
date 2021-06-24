package in.kiruba.model;

import java.time.LocalDate;

public class SpecialOffer {
	int planOfNetwork;
	int offer;
	String system;
	String power;
	String netBalance;
	String addition;
	LocalDate stage;
	public int getPlanOfNetwork() {
		return planOfNetwork;
	}
	public void setPlanOfNetwork(int planOfNetwork) {
		this.planOfNetwork = planOfNetwork;
	}
	public int getOffer() {
		return offer;
	}
	public void setOffer(int offer) {
		this.offer = offer;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getNetBalance() {
		return netBalance;
	}
	public void setNetBalance(String netBalance) {
		this.netBalance = netBalance;
	}
	public String getAddition() {
		return addition;
	}
	public void setAddition(String addition) {
		this.addition = addition;
	}
	public LocalDate getStage() {
		return stage;
	}
	public void setStage(LocalDate stage) {
		this.stage = stage;
	}
	public SpecialOffer(int planOfNetwork, int offer, String system, String power, String netBalance, String addition,
			LocalDate stage) {
		super();
		this.planOfNetwork = planOfNetwork;
		this.offer = offer;
		this.system = system;
		this.power = power;
		this.netBalance = netBalance;
		this.addition = addition;
		this.stage = stage;
	}
	@Override
	public String toString() {
		return "SpecialOffer [planOfNetwork=" + planOfNetwork + ", offer=" + offer + ", system=" + system + ", power="
				+ power + ", netBalance=" + netBalance + ", addition=" + addition + ", stage=" + stage + "]";
	}
	
	

	
}
