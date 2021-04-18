package it.engineering.springboot.application.customer.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "manufacturer_entity")
public class ManufacturerLicence implements Serializable, MyEntity {

	@EmbeddedId
	private ManufacturerLicenceId pk = new ManufacturerLicenceId();

	private Date createdDate;

	public ManufacturerLicence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ManufacturerLicence(ManufacturerLicenceId pk/*, ManufacturerEntity manufacturer_id, Licence licence_id,*/,
			Date createdDate) {
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

}
