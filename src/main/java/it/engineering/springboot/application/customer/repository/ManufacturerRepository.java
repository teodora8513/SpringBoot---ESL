package it.engineering.springboot.application.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.engineering.springboot.application.customer.entity.ManufacturerEntity;

@Repository
public interface ManufacturerRepository extends JpaRepository<ManufacturerEntity, Long>{

}
