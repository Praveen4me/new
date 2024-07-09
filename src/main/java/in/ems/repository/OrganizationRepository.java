package in.ems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ems.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Integer>{
	   boolean existsById(Integer id);
	   Optional<Organization> findById(Integer id);

}
