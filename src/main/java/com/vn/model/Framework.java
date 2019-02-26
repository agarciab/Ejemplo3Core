package com.vn.model;

public class Framework extends Software {

	private int robutness;

	public int getRobutness() {
		return robutness;
	}

	public void setRobutness(int robutness) {
		this.robutness = robutness;
	}

	public int quality() {
		return robutness + getFriendliness();
	}
	
	
}
