package com.awdhx.JobApp.job;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

//    API
    @GetMapping("/jobs")
    public List<Job>  findAll(){
        return jobService.findAll();
    }

    @PostMapping("/jobs")
    public String createJobs(@RequestBody Job job){
        jobService.createJob(job);
        return "Job added successfully";
    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id){
        Job job=jobService.getJobById(id);
        if(job != null)
            return job;

        return new Job(1L,"not","not","not","not","not");
    }



}
