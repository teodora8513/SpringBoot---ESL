package it.engineering.springboot.application.customer.dto;

import java.util.Date;

import it.engineering.springboot.application.customer.entity.ManufacturerLicenceId;

public class ManufacturerLicenceDto implements MyDto {

	private ManufacturerLicenceId pk;

	private Date createdDate;

	public ManufacturerLicenceDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ManufacturerLicenceDto(ManufacturerLicenceId pk, Date createdDate) {
		super();
		this.pk = pk;
		this.createdDate = createdDate;
	}

	public ManufacturerLicenceId getPk() {
		return pk;
	}

	public void setPk(ManufacturerLicenceId pk) {
		this.pk = pk;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "ManufacturerLicenceDto [pk=" + pk + ", createdDate=" + createdDate + "]";
	}

}
