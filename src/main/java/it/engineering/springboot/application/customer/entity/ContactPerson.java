package it.engineering.springboot.application.customer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "contact_person")
public class ContactPerson implements MyEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstname;
	private String lastname;

	@ManyToOne
	@JoinColumn(name="manufacturer_id")
	private ManufacturerEntity manufacturer;
	
	public ManufacturerEntity getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ManufacturerEntity manufacturer) {
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

	public ContactPerson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactPerson(Long id, String firstname, String lastname, ManufacturerEntity manufacturer) {
		super();
		this.manufacturer = manufacturer;
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

}
