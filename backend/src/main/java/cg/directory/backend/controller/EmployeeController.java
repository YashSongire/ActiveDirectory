package cg.directory.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cg.directory.backend.dto.EmployeeDTO;
import cg.directory.backend.entity.Employee;
import cg.directory.backend.services.EmployeeService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:4200/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("employees")
    public ResponseEntity<List<EmployeeDTO>> createemployees(@RequestBody List<Employee> employees) {
        List<EmployeeDTO> createdemployees = employeeService.createEmployees(employees);
        return ResponseEntity.ok(createdemployees);
    }

    @GetMapping("employees")
    public ResponseEntity<List<EmployeeDTO>> getemployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
}
