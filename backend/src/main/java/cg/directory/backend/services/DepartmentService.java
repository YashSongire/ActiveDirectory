package cg.directory.backend.services;

import java.util.List;

import cg.directory.backend.dto.DepartmentDTO;
import cg.directory.backend.entity.Department;


public interface DepartmentService {
    
    public List<DepartmentDTO> getAllDepartments();
    public List<DepartmentDTO> createDepartments(List<Department> departments);
    public DepartmentDTO deleteDepartment(Department department); 
    public DepartmentDTO updatedomain(Department department);

}
