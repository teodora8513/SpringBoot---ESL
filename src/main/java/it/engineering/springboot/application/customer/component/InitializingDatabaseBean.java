package it.engineering.springboot.application.customer.component;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.springboot.application.customer.entity.CityEntity;
import it.engineering.springboot.application.customer.repository.CityRepository;

@Component
public class InitializingDatabaseBean implements InitializingBean{
	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("===========================================================");
		System.out.println("public void afterPropertiesSet() throws Exception");
		System.out.println("===========================================================");
		
		cityRepository.save(new CityEntity(21000L, "Novi Sad"));
		cityRepository.save(new CityEntity(17000L, "Vranje"));
	}

}
