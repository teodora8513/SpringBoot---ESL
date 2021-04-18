package it.engineering.springboot.application.customer.mapper;

import it.engineering.springboot.application.customer.dto.MyDto;
import it.engineering.springboot.application.customer.entity.MyEntity;

public interface EntityDtoMapper<DTO extends MyDto, E extends MyEntity> {
	DTO toDto(E entity);
	E toEntity(DTO dto);
}
