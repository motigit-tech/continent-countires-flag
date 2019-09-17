package com.quest.continents.country.flag.poc.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//continents will be the name of collection in mongodb
@Document(collection = "continent")
public class Continent {

	@Id
	private String continent;	
	private List <Country> countries = new ArrayList<Country>();
	
	public Continent(String continent, List<Country> countries) {
		super();
		this.continent = continent;
		this.countries = countries;
	}
	
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public List<Country> getCountries() {
		return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
}
