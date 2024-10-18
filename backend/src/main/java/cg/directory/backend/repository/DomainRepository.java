package cg.directory.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cg.directory.backend.entity.Domain;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Long>{

}
