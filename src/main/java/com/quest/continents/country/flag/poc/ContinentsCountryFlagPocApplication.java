/**
 * 
 */
package com.quest.continents.country.flag.poc;

/**
 * @author Moti
 *
 */
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.quest.continents.country.flag.poc.document.ContinentDocument;
import com.quest.continents.country.flag.poc.document.CountryDocument;
import com.quest.continents.country.flag.poc.repository.ContinentRepository;
import com.quest.continents.country.flag.poc.repository.CountryRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class ContinentsCountryFlagPocApplication {

	private static final Logger log =  LoggerFactory.getLogger(ContinentsCountryFlagPocApplication.class);
	
	public static void main(String[] args) {
		
		log.debug("Continent context loading...");
		SpringApplication.run(ContinentsCountryFlagPocApplication.class, args);
		log.debug("Continent context loaded...");
	}
	
	 	@Bean
	    CommandLineRunner init(ContinentRepository continentRepository, CountryRepository countryRepository) {
	 		
	 		
	 		 		 		
	 		ContinentDocument cd = new ContinentDocument();	 		
	 		cd.setContinent("America");
	 		
	 		continentRepository.save(cd);
	 		/* ContinentDocument cd = continentRepository.findByContinentName("Africa").get(0);
	 		CountryDocument countryDocument = new CountryDocument();
	 		countryDocument.setContinentId(cd.getContinentId());
	 		countryDocument.setName("South Africa");
	 		countryDocument.setFlag("🇿🇦");
	 		countryRepository.save(countryDocument);
	 		*/
	 		System.out.println("Result: "+continentRepository.findByContinentName("Africa").toString());

	        return args -> {

	        	 List<ContinentDocument>list =  continentRepository.findAll();
	            
	            list.forEach((c) -> {
	            	System.out.println(c.getContinent());
	            	});                    

	        };
	 	}
	             

}

