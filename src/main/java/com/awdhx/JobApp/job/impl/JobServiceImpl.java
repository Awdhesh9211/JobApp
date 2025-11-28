package com.awdhx.JobApp.job.impl;

import com.awdhx.JobApp.job.entity.Job;
import com.awdhx.JobApp.job.repository.JobRepository;
import com.awdhx.JobApp.job.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long Id) {
        try{
            jobRepository.deleteById(Id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJobByid(Long Id, Job updatedJob) {

        Optional<Job> jobOptional=jobRepository.findById(Id);
        if(jobOptional.isPresent()){
            Job job=jobOptional.get();
            if(updatedJob.getTitle()!= null) job.setTitle(updatedJob.getTitle());
            if(updatedJob.getDescription()!= null) job.setDescription(updatedJob.getDescription());
            if(updatedJob.getMinSalary()!= null) job.setMinSalary(updatedJob.getMinSalary());
            if(updatedJob.getMaxSalary()!= null) job.setMaxSalary(updatedJob.getMaxSalary());
            if(updatedJob.getLocation()!= null) job.setLocation(updatedJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
