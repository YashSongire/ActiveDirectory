package cg.directory.backend.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cg.directory.backend.converter.DTOConverter;
import cg.directory.backend.dto.DepartmentDTO;
import cg.directory.backend.entity.Department;
import cg.directory.backend.entity.Domain;
import cg.directory.backend.exception.ResourceNotFoundException;
import cg.directory.backend.repository.DepartmentRepository;
import cg.directory.backend.repository.DomainRepository;
import cg.directory.backend.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository deptrepo;

    @Autowired
    private DomainRepository domainrepo;

    @Override
    public List<DepartmentDTO> getAllDepartments() {
       List<DepartmentDTO> deptdata = new ArrayList<DepartmentDTO>();
       List<Department> departments = deptrepo.findAll();
       for(Department dept : departments){
        DepartmentDTO dto = DTOConverter.departmentConvert(dept);
        deptdata.add(dto);
       } 
       return deptdata;
    }

    @Override
    public List<DepartmentDTO> createDepartments(List<Department> departments) throws ResourceNotFoundException {
        List<DepartmentDTO> deptdata = new ArrayList<DepartmentDTO>();
        for(Department department : departments){

            // Domain Check
            Optional<Domain> domain = domainrepo.findById(department.getDomain().getId());
            if(domain.isPresent()){
                department.setDomain(domain.get());
                deptrepo.save(department);
            }
            else{
                throw new ResourceNotFoundException("Domain not found");
            }
            DepartmentDTO dept = DTOConverter.departmentConvert(department);
            deptdata.add(dept);
        }
        return deptdata;
    }

    @Override
    public DepartmentDTO deleteDepartment(Department department) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteDepartment'");
    }

    @Override
    public DepartmentDTO updatedomain(Department department) {

        throw new UnsupportedOperationException("Unimplemented method 'updatedomain'");
    }

}
