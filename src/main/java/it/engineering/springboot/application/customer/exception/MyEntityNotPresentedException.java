package it.engineering.springboot.application.customer.exception;

import it.engineering.springboot.application.customer.dto.MyDto;

public class MyEntityNotPresentedException extends MyApplicationException {

	private static final long serialVersionUID = 1L;
	
	public MyEntityNotPresentedException(String message) {
		super(message);
	}
	
}
