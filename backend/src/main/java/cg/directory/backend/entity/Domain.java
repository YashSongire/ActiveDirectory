package cg.directory.backend.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "domain")
public class Domain {

    @Id
    @SequenceGenerator(name = "department_sequence", sequenceName = "department_sequence", initialValue = 10080)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_sequence")
    private long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "domain", cascade = CascadeType.ALL)
    private Set<Department> departments;

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

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Domain() {
    }

    public Domain(String name, Set<Department> departments) {
        this.name = name;
        this.departments = departments;
    }

}
