package com.globallogic;

public class Cream extends BeverageDecorator {

	private int cost;

	public Cream(Beverage beverage, int cost) {
		this.beverage = beverage;
		this.cost = beverage.getCost() + cost;
	}

	@Override
	public int getCost() {

		return cost;
	}

	@Override
	public String getDescription() {

		return beverage.getDescription() + " Cream";
	}

}
