package it.engineering.springboot.application.customer.service;

import java.util.List;
import java.util.Optional;

import it.engineering.springboot.application.customer.dto.CityDto;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotPresentedException;

public interface CityService {
	Optional<CityDto> findById(Long cityCode);
	List<CityDto> getAll();
	CityDto save(CityDto cityDto) throws MyEntityExistException;
	Optional<CityDto> update(CityDto cityDto);
	void delete(Long cityCode) throws MyEntityNotPresentedException;
}
