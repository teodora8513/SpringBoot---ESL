package it.engineering.springboot.application.customer.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.engineering.springboot.application.customer.dto.ContactPersonDto;
import it.engineering.springboot.application.customer.entity.ContactPerson;
import it.engineering.springboot.application.customer.entity.ManufacturerEntity;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotPresentedException;
import it.engineering.springboot.application.customer.mapper.impl.ContactPersonMapper;
import it.engineering.springboot.application.customer.mapper.impl.ManufacturerMapper;
import it.engineering.springboot.application.customer.repository.ContactPersonRepository;
import it.engineering.springboot.application.customer.repository.ManufacturerRepository;

@Service
@Transactional
public class ContactPersonServiceImpl
		implements it.engineering.springboot.application.customer.service.ContactPersonService {

	private ContactPersonRepository contactPersonRepository;
	private ContactPersonMapper contactPersonMapper;
	private ManufacturerRepository manufacturerRepository;
	private ManufacturerMapper manufacturerMapper;

	@Autowired
	public ContactPersonServiceImpl(ContactPersonRepository contactPersonRepository,
			ManufacturerRepository manufacturerRepository, ContactPersonMapper contactPersonMapper, ManufacturerMapper manufacturerMapper) {
		super();
		this.contactPersonRepository = contactPersonRepository;
		this.manufacturerRepository = manufacturerRepository;
		this.contactPersonMapper = contactPersonMapper;
		this.manufacturerMapper = manufacturerMapper;
	}

	@Override
	public Optional<ContactPersonDto> findById(Long id) {
		Optional<ContactPerson> entity = contactPersonRepository.findById(id);
		if (entity.isPresent()) {
			return Optional.of(contactPersonMapper.toDto(entity.get()));
		}
		return Optional.empty();
	}

	@Override
	public List<ContactPersonDto> getAll() {
		List<ContactPerson> entities = contactPersonRepository.findAll();
		return entities.stream().map(entity -> {
			return contactPersonMapper.toDto(entity);
		}).collect(Collectors.toList());
	}

	@Override
	public ContactPersonDto save(ContactPersonDto dto) throws MyEntityExistException, MyEntityNotPresentedException {
		Optional<ContactPerson> entity = contactPersonRepository.findById(dto.getId());
		if (entity.isPresent()) {
			throw new MyEntityExistException("Contact person with id " + dto.getId() + " already exists!", dto);
			
		}
		Optional<ManufacturerEntity> manEntity = Optional.of(manufacturerMapper.toEntity(dto.getManufacturer()));
		if(manEntity.isPresent()) {
			ContactPerson cp = contactPersonRepository.save(contactPersonMapper.toEntity(dto));
			return dto;
		}
		else {
			throw new MyEntityNotPresentedException("Manufacturer with the id " + manEntity.get().getId() + " doesnt exist!");
		}
		
	}

	@Override
	public ContactPersonDto update(ContactPersonDto dto) throws MyEntityNotPresentedException {
		Optional<ContactPerson> entity = contactPersonRepository.findById(dto.getId());
		if(!entity.isPresent()) {
			throw new MyEntityNotPresentedException("Contact person with the id " + dto.getId()+ " doesnt exist!");
		}
		Optional<ManufacturerEntity> manEntity = Optional.of(manufacturerMapper.toEntity(dto.getManufacturer()));
		if(manEntity.isPresent()) {
			ContactPerson cp = contactPersonRepository.save(contactPersonMapper.toEntity(dto));
			return dto;
		}
		else {
			throw new MyEntityNotPresentedException("Manufacturer doesnt exist");
		}
	}

	@Override
	public void delete(Long id) throws MyEntityNotPresentedException {
		Optional<ContactPerson> entity = contactPersonRepository.findById(id);
		if (!entity.isPresent()) {
			throw new MyEntityNotPresentedException("Contact person with id: " + id + " is not present!");
		}
		contactPersonRepository.deleteById(id);
	}

}
