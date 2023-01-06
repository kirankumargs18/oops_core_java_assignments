package com.kirangs;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EventManager {

	private static List<Guest> guests = null;

	public static void main(String[] args) {


		guests = populateGuests();
		
		System.out.println("\n\nGuests from France : ");
		List<Guest> guestsByCountry = filterGuestsByCountry("France");
		guestsByCountry.forEach(System.out::println);

		
		System.out.println("\n\nGuests who are from Spain and Who love music and dance : ");
		List<Guest> guestsFromSpain = filterGuestsBySpainWhoLoveMusicAndDance();
		guestsFromSpain.forEach(System.out::println);

		
		System.out.println("\n\nGuests who are from Spain and Who love drink and age above 18 : ");
		List<Guest> guestsFromSpain1 = filterGuestBySpainWhoLoveDrinkAndAgeAbove18();
		guestsFromSpain1.forEach(System.out::println);

		
		System.out.println("\n\nGuests who are from France and Who love sports : ");
		List<Guest> guestsFromFrance = filterGuestByFranceWhoLoveSports();
		guestsFromFrance.forEach(System.out::println);

		
		System.out.println("\n\nGuests who age is above 70 : "+guestsWhoAgeIsAbove70());
		
		
		System.out.println("\n\nGuests who speak chinese and Who love to read : ");
		List<Guest> guestsFromChina=filterGuestByChineseAndWhoLoveToRead();
		guestsFromChina.forEach(System.out::println);

	}

	
	private static List<Guest> populateGuests() {

		List<Guest> guests = new ArrayList<>();

		guests.add(new Guest("Kumar", "1995-05-20", Country.valueOf("USA"), Language.valueOf("English"),
				Arrays.asList(Hobby.valueOf("WaterSports"), Hobby.valueOf("Music"))));

		guests.add(new Guest("Nandish", "1950-05-20", Country.valueOf("Spain"), Language.valueOf("Spanish"),
				Arrays.asList(Hobby.valueOf("WaterSports"), Hobby.valueOf("Music"), Hobby.valueOf("Dance"))));

		guests.add(new Guest("Naresh", "1948-05-20", Country.valueOf("Spain"), Language.valueOf("Spanish"),
				Arrays.asList(Hobby.valueOf("Music"), Hobby.valueOf("Dance"), Hobby.valueOf("Drink"))));

		guests.add(new Guest("Shravan", "1945-05-20", Country.valueOf("France"), Language.valueOf("French"),
				Arrays.asList(Hobby.valueOf("WaterSports"), Hobby.valueOf("Music"))));

		guests.add(new Guest("Naveen", "1995-05-20", Country.valueOf("France"), Language.valueOf("French"),
				Arrays.asList(Hobby.valueOf("WaterSports"), Hobby.valueOf("Read"))));

		guests.add(new Guest("Girish", "1995-05-20", Country.valueOf("China"), Language.valueOf("Chinese"),
				Arrays.asList(Hobby.valueOf("WaterSports"), Hobby.valueOf("Read"))));

		guests.add(new Guest("Harshith", "1995-05-20", Country.valueOf("China"), Language.valueOf("Chinese"),
				Arrays.asList(Hobby.valueOf("WaterSports"), Hobby.valueOf("Read"))));

		return guests;

	}

	/**
	 * To get list of guests by country
	 * */
	private static List<Guest> filterGuestsByCountry(String country) {

		return guests.stream().filter(guest -> guest.getCountry().equals(Country.valueOf(country)))
				.collect(Collectors.toList());

	}
	
	/**
	 * To get list of guests who are from spain and who love music, dance
	 * */
	private static List<Guest> filterGuestsBySpainWhoLoveMusicAndDance() {

		return guests.stream().filter(guest -> guest.getCountry().equals(Country.valueOf("Spain")))
				.filter(guest -> guest.getHobbies().contains(Hobby.valueOf("Dance"))
						&& guest.getHobbies().contains(Hobby.valueOf("Music")))
				.collect(Collectors.toList());
	}

	/**
	 * To get list of guests who are from spain and who love drink and age is above 18
	 * */
	private static List<Guest> filterGuestBySpainWhoLoveDrinkAndAgeAbove18() {

		return guests.stream().filter(guest -> guest.getCountry().equals(Country.valueOf("Spain")))
				.filter(guest -> guest.getHobbies().contains(Hobby.valueOf("Drink"))
						&& calculateAge(LocalDate.parse(String.valueOf(guest.getDateOfBirth()))) > 18)
				.collect(Collectors.toList());
	}

	/**
	 * To get list of guests who are from France and who love sports
	 * */
	private static List<Guest> filterGuestByFranceWhoLoveSports() {

		return guests.stream().filter(guest -> guest.getCountry().equals(Country.valueOf("France"))
				&& guest.getHobbies().contains(Hobby.valueOf("WaterSports"))).collect(Collectors.toList());
	}

	/**
	 * To get number of guests whose age is above 70
	 * */
	private static long guestsWhoAgeIsAbove70() {

		return guests.stream()
				.filter(guest -> calculateAge(LocalDate.parse(String.valueOf(guest.getDateOfBirth()))) > 70).count();
	}

	/**
	 * To get list of guests who speak chinese and who love to read
	 * */
	private static List<Guest> filterGuestByChineseAndWhoLoveToRead() {

		return guests.stream().filter(guest -> guest.getLanguage().equals(Language.valueOf("Chinese"))
				&& guest.getHobbies().contains(Hobby.valueOf("Read"))).collect(Collectors.toList());
	}
	
	/**
	 * Method to calculate age
	 * */
	private static int calculateAge(LocalDate birthDate) {

		return Period.between(birthDate, LocalDate.now()).getYears();
	}

}
