package cg.directory.backend.services;

import java.util.List;

import cg.directory.backend.dto.DomainDTO;
import cg.directory.backend.entity.Domain;

public interface DomainService {

    public List<DomainDTO> getAllDomains();
    public List<DomainDTO> createDomains(List<Domain> domains);
    public Domain deleteDomain(Domain domain); 
    public Domain updatedomain(Domain domain);
}
