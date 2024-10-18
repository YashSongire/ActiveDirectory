package cg.directory.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cg.directory.backend.dto.DomainDTO;
import cg.directory.backend.entity.Domain;
import cg.directory.backend.services.DomainService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:4200/")
public class DomainController {

    @Autowired
    private DomainService domainService;

    @PostMapping("domain")
    public List<DomainDTO> createDomain(@RequestBody List<Domain> domain) {
        return domainService.createDomains(domain);    
    }

    @GetMapping("domain")
    public List<DomainDTO> getDomains() {
        return domainService.getAllDomains();
    }
}
