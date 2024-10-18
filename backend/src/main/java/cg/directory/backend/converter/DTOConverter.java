package cg.directory.backend.converter;

import cg.directory.backend.dto.DepartmentDTO;
import cg.directory.backend.dto.DomainDTO;
import cg.directory.backend.dto.EmployeeDTO;
import cg.directory.backend.dto.ManagerDTO;
import cg.directory.backend.entity.Department;
import cg.directory.backend.entity.Domain;
import cg.directory.backend.entity.Employee;

public class DTOConverter {

    // Set Domain
    public static DomainDTO domainConvert(Domain domain) {
        DomainDTO dto = new DomainDTO();
        dto.setId(domain.getId());
        dto.setName(domain.getName());
        return dto;
    }

    // Set Department
    public static DepartmentDTO departmentConvert(Department department) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setId(department.getId());
        dto.setName(department.getName());
        DomainDTO domaindto = domainConvert(department.getDomain());
        dto.setDomain(domaindto);
        return dto;
    }

    // Set Manager
    public static ManagerDTO managerConvert(Employee manager) {
        ManagerDTO dto = new ManagerDTO();
        dto.setId(manager.getId());
        dto.setName(manager.getName());
        return dto;
    }

    // Set Employee
    public static EmployeeDTO employeeConvert(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setAddress(employee.getAddress());
        dto.setCountry(employee.getCountry());
        dto.setDesignation(employee.getDesignation());
        dto.setEmail(employee.getEmail());
        dto.setStatus(employee.getStatus());
        DepartmentDTO departmentdto = departmentConvert(employee.getDepartment());
        dto.setDepartment(departmentdto);
        if(employee.getManager() != null){
            ManagerDTO managerdto = managerConvert(employee.getManager());
            dto.setManager(managerdto);
        }else{
            dto.setManager(null);
        }
        return dto;
    }
}