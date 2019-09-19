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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	//private static final Logger log =  LoggerFactory.getLogger(ContinentsCountryController.class);
    @Autowired
	ContinentCountriesFlagService continentCountriesFlagService;
		
	@GetMapping(path = "/continents",consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json; charset=UTF-8")
	public List<Continent> getAllContinentFlag() {
		return continentCountriesFlagService.findAll();
	}
	
	@GetMapping(path =  "/continents/{continent}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json; charset=UTF-8")
	public List<Country> getContinentCountiresFlag(@PathVariable("continet") String continetName) {
		return continentCountriesFlagService.findByContientId(continetName);
	}
	
	@GetMapping(path = "/country/{country}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json; charset=UTF-8")
	public Country getCountryFlag(@PathVariable("country") String countryName) {
		return continentCountriesFlagService.findByCountryId(countryName);
	}
	
     /*
      * getContinentCountriesFlag: It's generic rest api service which has providing continent's country
      *  and specific country flag.
      *  @RequestBody SearchCriteria
      *  @Return Json response
      */
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = "application/json; charset=UTF-8")
	public ResponseEntity<?> getContinentCountriesFlag(@Valid @RequestBody SearchCriteria searchCriteria) {
		
		//log.info("ContinentsCountryController::getContinentCountriesFlag: start");
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