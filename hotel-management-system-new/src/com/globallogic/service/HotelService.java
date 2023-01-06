package com.globallogic.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.globallogic.model.Customer;
import com.globallogic.model.Room;
import com.globallogic.model.RoomType;

public class HotelService {

	public Map<RoomType, List<Room>> differentTypesOfRooms(List<Room> roomList) {

		return roomList.stream().filter(room -> room.isAvailable() == true)
				.collect(Collectors.groupingBy(Room::getRoomType));
	}

	public String bookRoom(int roomNumber, List<Room> roomList, List<Customer> customers) {
		for (Room room : roomList) {
			if (room.getRoomNumber() == roomNumber && room.isAvailable() == true) {
				room.setCustomers(customers);
				room.setAvailable(false);
				return "Room Booked successfully";
			}
		}
		return "Room not available";
	}

	public String checkoutRoom(int roomNumber, List<Room> roomList) {

		for (Room room : roomList) {
			if (room.getRoomNumber() == roomNumber && room.isAvailable() == false) {

				room.setAvailable(true);
				room.setCustomers(null);
				return "Room " + roomNumber + " checked out successfully";
			}
		}
		return "Room not booked yet";
	}

	public void viewAllRooms(List<Room> roomList) {
		
		roomList.forEach(System.out::println);
	}
	
	

}
