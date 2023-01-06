package com.globallogic.model;

import java.util.List;

public class Room {

	private int roomNumber;
	private RoomType roomType;
	private boolean isAvailable;
	private boolean isAC;
	private List<Customer> customers;

	public Room() {

		super();
	}

	public Room(int roomNumber, RoomType roomType, boolean isAvailable, boolean isAC, List<Customer> customers) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.isAvailable = isAvailable;
		this.isAC = isAC;
		this.customers = customers;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean isAC() {
		return isAC;
	}

	public void setAC(boolean isAC) {
		this.isAC = isAC;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", roomType=" + roomType + ", isAvailable=" + isAvailable + ", isAC="
				+ isAC + ", customers=" + customers + "]";
	}

}
