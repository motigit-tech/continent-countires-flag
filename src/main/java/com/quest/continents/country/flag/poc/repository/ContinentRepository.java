package com.quest.continents.country.flag.poc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.quest.continents.country.flag.poc.model.Continent;
import com.quest.continents.country.flag.poc.model.Country;



@Repository
public interface ContinentRepository extends MongoRepository<Continent, String> {
	
	@Query(value = "{ 'continent' : ?0}")
	List<Country> findByContinentName(final String continent);

	  @Query("{'countries.country': ?0}")
	  Country findByCountry(final String country);

	
}