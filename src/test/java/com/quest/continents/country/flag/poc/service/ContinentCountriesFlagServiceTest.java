package com.quest.continents.country.flag.poc.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.quest.continents.country.flag.poc.model.Continent;
import com.quest.continents.country.flag.poc.model.Country;
import com.quest.continents.country.flag.poc.repository.ContinentRepository;
import com.quest.continents.country.flag.poc.service.impl.ContinentCountriesFlagServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class ContinentCountriesFlagServiceTest {
	
	@Mock
	private ContinentRepository continentRepository;
	
	
	@InjectMocks
	private ContinentCountriesFlagServiceImpl continentCountriesFlagService; 
		
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);		
	}
	
	@Test
	public void testFindAllContinents(){
		List <Continent>continentList = new ArrayList<Continent>();		
		List <Country>countryAfricaList = new ArrayList<Country>();	
		List <Country>countryAmericaList = new ArrayList<Country>();
		
		countryAfricaList.add(new Country("Nigeria", "🇳🇬"));
		countryAfricaList.add(new Country("Ethiopia", "🇪🇹"));
		countryAfricaList.add(new Country("Egypt", "🇪🇬"));
		countryAfricaList.add(new Country("DR Congo", "🇨🇩"));
		countryAfricaList.add(new Country("South Africa", "🇿🇦"));		
		
		countryAmericaList.add(new Country("USA", "🇺🇸"));
		countryAmericaList.add(new Country("Brazil", "🇧🇷"));
		
		Continent continentAfrica = new Continent("Africa", countryAfricaList);
		Continent continentAmerica = new Continent("America", countryAmericaList);
		
		continentList.add(continentAfrica);
		continentList.add(continentAmerica);

		when(continentRepository.findAll()).thenReturn(continentList);
		
		List<Continent> result = continentCountriesFlagService.findAll();
		assertEquals(2, result.size());
	}
	
	@Test
	public void testGetContinentById(){
		List <Continent>continentList = new ArrayList<Continent>();		
		List <Country>countryAfricaList = new ArrayList<Country>();	
		List <Country>countryAmericaList = new ArrayList<Country>();
		
		countryAfricaList.add(new Country("Nigeria", "🇳🇬"));
		countryAfricaList.add(new Country("Ethiopia", "🇪🇹"));
		countryAfricaList.add(new Country("Egypt", "🇪🇬"));
		countryAfricaList.add(new Country("DR Congo", "🇨🇩"));
		countryAfricaList.add(new Country("South Africa", "🇿🇦"));		
		
		countryAmericaList.add(new Country("USA", "🇺🇸"));
		countryAmericaList.add(new Country("Brazil", "🇧🇷"));
		
		Continent continentAfrica = new Continent("Africa", countryAfricaList);
		Continent continentAmerica = new Continent("America", countryAmericaList);
		
		continentList.add(continentAfrica);
		continentList.add(continentAmerica);
		
		when(continentRepository.findByContinentName("America")).thenReturn(countryAmericaList);
		List<Country> result = continentCountriesFlagService.findByContientId("America");
		assertEquals(2, result.size());
	}	

}
