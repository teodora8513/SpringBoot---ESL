package it.engineering.springboot.application.customer.exception;

public class MyApplicationException extends Exception{

	private static final long serialVersionUID = 1L;

	public MyApplicationException(String messsage) {
		super(messsage);
	}
}
