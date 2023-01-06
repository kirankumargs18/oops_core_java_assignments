package com.globallogic;

public class Honey extends BeverageDecorator {

	private int cost;

	public Honey(Beverage beverage, int cost) {
		this.beverage = beverage;
		this.cost = beverage.getCost() + cost;
	}

	@Override
	public int getCost() {

		return cost;
	}

	@Override
	public String getDescription() {

		return beverage.getDescription()+" Honey";
	}

}
