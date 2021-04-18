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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import it.engineering.springboot.application.customer.dto.ContactPersonDto;
import it.engineering.springboot.application.customer.exception.MyEntityExistException;
import it.engineering.springboot.application.customer.exception.MyEntityNotPresentedException;
import it.engineering.springboot.application.customer.service.ContactPersonService;

@RestController
@RequestMapping("/api/contact-person")
public class ContactPersonRestController {

	private final ContactPersonService cpService;
	@Autowired
	public ContactPersonRestController(ContactPersonService cpService) {
		super();
		this.cpService = cpService;
	};
	
	@GetMapping
	public @ResponseBody ResponseEntity<List<ContactPersonDto>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(cpService.getAll());
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<Object> findById(@PathVariable (name="id") Long id){
		Optional<ContactPersonDto> dto =  cpService.findById(id);
		if(dto.isPresent())
			return ResponseEntity.status(HttpStatus.OK).body(dto);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could find contact person with id: " + id);
	}
	
	@PostMapping
	public @ResponseBody ResponseEntity<Object> save(@RequestBody ContactPersonDto dto){
		try {
			cpService.save(dto);
			return ResponseEntity.status(HttpStatus.OK).body(dto);
		} catch (MyEntityExistException | MyEntityNotPresentedException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cant save contact person!");
		}
	}
	
	@PutMapping
	public @ResponseBody ResponseEntity<Object> update(@RequestBody ContactPersonDto dto){
		try {
			cpService.update(dto);
			return ResponseEntity.status(HttpStatus.OK).body(dto);
		} catch (MyEntityNotPresentedException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cant update contact person!");
		}
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
		try {
			cpService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body("Deleted contact person with code:" + id);
		} catch (MyEntityNotPresentedException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
