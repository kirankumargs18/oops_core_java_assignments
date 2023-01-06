package com.globallogic;

public class TestMain {

	public static void main(String[] args) {

		System.out.println("Tea with add-on\n");
		Beverage beverage = new Tea();
		printBeverage(beverage);

		Beverage teaWithHoney = new Honey(new Tea(), 6);
		printBeverage(teaWithHoney);

		Beverage teaWithCaramel = new Caramel(new Tea(), 8);
		printBeverage(teaWithCaramel);

		Beverage teaWithCream = new Cream(new Tea(), 10);
		printBeverage(teaWithCream);

		Beverage teaWithAllAddon = new Caramel(new Honey(new Cream(new Chacolate(new Tea(), 5), 10), 6), 8);
		printBeverage(teaWithAllAddon);

		System.out.println("\nCoffee with add-on\n");

		Beverage beverage1 = new Coffee();
		printBeverage(beverage1);

		Beverage coffeWithHoney = new Honey(new Coffee(), 6);
		printBeverage(coffeWithHoney);

		Beverage coffeeWithCaramel = new Caramel(new Coffee(), 8);
		printBeverage(coffeeWithCaramel);

		Beverage coffeeWithChacolate = new Chacolate(new Coffee(), 5);
		printBeverage(coffeeWithChacolate);

		Beverage coffeeWithCream = new Cream(new Coffee(), 10);
		printBeverage(coffeeWithCream);

		Beverage coffeeWithAllAddon = new Caramel(new Honey(new Cream(new Chacolate(new Coffee(), 5), 10), 6), 8);
		printBeverage(coffeeWithAllAddon);

	}

	private static void printBeverage(Beverage beverage) {

		System.out.println("Beverage : " + beverage.getDescription() + "\nCost : " + beverage.getCost());
	}

}
