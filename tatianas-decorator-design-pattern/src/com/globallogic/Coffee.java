package com.globallogic;

public class Coffee implements Beverage {

	@Override
	public int getCost() {
		
		return 12;
	}

	@Override
	public String getDescription() {
		
		return "Coffee";
	}

}
