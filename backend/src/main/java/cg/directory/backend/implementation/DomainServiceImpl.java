package cg.directory.backend.implementation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cg.directory.backend.converter.DTOConverter;
import cg.directory.backend.dto.DomainDTO;
import cg.directory.backend.entity.Department;
import cg.directory.backend.entity.Domain;
import cg.directory.backend.exception.ResourceNotFoundException;
import cg.directory.backend.repository.DepartmentRepository;
import cg.directory.backend.repository.DomainRepository;
import cg.directory.backend.services.DomainService;

@Service
public class DomainServiceImpl implements DomainService{

    @Autowired
    private DomainRepository domainRepository;

    @Autowired
    private DepartmentRepository deptRepository;
    
    @Override
    public List<DomainDTO> getAllDomains() {
        List<DomainDTO> allDomain = new ArrayList<DomainDTO>();
        List<Domain> domains = domainRepository.findAll();
        for (Domain domain : domains) {
            DomainDTO dto = DTOConverter.domainConvert(domain);
            allDomain.add(dto);
    }
    return allDomain;
}

    @Override
    public List<DomainDTO> createDomains(List<Domain> domains) throws ResourceNotFoundException{
        List<DomainDTO> domaindtoList = new ArrayList<DomainDTO>();
        for(Domain domain : domains){
            if(domain.getDepartments() != null){
                Set<Department> pushDepartments = new HashSet<>();
                for(Department deptdata : domain.getDepartments()){
                    Optional<Department> department = deptRepository.findById(deptdata.getId());
                    if(department.isPresent()){
                        pushDepartments.add(department.get());
                        domain.setDepartments(pushDepartments);
                    }
                    else{
                        throw new ResourceNotFoundException("Department Not Found for ID");
                    }
                }
            }

            // Save Domain
            domainRepository.save(domain);

            // Convert DTO
            DomainDTO dto = DTOConverter.domainConvert(domain);
            domaindtoList.add(dto);
        }
        return domaindtoList;
    }

    @Override
    public Domain deleteDomain(Domain domain) {
        throw new UnsupportedOperationException("Unimplemented method 'updatedomain'");
    }

    @Override
    public Domain updatedomain(Domain domain) {
        throw new UnsupportedOperationException("Unimplemented method 'updatedomain'");
    }

}
