package com.quest.continents.country.flag.poc.service.impl;

/*
 * @Auther Moti
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.continents.country.flag.poc.model.Continent;
import com.quest.continents.country.flag.poc.model.Country;
import com.quest.continents.country.flag.poc.repository.ContinentRepository;
import com.quest.continents.country.flag.poc.repository.CountryRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("continentCountriesFlagService")
public class ContinentCountriesFlagServiceImpl implements ContinentCountriesFlagService {
	
	@Autowired
	ContinentRepository continentRepository;
	
	@Autowired
	CountryRepository countryFlagRepository;	

	@Override
	public List<Country> findByContientId(String continent) {
		
		return continentRepository.findByContinentName(continent);
				//.orElseThrow(() -> new ResourceNotFoundException("Continent not found on :: " + contient));

	}

	@Override
	public Country findByCountryId(String country) {
		
		return continentRepository.findByCountry(country);
		
		//return countryFlagRepository.findById(country)
				//.orElseThrow(() -> new ResourceNotFoundException("country not found on :: " + country));
		
				
	}
	@Override
	public List<Continent> findAll() {
		 return continentRepository.findAll();
	}

	

}
