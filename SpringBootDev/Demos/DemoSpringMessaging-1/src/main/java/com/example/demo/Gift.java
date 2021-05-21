package com.example.demo;

public class Gift {

	private String toAddress;
	private String fromAddress;
	private double weight;
	private double worth;
	private String personalMessage;
	
	public Gift() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Gift [toAddress=" + toAddress + ", fromAddress=" + fromAddress + ", weight=" + weight + ", worth="
				+ worth + ", personalMessage=" + personalMessage + "]";
	}

	public Gift(String toAddress, String fromAddress, double weight, double worth, String personalMessage) {
		this.toAddress = toAddress;
		this.fromAddress = fromAddress;
		this.weight = weight;
		this.worth = worth;
		this.personalMessage = personalMessage;
	}
	
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getWorth() {
		return worth;
	}
	public void setWorth(double worth) {
		this.worth = worth;
	}
	public String getPersonalMessage() {
		return personalMessage;
	}
	public void setPersonalMessage(String personalMessage) {
		this.personalMessage = personalMessage;
	}
}
