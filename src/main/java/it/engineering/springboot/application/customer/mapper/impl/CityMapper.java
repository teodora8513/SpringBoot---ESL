package it.engineering.springboot.application.customer.mapper.impl;

import org.springframework.stereotype.Component;

import it.engineering.springboot.application.customer.dto.CityDto;
import it.engineering.springboot.application.customer.entity.CityEntity;
import it.engineering.springboot.application.customer.mapper.EntityDtoMapper;


@Component
public class CityMapper implements EntityDtoMapper<CityDto, CityEntity>  {

	@Override
	public CityDto toDto(CityEntity entity) {
		return new CityDto(entity.getCode(), entity.getName());
	}

	@Override
	public CityEntity toEntity(CityDto dto) {
		return new CityEntity(dto.getCityCode(), dto.getCityName());
	}
	
}
