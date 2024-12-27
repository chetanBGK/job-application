package com.jobpackage.jobpackage.Job;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<Job,Integer>{
    List<Job> findByCompanyId(int companyId);

}
