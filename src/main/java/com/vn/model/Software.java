package com.vn.model;

public abstract class Software implements ISoftware {
	
	private String name;
	
	private int friendliness;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFriendliness() {
		return friendliness;
	}

	public void setFriendliness(int friendliness) {
		this.friendliness = friendliness;
	}
	
	

}
