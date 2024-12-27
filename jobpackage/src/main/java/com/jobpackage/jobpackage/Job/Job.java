package com.jobpackage.jobpackage.Job;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jobpackage.jobpackage.Company.Company;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String description;
    private String  minsalary;
    private String maxsalary;
    private String location;

    @ManyToOne ()
    // @JsonBackReference

    private Company company;
}
