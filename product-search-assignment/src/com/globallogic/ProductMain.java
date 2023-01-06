package com.globallogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.globallogic.model.Product;

public class ProductMain {

	private static Scanner scanner = null;

	private static List<Product> products = null;

	public static void main(String[] args) {

		scanner = new Scanner(System.in);
		products = populateProducts();

		while (true) {
			System.out.println(
					"\n1.View All Products\n2.Search Product by Name\n3.Search Product by Price\n4.Search Products by Quantity"
							+ "\n5.Exit");
			System.out.println("Enter your choice : ");
			int choice = scanner.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Products are listed below : ");
				printProducts(products);
				break;

			case 2:
				System.out.println("Enter name of the product to be searched : ");
				String name = scanner.next();
				searchProductsByName(name);
				break;
			case 3:
				System.out.println("Enter price of the product to be searched : ");
				double price = scanner.nextDouble();
				searchProductByPrice(price);
				break;
			case 4:
				System.out.println("Enter quantiy of the product to be searched : ");
				int quantity = scanner.nextInt();
				searchProductByQuantity(quantity);
				break;
			case 5:
				return;
			}
		}

	}
	
	
	/**
	 * Returns list of products
	 * */
	private static List<Product> populateProducts() {

		List<Product> products = new ArrayList<>();
		products.add(new Product(1, "Mobile", 10000.00, 5));
		products.add(new Product(2, "Laptop", 60000.00, 8));
		products.add(new Product(3, "Cloth", 2000.00, 10));
		return products;
	}
	

	/**
	 * Search products by Name
	 * */
	private static void searchProductsByName(String productName) {
		
		List<Product> productsList = products.stream()
				.filter(product-> product.getName().equalsIgnoreCase(productName))
				.collect(Collectors.toList());
		printProducts(productsList);
	}

	/**
	 * Search products by Price
	 * */
	private static void searchProductByPrice(double price) {

		List<Product> productsList = products.stream()
				.filter(product -> product.getPrice() == price)
				.collect(Collectors.toList());
		printProducts(productsList);
	}

	/**
	 * Search products by Quantity
	 * */
	private static void searchProductByQuantity(int quantity) {
		
		List<Product> productsList = products.stream()
				.filter(product -> product.getQuantity() > quantity)
				.collect(Collectors.toList());
		printProducts(productsList);
	}
	
	/**
	 * Prints all products
	 * */
	private static void printProducts(List<Product> products) {
		
		if (products.isEmpty()) {
			System.out.println("No Product/s found");
		} else {
			products.forEach(System.out::println);
		}
	}
	
}
