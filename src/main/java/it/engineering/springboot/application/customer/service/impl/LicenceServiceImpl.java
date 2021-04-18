package it.engineering.springboot.application.customer.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.xml.bind.v2.TODO;

import it.engineering.springboot.application.customer.dto.LicenceDto;
import it.engineering.springboot.application.customer.entity.Licence;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotPresentedException;
import it.engineering.springboot.application.customer.mapper.impl.LicenceMapper;
import it.engineering.springboot.application.customer.mapper.impl.ManufacturerLicenceMapper;
import it.engineering.springboot.application.customer.repository.LicenceRepository;
import it.engineering.springboot.application.customer.repository.ManufacturerLicenceRepository;
import it.engineering.springboot.application.customer.service.LicenceService;

@Service
@Transactional
public class LicenceServiceImpl implements LicenceService {

	private LicenceMapper licenceMapper;
	private ManufacturerLicenceMapper manLicenceMapper;
	private LicenceRepository licenceRepository;
	private ManufacturerLicenceRepository manLicenceRepository;
	
	@Autowired
	public LicenceServiceImpl(LicenceMapper licenceMapper, ManufacturerLicenceMapper manLicenceMapper,
			LicenceRepository licenceRepository, ManufacturerLicenceRepository manLicenceRepository) {
		super();
		this.licenceMapper = licenceMapper;
		this.manLicenceMapper = manLicenceMapper;
		this.licenceRepository = licenceRepository;
		this.manLicenceRepository = manLicenceRepository;
	}

	@Override
	public Optional<LicenceDto> findById(Long id) {
		Optional<Licence> entity = licenceRepository.findById(id);
		if(!entity.isPresent()) {
			return Optional.empty();
		}
		else {
			return Optional.of(licenceMapper.toDto(entity.get()));
		}
	}

	@Override
	public List<LicenceDto> getAll() {
		List<Licence> entity = licenceRepository.findAll();
		return entity.stream().map(e->{
			return licenceMapper.toDto(e);
		}).collect(Collectors.toList());
	}

	@Override
	public LicenceDto save(LicenceDto dto) throws MyEntityExistException {
		Optional<Licence> entity = licenceRepository.findById(dto.getId());
		if(entity.isPresent()) {
			throw new MyEntityExistException("Licence with id " + dto.getId()+" already exist", dto);
		}
		//TODO: ManufacturerLicence set
		//////////////////////////////////////////////////////////////////////////////////////////////
		Licence licence = licenceRepository.save(licenceMapper.toEntity(dto));
		return dto;
	}

	@Override
	public LicenceDto update(LicenceDto dto) throws MyEntityNotPresentedException {
		Optional<Licence> entity = licenceRepository.findById(dto.getId());
		if(!entity.isPresent()) {
			throw new MyEntityNotPresentedException("Licence with id: " + dto.getId() + " doesnt exist!");
		}
		//TODO: ManufacturerLicence set
		//////////////////////////////////////////////////////////////////////////////////////////////
		Licence licence = licenceRepository.save(licenceMapper.toEntity(dto));
		return dto;
	}

	@Override
	public void delete(Long id) throws MyEntityNotPresentedException {
		Optional<Licence> entity = licenceRepository.findById(id);
		if(!entity.isPresent()) {
			throw new MyEntityNotPresentedException("Licence with id: " + id + " doesnt exist");
		}

		else {
			
			licenceRepository.deleteById(id);
		}
	}

}
