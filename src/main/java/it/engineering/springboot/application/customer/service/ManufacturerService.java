package it.engineering.springboot.application.customer.service;

import java.util.List;
import java.util.Optional;

import it.engineering.springboot.application.customer.dto.ManufacturerDto;
import it.engineering.springboot.application.customer.exception.MyEntityNotPresentedException;

public interface ManufacturerService {
	Optional<ManufacturerDto> findById(Long id);
	List<ManufacturerDto> getAll();
	ManufacturerDto save(ManufacturerDto manufacturerDto) throws MyEntityNotPresentedException;
	Optional<ManufacturerDto> update(ManufacturerDto manufacturerDto) throws MyEntityNotPresentedException;
	void delete(Long id) throws MyEntityNotPresentedException;
}
