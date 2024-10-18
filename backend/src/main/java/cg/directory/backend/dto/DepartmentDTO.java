package cg.directory.backend.dto;

import lombok.Data;

@Data
public class DepartmentDTO {
    private long id;
    private String name;
    private DomainDTO domain;

}
