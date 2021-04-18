package it.engineering.springboot.application.customer.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.engineering.springboot.application.customer.entity.CityEntity;
import it.engineering.springboot.application.customer.repository.CityRepository;

@Component
public class DatabaseCommandLineRunner implements CommandLineRunner {
	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("===========================================================");
		System.out.println("public class DatabaseCommandLineRunner implements CommandLineRunner");
		System.out.println("===========================================================");
		cityRepository.save(new CityEntity(22000L, "Subotica"));
		cityRepository.save(new CityEntity(11000L, "Novi Beograd"));
	}

}
