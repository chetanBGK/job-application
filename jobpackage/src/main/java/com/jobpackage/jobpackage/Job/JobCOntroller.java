package com.jobpackage.jobpackage.Job;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
public class JobCOntroller {
    
    JobService  jobService;

    public JobCOntroller(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("createjob")
    public Job createJob(@RequestBody Job job) {
              
        return jobService.createJob(job);
    }

    @GetMapping("getalljobs")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("getjobbyid/{id}")
    public Job getJobById(@PathVariable int id) {
        return jobService.getJobById(id);
    }

    @PutMapping("updatejob/{id}")
    public Job updateJob(@PathVariable int id, @RequestBody Job job) {
        return jobService.updateJob(id, job);
    }
    
    @PostMapping("createalljobs")
    public List<Job> createAllJobs(@RequestBody List<Job> jobs) {
        return jobService.createAllJobs(jobs);
    }

    @DeleteMapping("deletealljob")
    public void deleteAllJobs()
    {
        jobService.deleteAllCompany();
    }
    
    @GetMapping("getbycompany/{id}")
    public List<Job> getMethodName(@PathVariable int id) {
        return jobService.findByCompanyId(id);
    }
    
}
