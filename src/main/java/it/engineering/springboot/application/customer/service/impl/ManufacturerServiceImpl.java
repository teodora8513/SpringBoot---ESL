package it.engineering.springboot.application.customer.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.engineering.springboot.application.customer.dto.CityDto;
import it.engineering.springboot.application.customer.dto.ManufacturerDto;
import it.engineering.springboot.application.customer.entity.CityEntity;
import it.engineering.springboot.application.customer.entity.ManufacturerEntity;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotPresentedException;

import it.engineering.springboot.application.customer.mapper.impl.CityMapper;
import it.engineering.springboot.application.customer.mapper.impl.ManufacturerMapper;
import it.engineering.springboot.application.customer.repository.CityRepository;
import it.engineering.springboot.application.customer.repository.ManufacturerRepository;
import it.engineering.springboot.application.customer.service.CityService;
import it.engineering.springboot.application.customer.service.ManufacturerService;

@Service
@Transactional
public class ManufacturerServiceImpl implements ManufacturerService {
	private CityRepository cityRepository;
	private ManufacturerRepository manufacturerRepository;
	private CityMapper cityMapper;
	private ManufacturerMapper manufacturerMapper;

	@Autowired
	public ManufacturerServiceImpl(CityRepository cityRepository, CityMapper cityMapper,
			ManufacturerRepository manufacturerRepository, ManufacturerMapper manufacturerMapper) {
		this.cityRepository = cityRepository;
		this.cityMapper = cityMapper;
		this.manufacturerRepository = manufacturerRepository;
		this.manufacturerMapper = manufacturerMapper;
	}

	public Optional<ManufacturerDto> findById(Long id) {
		Optional<ManufacturerEntity> city = manufacturerRepository.findById(id);
		if (city.isPresent()) {
			return Optional.of(manufacturerMapper.toDto(city.get()));
		}
		return Optional.empty();
	}

	public List<ManufacturerDto> getAll() {
		List<ManufacturerEntity> entities = manufacturerRepository.findAll();
		return entities.stream().map(entity -> {
			return manufacturerMapper.toDto(entity);
		}).collect(Collectors.toList());
	}

	public ManufacturerDto save(ManufacturerDto manufacturerDto) throws MyEntityNotPresentedException {
		Optional<CityEntity> cityEntity = cityRepository.findById(manufacturerDto.getCity().getCityCode());
		if (!cityEntity.isPresent()) {
			throw new MyEntityNotPresentedException(
					"City with code " + manufacturerDto.getCity().getCityCode() + " does not exist!");
		}

		ManufacturerEntity manufacturerEntity = manufacturerRepository
				.save(manufacturerMapper.toEntity(manufacturerDto));
		return manufacturerMapper.toDto(manufacturerEntity);
	}

	public Optional<ManufacturerDto> update(ManufacturerDto manufacturerDto) throws MyEntityNotPresentedException {
		Optional<CityEntity> cityEntity = cityRepository.findById(manufacturerDto.getCity().getCityCode());
		if (!cityEntity.isPresent()) {
			throw new MyEntityNotPresentedException(
					"City with code " + manufacturerDto.getCity().getCityCode() + " does not exist!");
		}

		Optional<ManufacturerEntity> entity = manufacturerRepository.findById(manufacturerDto.getId());
		if (entity.isPresent()) {
			ManufacturerEntity manufacturerEntity = manufacturerRepository
					.save(manufacturerMapper.toEntity(manufacturerDto));
			return Optional.of(manufacturerMapper.toDto(manufacturerEntity));
		}
		// ili baciti izuzetak: pogledati save() metodu
		return Optional.empty();
	}

	public void delete(Long id) throws MyEntityNotPresentedException {
		Optional<ManufacturerEntity> entity = manufacturerRepository.findById(id);
		if (!entity.isPresent()) {
			throw new MyEntityNotPresentedException("City with code " + id + " does not exist!");
		}
		manufacturerRepository.delete(entity.get());
	}

}
