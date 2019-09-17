package com.quest.continents.country.flag.poc.service.impl;

import java.util.List;

import com.quest.continents.country.flag.poc.model.Continent;
import com.quest.continents.country.flag.poc.model.Country;

public interface ContinentCountriesFlagService {
	
	public List<Country> findByContientId(String contient);
	public Country findByCountryId(String country);
	public List<Continent> findAll();

}
