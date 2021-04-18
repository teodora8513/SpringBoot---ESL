package it.engineering.springboot.application.customer.service;

import java.util.List;
import java.util.Optional;

import it.engineering.springboot.application.customer.dto.ContactPersonDto;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotPresentedException;

public interface ContactPersonService {

	Optional<ContactPersonDto> findById(Long id);

	List<ContactPersonDto> getAll();

	ContactPersonDto save(ContactPersonDto dto) throws MyEntityExistException, MyEntityNotPresentedException;

	ContactPersonDto update(ContactPersonDto dto) throws MyEntityNotPresentedException;

	void delete(Long id) throws MyEntityNotPresentedException;
}
