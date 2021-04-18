package it.engineering.springboot.application.customer.component;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import it.engineering.springboot.application.customer.entity.CityEntity;
import it.engineering.springboot.application.customer.repository.CityRepository;

@Component
public class InitDatabase {
	@Autowired
	private CityRepository cityRepository;
	
	@Bean
	InitializingBean init() {
		System.out.println("===========================================================");
		System.out.println("InitializingBean init()");
		System.out.println("===========================================================");
		
		return ()->{
			cityRepository.save(new CityEntity(28000L, "Kosovska Mitrovica"));
			cityRepository.save(new CityEntity(19000L, "City 19000"));
		};
	}
}
