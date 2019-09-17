package com.quest.continents.country.flag.poc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quest.continents.country.flag.poc.model.Continent;
import com.quest.continents.country.flag.poc.model.Country;

@Repository
public interface CountryFlagDao {

	public List <Continent> findByContientId(String contient);
	public Country findByCountryId(String country);
	
	

}
