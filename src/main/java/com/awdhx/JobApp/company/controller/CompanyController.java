package com.awdhx.JobApp.company.controller;

import com.awdhx.JobApp.company.entity.Company;
import com.awdhx.JobApp.company.service.CompanyService;
import com.awdhx.JobApp.job.entity.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("")
    public ResponseEntity<List<Company>> getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @PostMapping("")
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company Created Sucess", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company=companyService.getCompanyById(id);
        if(company != null)
            return new ResponseEntity<>(company, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyByid(@PathVariable Long id){
        if(companyService.deleteCompanyById(id))
            return new ResponseEntity<>("deleted successfully!",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id,@RequestBody Company company){
        boolean updated=companyService.updateCompany(company,id);

        if(updated)
            return new ResponseEntity<>("Job Updated Successfully !",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }




}
