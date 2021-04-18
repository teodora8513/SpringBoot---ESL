package it.engineering.springboot.application.customer.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.engineering.springboot.application.customer.dto.CityDto;
import it.engineering.springboot.application.customer.dto.ManufacturerDto;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotPresentedException;
import it.engineering.springboot.application.customer.service.CityService;
import it.engineering.springboot.application.customer.service.ManufacturerService;

@RestController
@RequestMapping(path = "/api/manufacturer")
public class ManufacturerRestController {
	private final ManufacturerService manufacturerService;
	
	@Autowired
	public ManufacturerRestController(ManufacturerService manufacturerService) {
		this.manufacturerService = manufacturerService;
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> findById(@PathVariable Long id) {
		Optional<ManufacturerDto> manufacturerDto=manufacturerService.findById(id);
		if(manufacturerDto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(manufacturerDto.get());
		}else {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Manufacture with id " + id+" does not exist!");
		}
	}
	
	@GetMapping
	public @ResponseBody ResponseEntity<List<ManufacturerDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(manufacturerService.getAll());
	}
	
	@PostMapping
	public @ResponseBody ResponseEntity<Object> save(@RequestBody ManufacturerDto manufacturerDto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(manufacturerService.save(manufacturerDto));
		} catch (MyEntityNotPresentedException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error to save: " + manufacturerDto);
		}
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<ManufacturerDto> update(@RequestBody ManufacturerDto manufacturerDto) {
		Optional<ManufacturerDto> city;
		try {
			city = manufacturerService.update(manufacturerDto);
			
			if (city.isPresent()) {
				return ResponseEntity.status(HttpStatus.OK).body(city.get());
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(manufacturerDto);
			}
		} catch (MyEntityNotPresentedException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(manufacturerDto);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
		try {
			manufacturerService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Deleted manufacture with code:" + id);
		} catch (MyEntityNotPresentedException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}





