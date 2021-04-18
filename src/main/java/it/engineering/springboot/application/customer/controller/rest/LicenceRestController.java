package it.engineering.springboot.application.customer.controller.rest;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

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

import it.engineering.springboot.application.customer.dto.LicenceDto;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotPresentedException;
import it.engineering.springboot.application.customer.service.LicenceService;

@RestController
@RequestMapping(path = "/api/manufacturer")
public class LicenceRestController {

	private final LicenceService licenceService;

	@Autowired
	public LicenceRestController(LicenceService licenceService) {
		super();
		this.licenceService = licenceService;
	}

	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> findById(@PathVariable Long id) {
		Optional<LicenceDto> dto = licenceService.findById(id);
		if (dto.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(dto);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Licence with id: " + id + " doesnt exist!");
		}
	}

	@GetMapping
	public @ResponseBody ResponseEntity<List<LicenceDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(licenceService.getAll());
	}

	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable Long id) {

		try {
			licenceService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Deleted licence with id: " + id);
		} catch (MyEntityNotPresentedException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Licence doesnt exist!");
		}
	}

	@PostMapping
	public @ResponseBody ResponseEntity<Object> save(@RequestBody LicenceDto dto) {
		try {
			licenceService.save(dto);
			return ResponseEntity.status(HttpStatus.OK).body(dto);

		} catch (MyEntityExistException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Coudnt save licence");
		}
	}
		@PutMapping
		public @ResponseBody ResponseEntity<Object> update(@RequestBody LicenceDto dto){
			try {
				licenceService.update(dto);
				return ResponseEntity.status(HttpStatus.OK).body(dto);
			} catch (MyEntityNotPresentedException e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Licence coudnt be updated");
			}
			
		}
		
	}


