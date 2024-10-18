package cg.directory.backend.services;

import java.util.List;

import cg.directory.backend.dto.EmployeeDTO;
import cg.directory.backend.entity.Employee;


public interface EmployeeService {

    public List<EmployeeDTO> getAllEmployees();
    public List<EmployeeDTO> createEmployees(List<Employee> employees);
    public EmployeeDTO deleteEmployee(Employee employee); 
    public EmployeeDTO updatedomain(Employee employee);
}
