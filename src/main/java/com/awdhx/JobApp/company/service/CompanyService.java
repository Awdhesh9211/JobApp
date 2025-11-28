package com.awdhx.JobApp.company.service;

import com.awdhx.JobApp.company.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();
    boolean updateCompany(Company company,Long id);
    void createCompany(Company company);

    Company getCompanyById(Long id);

    boolean deleteCompanyById(Long Id);
}
