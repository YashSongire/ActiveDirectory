package cg.directory.backend.dto;

import cg.directory.backend.enums.EmployeeStatus;
import lombok.Data;

@Data
public class EmployeeDTO {

    private long id;
    private String name;
    private String address;
    private String designation;
    private String country;
    private String email;
    private EmployeeStatus status;
    private DepartmentDTO department;
    private ManagerDTO manager;

    
}
