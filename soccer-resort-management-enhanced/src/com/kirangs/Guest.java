package com.kirangs;

import java.util.List;

public class Guest {

	private String name;
	private String dateOfBirth;
	private Country country;
	private Language language;
	private List<Hobby> hobbies;

	public Guest() {
		super();
	}

	public Guest(String name, String dateOfBirth, Country country, Language language, List<Hobby> hobbies) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
		this.language = language;
		this.hobbies = hobbies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public List<Hobby> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<Hobby> hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Guest [name=" + name + ", dateOfBirth=" + dateOfBirth + ", country=" + country + ", language="
				+ language + ", hobbies=" + hobbies + "]";
	}

}
