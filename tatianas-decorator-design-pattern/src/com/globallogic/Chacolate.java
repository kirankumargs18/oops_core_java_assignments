package com.globallogic;

public class Chacolate extends BeverageDecorator {

	private int cost;

	public Chacolate(Beverage beverage, int cost) {
		this.beverage = beverage;
		this.cost = beverage.getCost() + cost;
	}

	@Override
	public int getCost() {

		return cost;
	}

	@Override
	public String getDescription() {

		return beverage.getDescription() + " Chacolate";
	}

}
