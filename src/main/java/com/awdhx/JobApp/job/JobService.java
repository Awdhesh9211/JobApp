package com.awdhx.JobApp.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    Job getJobById(Long id);
    void deleteJobById(Long Id);
    boolean updateJobByid(Long Id,Job updatedJob);
}
