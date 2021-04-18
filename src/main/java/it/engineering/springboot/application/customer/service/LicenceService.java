package it.engineering.springboot.application.customer.service;

import java.util.List;
import java.util.Optional;

import it.engineering.springboot.application.customer.dto.LicenceDto;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotPresentedException;



public interface LicenceService {

	Optional<LicenceDto> findById(Long id);
	List<LicenceDto> getAll();
	LicenceDto save(LicenceDto dto) throws MyEntityExistException;
	LicenceDto update(LicenceDto dto) throws MyEntityNotPresentedException;
	void delete(Long id) throws MyEntityNotPresentedException ;
}
