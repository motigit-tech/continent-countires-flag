package com.quest.continents.country.flag.poc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//continents will be the name of collection in mongodb
@Document(collection = "continentcollection")
public class Country {

	@Id
	private String name;	
	private String flag;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Country(String name, String flag) {
		super();
		this.name = name;
		this.flag = flag;
	}
		
}
