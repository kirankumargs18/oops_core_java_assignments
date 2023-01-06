package com.globallogic;

public class Tea implements Beverage {

	@Override
	public int getCost() {
		
		return 10;
	}

	@Override
	public String getDescription() {
		
		return "Tea";
	}

}
