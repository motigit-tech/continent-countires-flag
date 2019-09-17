package com.quest.continents.country.flag.poc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.quest.continents.country.flag.poc.model.Country;



@Repository
public interface CountryRepository extends MongoRepository<Country, String> {
	
}
