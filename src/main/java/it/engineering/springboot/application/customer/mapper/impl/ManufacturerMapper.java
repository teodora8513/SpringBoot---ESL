package it.engineering.springboot.application.customer.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.springboot.application.customer.dto.ManufacturerDto;
import it.engineering.springboot.application.customer.entity.ManufacturerEntity;
import it.engineering.springboot.application.customer.mapper.EntityDtoMapper;
import it.engineering.springboot.application.customer.mapper.impl.CityMapper;

@Component
public class ManufacturerMapper implements EntityDtoMapper<ManufacturerDto, ManufacturerEntity> {
	private CityMapper cityMapper;
	@Autowired
	public ManufacturerMapper(CityMapper cityMapper) {
		this.cityMapper = cityMapper;
	}
	
	@Override
	public ManufacturerDto toDto(ManufacturerEntity entity) {
		return new ManufacturerDto(
				entity.getId(),
				entity.getName(), cityMapper.toDto(entity.getCity()));
	}

	@Override
	public ManufacturerEntity toEntity(ManufacturerDto dto) {
		return new ManufacturerEntity(
				dto.getId(),
				dto.getName(),
				cityMapper.toEntity(dto.getCity()));
	}

}
