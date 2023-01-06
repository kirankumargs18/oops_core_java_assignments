package com.globallogic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.globallogic.model.Customer;
import com.globallogic.model.Room;
import com.globallogic.model.RoomType;
import com.globallogic.service.HotelService;

public class HotelMain {

	private static List<Room> roomList = null;
	private static Scanner scanner = null;

	public static void main(String[] args) {

		HotelService service = new HotelService();
		scanner = new Scanner(System.in);
		boolean isExit = true;

		roomList = new ArrayList<>();

		roomList.add(new Room(1, RoomType.SingleRoom, true, true, null));
		roomList.add(new Room(2, RoomType.SingleRoom, true, true, null));
		roomList.add(new Room(3, RoomType.DoubleRoom, true, true, null));
		roomList.add(new Room(4, RoomType.DoubleRoom, true, true, null));


		while (isExit) {
			System.out.println("\n1.View types of rooms available\n2.Book a room\n3.Check out a room"
					+ "\n4.View all rooms\n5.Order food\n6.exit");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();

			switch (choice) {

			case 1:
				System.out.println("All types of rooms with details : \n");
				Map<RoomType, List<Room>> typesOfRooms = service.differentTypesOfRooms(roomList);
				printRooms(typesOfRooms);
				break;

			case 2:
				System.out.println("Enter room number : ");
				int number = scanner.nextInt();
				System.out.println("Enter number of customers : ");
				int num = scanner.nextInt();
				List<Customer> customersList = readCustomers(num);
				System.out.println(service.bookRoom(number, roomList, customersList));
				break;
				
			case 3:
				System.out.println("Enter room number to check out : ");
				int roomNumber = scanner.nextInt();
				System.out.println(service.checkoutRoom(roomNumber, roomList));
				break;

			case 4:
				service.viewAllRooms(roomList);
				break;
				
			case 5: 
				orderFood();
				break;

			case 6:
				isExit = false;
				break;

			default:
				break;
			}
		}

	}

	private static void printRooms(Map<RoomType, List<Room>> typesOfRooms) {

		for (Map.Entry<RoomType, List<Room>> entry : typesOfRooms.entrySet()) {

			System.out.println("\nRoom Type : " + entry.getKey());
			System.out.println("Available " + entry.getKey().toString() + " room details : ");
			entry.getValue().forEach(System.out::println);
		}

	}

	private static List<Customer> readCustomers(int numberOfCustomers) {

		List<Customer> customers = new ArrayList<>();

		int i = 1;
		while (i <= numberOfCustomers) {

			Customer customer = null;

			System.out.println("Enter customer " + i + " name : ");
			String name = scanner.next();

			System.out.println("Enter customer " + i + " gender : ");
			String gender = scanner.next();

			System.out.println("Enter customer " + i + " contact number : ");
			long contactNumber = scanner.nextLong();

			customer = new Customer(name, gender, contactNumber);
			customers.add(customer);
			i++;
		}
		return customers;
	}
	
	 public static String orderFood() {
	        int orderMore;
	        do {
	        
	            System.out.println("Food Menu:" );
	            System.out.println("\n1.Biriyani\n2.Chicken 65\n3.Veg Biriyani\n4.Curd Rice");
	          
	            System.out.println("Enter your choice:");
	            int choice = scanner.nextInt();

	            System.out.println("Enter quantity to order:");
	            int quantity = scanner.nextInt();
	            float totalPrice=0;
	            switch(choice) {
	                case 1: totalPrice+= 200*quantity;
	                    System.out.println("item: Biriyaani "+"totoal price: "+totalPrice);
	                    break;
	                case 2: totalPrice+= 150*quantity;
	                    System.out.println("item: Chicken 65 "+"total price: "+totalPrice);
	                    break;
	                case 3: totalPrice+= 100*quantity;
	                    System.out.println("item: Veg Biriyani   "+"total price: "+totalPrice);
	                    break;
	                case 4: totalPrice+= 60*quantity;
	                    System.out.println("item: Curd Rice   "+"total price: "+totalPrice);
	                    break;
	                default: System.out.println("This item is not available \n");
	            }
	            System.out.println("wanna order more- press 1 for continue or 0 for exit");
	            orderMore = scanner.nextInt();
	            
	        }while(orderMore==1);

	        System.out.println("Your order has been placed successfully");
	        return null;

	    }

}
