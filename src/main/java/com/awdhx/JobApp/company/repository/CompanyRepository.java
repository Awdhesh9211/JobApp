package com.awdhx.JobApp.company.repository;

import com.awdhx.JobApp.company.entity.Company;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
