package it.engineering.springboot.application.customer.mapper.impl;

import org.springframework.stereotype.Component;

import it.engineering.springboot.application.customer.dto.ManufacturerLicenceDto;
import it.engineering.springboot.application.customer.entity.ManufacturerLicence;
import it.engineering.springboot.application.customer.mapper.EntityDtoMapper;

@Component
public class ManufacturerLicenceMapper implements EntityDtoMapper<ManufacturerLicenceDto, ManufacturerLicence>{

	@Override
	public ManufacturerLicenceDto toDto(ManufacturerLicence entity) {
		
		return new ManufacturerLicenceDto(entity.getPk(), entity.getCreatedDate());
	}

	@Override
	public ManufacturerLicence toEntity(ManufacturerLicenceDto dto) {
		return new ManufacturerLicence(dto.getPk(), dto.getCreatedDate());
	}

	
}
