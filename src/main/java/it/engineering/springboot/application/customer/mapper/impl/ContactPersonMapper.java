package it.engineering.springboot.application.customer.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.springboot.application.customer.dto.ContactPersonDto;
import it.engineering.springboot.application.customer.entity.ContactPerson;
import it.engineering.springboot.application.customer.mapper.EntityDtoMapper;

@Component
public class ContactPersonMapper implements EntityDtoMapper<ContactPersonDto, ContactPerson> {

	private ManufacturerMapper manMapper;

	@Autowired
	public ContactPersonMapper(ManufacturerMapper manMapper) {
		this.manMapper = manMapper;
	}

	@Override
	public ContactPersonDto toDto(ContactPerson entity) {
		return new ContactPersonDto(entity.getId(), entity.getFirstname(), entity.getLastname(),
				manMapper.toDto(entity.getManufacturer()));
	}

	@Override
	public ContactPerson toEntity(ContactPersonDto dto) {
		return new ContactPerson(dto.getId(), dto.getFirstname(), dto.getLastname(),
				manMapper.toEntity(dto.getManufacturer()));
	}

}
