package it.engineering.springboot.application.customer.dto;

import it.engineering.springboot.application.customer.entity.ManufacturerEntity;

public class ContactPersonDto implements MyDto {

	private Long id;
	private String firstname;
	private String lastname;
	private ManufacturerDto manufacturer;

	public ContactPersonDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactPersonDto(Long id, String firstname, String lastname, ManufacturerDto manufacturer) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.manufacturer = manufacturer;
	}

	public ManufacturerDto getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ManufacturerDto manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "ContactPersonDto [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", manufacturer="
				+ manufacturer + "]";
	}

}
