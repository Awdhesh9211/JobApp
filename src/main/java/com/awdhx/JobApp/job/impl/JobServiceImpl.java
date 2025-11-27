package com.awdhx.JobApp.job.impl;

import com.awdhx.JobApp.job.Job;
import com.awdhx.JobApp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs=new ArrayList<>();
    private Long nextId=1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for(Job job:jobs){
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public void deleteJobById(Long Id) {
        jobs.removeIf(job -> job.getId().equals(Id));
    }

    @Override
    public boolean updateJobByid(Long Id,Job updatedJob) {
        for(Job job: jobs){
            if(job.getId().equals(Id)){
                if(updatedJob.getTitle()!=null) job.setTitle(updatedJob.getTitle());
                if(updatedJob.getDescription()!=null) job.setDescription(updatedJob.getDescription());
                if(updatedJob.getMinSalary()!=null) job.setMinSalary(updatedJob.getMinSalary());
                if(updatedJob.getMaxSalary()!=null) job.setMaxSalary(updatedJob.getMaxSalary());
                if(updatedJob.getLocation()!=null) job.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;
    }


}
