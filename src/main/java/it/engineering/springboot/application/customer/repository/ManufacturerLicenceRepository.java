package it.engineering.springboot.application.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.engineering.springboot.application.customer.entity.ManufacturerLicence;
import it.engineering.springboot.application.customer.entity.ManufacturerLicenceId;

@Repository
public interface ManufacturerLicenceRepository extends JpaRepository<ManufacturerLicence, ManufacturerLicenceId> {

}
