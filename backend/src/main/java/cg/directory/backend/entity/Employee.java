package cg.directory.backend.entity;

import cg.directory.backend.enums.EmployeeStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @SequenceGenerator(name = "emp_sequence", sequenceName = "emp_seq", initialValue = 5301000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_sequence")
    private long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String designation;

    @Column
    private String country;

    @Column
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;
    
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = true)
    private Employee manager;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Employee(String name, String address, String designation, String country, String email,
            EmployeeStatus status, Department department, Employee manager) {
        this.name = name;
        this.address = address;
        this.designation = designation;
        this.country = country;
        this.email = email;
        this.status = status;
        this.department = department;
        this.manager = manager;
    }

    public Employee() {
    }
}
