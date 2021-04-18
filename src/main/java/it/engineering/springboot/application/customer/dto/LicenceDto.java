package it.engineering.springboot.application.customer.dto;

import java.util.Set;

import it.engineering.springboot.application.customer.entity.ManufacturerLicence;

public class LicenceDto implements MyDto{

	private Long id;
	private String name;
	private Set<ManufacturerLicenceDto> manLicencesDto;

	public LicenceDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LicenceDto(Long id, String name, Set<ManufacturerLicenceDto> manLicences) {
		super();
		this.id = id;
		this.name = name;
		this.manLicencesDto = manLicences;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ManufacturerLicenceDto> getManLicences() {
		return manLicencesDto;
	}

	public void setManLicences(Set<ManufacturerLicenceDto> manLicences) {
		this.manLicencesDto = manLicences;
	}

	@Override
	public String toString() {
		return "LicenceDto [id=" + id + ", name=" + name + ", manLicences=" + manLicencesDto + "]";
	}

}
