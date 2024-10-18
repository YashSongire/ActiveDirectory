package cg.directory.backend.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cg.directory.backend.converter.DTOConverter;
import cg.directory.backend.dto.EmployeeDTO;
import cg.directory.backend.entity.Department;
import cg.directory.backend.entity.Employee;
import cg.directory.backend.exception.ResourceNotFoundException;
import cg.directory.backend.repository.DepartmentRepository;
import cg.directory.backend.repository.EmployeeRepository;
import cg.directory.backend.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository emprepo;

    @Autowired
    private DepartmentRepository deptrepo;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> empdto = new ArrayList<EmployeeDTO>();
        List<Employee> employees = emprepo.findAll();
        for (Employee emp : employees) {
            EmployeeDTO addempdto = DTOConverter.employeeConvert(emp);
            empdto.add(addempdto);
        }
        return empdto;
    }

    @Override
    public List<EmployeeDTO> createEmployees(List<Employee> employees) throws ResourceNotFoundException {
        List<EmployeeDTO> empstore = new ArrayList<EmployeeDTO>();
        for (Employee emp : employees) {

            // Department Check
            Optional<Department> dept = deptrepo.findById(emp.getDepartment().getId());
            if (dept.isPresent()) {
                emp.setDepartment(dept.get());
            } else {
                throw new ResourceNotFoundException("Department not found for ID : " + emp.getDepartment().getId());
            }

            // Manager Check
            if (emp.getManager() != null && emp.getManager().getId() != 0) {
                Optional<Employee> manager = emprepo.findById(emp.getManager().getId());
                if (manager.isPresent()) {
                    emp.setManager(manager.get());
                } else {
                    throw new ResourceNotFoundException("Manager not Found for ID: ");
                }
            }
            // Save Employee
            emprepo.save(emp);

            // DTO Level
            EmployeeDTO empDTO = DTOConverter.employeeConvert(emp);
            empstore.add(empDTO);
        }
        return empstore;
    }

    @Override
    public EmployeeDTO deleteEmployee(Employee employee) {

        throw new UnsupportedOperationException("Unimplemented method 'deleteEmployee'");
    }

    @Override
    public EmployeeDTO updatedomain(Employee employee) {

        throw new UnsupportedOperationException("Unimplemented method 'updatedomain'");
    }

}
