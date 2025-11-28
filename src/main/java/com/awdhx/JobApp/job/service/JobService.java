package com.awdhx.JobApp.job.service;

import com.awdhx.JobApp.job.entity.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job getJobById(Long id);
    boolean deleteJobById(Long Id);
    boolean updateJobByid(Long Id,Job updatedJob);
}
