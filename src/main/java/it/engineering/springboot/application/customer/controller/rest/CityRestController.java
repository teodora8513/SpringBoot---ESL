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
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotPresentedException;
import it.engineering.springboot.application.customer.service.CityService;

@RestController
@RequestMapping(path = "/api/city")
public class CityRestController {
	private final CityService cityService;
	
	@Autowired
	public CityRestController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/{cityCode}")
	public @ResponseBody ResponseEntity<Object> findById(@PathVariable Long cityCode) {
		Optional<CityDto> cityDto=cityService.findById(cityCode);
		if(cityDto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(cityDto.get());
		}else {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("City with code " + cityCode+" does not exist!");
		}
	}
	
	@GetMapping
	public @ResponseBody ResponseEntity<List<CityDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(cityService.getAll());
	}
	
	@PostMapping
	public @ResponseBody ResponseEntity<Object> save(@RequestBody CityDto cityDto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(cityService.save(cityDto));
		} catch (MyEntityExistException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Greska kod cuvanja entiteta: " + cityDto);
		}
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<CityDto> update(@RequestBody CityDto cityDto) {
		Optional<CityDto> city= cityService.update(cityDto);
		if (city.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(city.get());
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cityDto);
		}
	}
	
	@DeleteMapping("/{cityCode}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable(name = "cityCode") Long cityCode) {
		try {
			cityService.delete(cityCode);
			return ResponseEntity.status(HttpStatus.OK).body("Deleted city with code:" + cityCode);
		} catch (MyEntityNotPresentedException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}





