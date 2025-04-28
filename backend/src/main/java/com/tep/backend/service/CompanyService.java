package com.tep.backend.service;

import com.tep.backend.model.dto.CompanyDTO;
import com.tep.backend.model.dto.CompanyMinDTO;
import com.tep.backend.model.dto.CompanyPublicDTO;
import com.tep.backend.model.entity.Company;
import com.tep.backend.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    @Transactional(readOnly = true)
    public CompanyPublicDTO findPublicById(Long id) {
        Company entity = repository.findById(id).get();
        return toPublicDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<CompanyMinDTO> findAllMin() {
        List<Company> entities = repository.findAll();
        return entities.stream().map(this::toMinDTO).toList();
    }

    @Transactional(readOnly = true)
    public CompanyDTO findById(Long id) {
        Company entity = repository.findById(id).get();
        return toDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<CompanyDTO> findAll() {
        List<Company> entities = repository.findAll();
        return entities.stream().map(this::toDTO).toList();
    }

    @Transactional
    public CompanyDTO insert(CompanyDTO dto) {
        Company entity = toEntity(dto);
        entity = repository.save(entity);
        return toDTO(entity);
    }

    @Transactional
    public CompanyDTO update(Long id, CompanyDTO dto) {
        Company entity = repository.findById(id).get();

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setSector(dto.getSector());
        entity.setLogoUrl(dto.getLogoUrl());
        entity.setWebsite(dto.getWebsite());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setCnpj(dto.getCnpj());
        entity.setStatus(dto.getStatus());
        entity.setRegisteredAt(dto.getRegisteredAt());

        entity = repository.save(entity);
        return toDTO(entity);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private CompanyDTO toDTO(Company entity) {
        return new CompanyDTO(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getSector(),
                entity.getLogoUrl(),
                entity.getWebsite(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getCnpj(),
                entity.getStatus(),
                entity.getRegisteredAt()
        );
    }

    private CompanyPublicDTO toPublicDTO(Company entity) {
        return new CompanyPublicDTO(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getSector(),
                entity.getLogoUrl(),
                entity.getWebsite()
        );
    }

    private CompanyMinDTO toMinDTO(Company entity) {
        return new CompanyMinDTO(
                entity.getId(),
                entity.getName(),
                entity.getSector(),
                entity.getLogoUrl()
        );
    }

    private Company toEntity(CompanyDTO dto) {
        return new Company(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getSector(),
                dto.getLogoUrl(),
                dto.getWebsite(),
                dto.getEmail(),
                dto.getPhone(),
                dto.getCnpj(),
                dto.getStatus(),
                dto.getRegisteredAt()
        );
    }
}
