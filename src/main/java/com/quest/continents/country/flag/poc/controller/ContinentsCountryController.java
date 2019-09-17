package com.quest.continents.country.flag.poc.controller;
/*
 * This controller is going to provide to returns continent's country flag and count
 */

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quest.continents.country.flag.poc.model.Continent;
import com.quest.continents.country.flag.poc.model.Country;
import com.quest.continents.country.flag.poc.model.SearchCriteria;
import com.quest.continents.country.flag.poc.service.impl.ContinentCountriesFlagService;
import com.quest.continents.country.flag.poc.util.annotation.AuditAndMeter;
import com.quest.continents.country.flag.poc.util.annotation.AuditAndMeterInterceptor;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
@AuditAndMeter(value = {AuditAndMeterInterceptor.class})
public class ContinentsCountryController {
	
    @Autowired
	ContinentCountriesFlagService continentCountriesFlagService;
		
	@RequestMapping(value = "/continents", method = RequestMethod.GET, 
	headers="Accept=application/json",consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json; charset=UTF-8")
	public List<Continent> getAllContinentFlag() {
		return continentCountriesFlagService.findAll();
	}
	
	@RequestMapping(value = "/continents/{continent}", method = RequestMethod.GET, 
	headers="Accept=application/json",consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json; charset=UTF-8")
	public List<Country> getContinentCountiresFlag(@PathVariable("continet") String continetName) {
		return continentCountriesFlagService.findByContientId(continetName);
	}
	
	@RequestMapping(value = "/country/{country}", method = RequestMethod.GET, 
	headers="Accept=application/json",consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json; charset=UTF-8")
	public Country getCountryFlag(@PathVariable("country") String countryName) {
		return continentCountriesFlagService.findByCountryId(countryName);
	}
	

	@RequestMapping(value = "/", method = { RequestMethod.GET,
			RequestMethod.POST }, headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = "application/json; charset=UTF-8")
	public ResponseEntity<?> getContinentFlags(@Valid @RequestBody SearchCriteria searchCriteria) {
		Optional<SearchCriteria> checkSearchCriteriaNull = Optional.ofNullable(searchCriteria);
		if (!checkSearchCriteriaNull.isPresent() || null == checkSearchCriteriaNull.get().getFieldName()) {
			
			return new ResponseEntity<List<Continent>>(continentCountriesFlagService.findAll(), HttpStatus.OK);

		} else if (checkSearchCriteriaNull.get().getFieldName().equals("continent")) {

			return new ResponseEntity<List<Country>>(
					continentCountriesFlagService.findByContientId(checkSearchCriteriaNull.get().getFieldValue()),
					HttpStatus.OK);

		} else if (checkSearchCriteriaNull.get().getFieldName().equals("country")) {

			return new ResponseEntity<Country>(
					continentCountriesFlagService.findByCountryId(checkSearchCriteriaNull.get().getFieldValue()),
					HttpStatus.OK);

		} else {
			return new ResponseEntity<String>("Not Found", HttpStatus.OK);
		}

	}

}
