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

import cg.directory.backend.dto.DepartmentDTO;
import cg.directory.backend.entity.Department;
import cg.directory.backend.services.DepartmentService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:4200/")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("departments")
    public ResponseEntity<List<DepartmentDTO>> createDepartments(@RequestBody List<Department> departments) {
        List<DepartmentDTO> createdDepartments = departmentService.createDepartments(departments);
        return ResponseEntity.ok(createdDepartments);
    }

    @GetMapping("departments")
    public ResponseEntity<List<DepartmentDTO>> getDepartments() {
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }
}
