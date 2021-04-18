package it.engineering.springboot.application.customer.mapper.impl;

import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.springboot.application.customer.dto.LicenceDto;
import it.engineering.springboot.application.customer.dto.ManufacturerLicenceDto;
import it.engineering.springboot.application.customer.entity.Licence;
import it.engineering.springboot.application.customer.entity.ManufacturerLicence;
import it.engineering.springboot.application.customer.mapper.EntityDtoMapper;

@Component
public class LicenceMapper implements EntityDtoMapper<LicenceDto, Licence> {


	private ManufacturerLicenceMapper manLicenceMapper;
	
	@Autowired
	public LicenceMapper( ManufacturerLicenceMapper manLicenceMapper) {
		
		this.manLicenceMapper = manLicenceMapper;
	}
	
	@Override
	public LicenceDto toDto(Licence entity) {
		
		
		return new LicenceDto(entity.getId(), entity.getName(), entity.getManLicences().stream().map(e->{
			return manLicenceMapper.toDto(e);}).collect(Collectors.toSet()));
	}

	@Override
	public Licence toEntity(LicenceDto dto) {
		return new Licence(dto.getId(), dto.getName(), dto.getManLicences().stream().map(e->{
			return manLicenceMapper.toEntity(e);}).collect(Collectors.toSet()));
	}

}
