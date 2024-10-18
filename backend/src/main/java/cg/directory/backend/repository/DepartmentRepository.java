package cg.directory.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cg.directory.backend.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{

}
