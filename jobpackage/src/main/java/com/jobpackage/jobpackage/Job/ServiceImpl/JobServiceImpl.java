package com.jobpackage.jobpackage.Job.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobpackage.jobpackage.Job.Job;
import com.jobpackage.jobpackage.Job.JobRepo;
import com.jobpackage.jobpackage.Job.JobService;

@Service
public class JobServiceImpl implements JobService {

    JobRepo jobRepo;

    public JobServiceImpl(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    @Override
    public Job createJob(Job job) {
        return jobRepo.save(job);
    }

    @Override
    public Job getJobById(int id) {
        return jobRepo.findById(id).get();
    }

    @Override
    public Job updateJob(int id, Job job) {
        Job job1 = new Job();
        job1 = jobRepo.findById(id).get();
        job1.setTitle(job.getTitle());
        job1.setDescription(job.getDescription());
        job1.setMinsalary(job.getMinsalary());
        job1.setMaxsalary(job.getMaxsalary());
        job1.setLocation(job.getLocation());
        return jobRepo.save(job1);
    }

    @Override
    public void deleteJob(int id) {
        jobRepo.deleteById(id);
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepo.findAll();
    }

    public List<Job> createAllJobs(List<Job> jobs) {
        return jobRepo.saveAll(jobs);
    }

    public void deleteAllCompany()
    {
        jobRepo.deleteAll();
    }

    @Override
    public List<Job> findByCompanyId(int companyId) {
        return jobRepo.findByCompanyId(companyId);
    }


    
    
}