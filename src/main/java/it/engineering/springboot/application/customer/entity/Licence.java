package it.engineering.springboot.application.customer.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "licence")
public class Licence implements Serializable, MyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.licence")
	private Set<ManufacturerLicence> manLicences;

	public Licence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Licence(Long id, String name, Set<ManufacturerLicence> manLicences) {
		super();
		this.id = id;
		this.name = name;
		this.manLicences = manLicences;
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

	public Set<ManufacturerLicence> getManLicences() {
		return manLicences;
	}

	public void setManLicences(Set<ManufacturerLicence> manLicences) {
		this.manLicences = manLicences;
	}

}
