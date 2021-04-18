package it.engineering.springboot.application.customer.exception;

import it.engineering.springboot.application.customer.dto.MyDto;

public class MyEntityExistException extends MyApplicationException {

	private static final long serialVersionUID = 1L;
	
	private final MyDto entity;

	public MyEntityExistException(String message, MyDto entity) {
		super(message);
		this.entity  = entity;
	}
	
	public Object getEntity() {
		return entity;
	}
}
