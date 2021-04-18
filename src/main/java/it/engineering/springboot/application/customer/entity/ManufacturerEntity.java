package it.engineering.springboot.application.customer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "manufacturer")
@NamedQueries({
	@NamedQuery(name = "ManufacturerEntity.getAll",query = "SELECT m FROM ManufacturerEntity m ORDER BY m.name"),
	@NamedQuery(name = "ManufacturerEntity.filterByCity",
				query = "SELECT m FROM ManufacturerEntity m WHERE m.city = :city ORDER BY m.name")
	
})

public class ManufacturerEntity implements MyEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "city_code")
	private CityEntity city;
	
	public ManufacturerEntity() {
	}

	public ManufacturerEntity(Long id, String name, CityEntity city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
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

	public CityEntity getCity() {
		return city;
	}

	public void setCity(CityEntity city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "ManufacturerEntity [id=" + id + ", name=" + name + ", city=" + city + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManufacturerEntity other = (ManufacturerEntity) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
