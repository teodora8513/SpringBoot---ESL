package it.engineering.springboot.application.customer.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Embeddable
public class ManufacturerLicenceId implements Serializable{

	@ManyToOne
	private ManufacturerEntity manufacturer;
	@ManyToOne
	private Licence licence;
	
	
	public ManufacturerLicenceId() {
		
	}


	
	public ManufacturerEntity getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(ManufacturerEntity manufacturer) {
		this.manufacturer = manufacturer;
	}


	public Licence getLicence() {
		return licence;
	}


	public void setLicence(Licence licence) {
		this.licence = licence;
	}
	
	
}
