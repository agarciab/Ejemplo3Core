package com.vn.model;

public class Tool extends Software {

	private int lookandfeel;

	public int getLookandfeel() {
		return lookandfeel;
	}

	public void setLookandfeel(int lookandfeel) {
		this.lookandfeel = lookandfeel;
	}

	public int quality() {
		return lookandfeel + getFriendliness();
	}
	
}
