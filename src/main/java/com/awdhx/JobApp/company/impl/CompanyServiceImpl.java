package com.awdhx.JobApp.company.impl;

import com.awdhx.JobApp.company.entity.Company;
import com.awdhx.JobApp.company.repository.CompanyRepository;
import com.awdhx.JobApp.company.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
       return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company,Long id) {
        Optional<Company> companyOptional=companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company companyToUpdate=companyOptional.get();
            if(company.getName()!= null) companyToUpdate.setName(company.getName());
            if(company.getDescription()!= null) companyToUpdate.setDescription(company.getDescription());
            if(company.getJobs()!= null) companyToUpdate.setJobs(company.getJobs());
            companyRepository.save(companyToUpdate);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompanyById(Long Id) {
        try{
            companyRepository.deleteById(Id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
