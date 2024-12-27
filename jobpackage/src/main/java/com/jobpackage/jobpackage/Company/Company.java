package com.jobpackage.jobpackage.Company;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jobpackage.jobpackage.Job.Job;
import com.jobpackage.jobpackage.Review.Review;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

    @OneToMany(cascade = jakarta.persistence.CascadeType.ALL,
    mappedBy = "company",fetch = jakarta.persistence.FetchType.EAGER)
    @JsonIgnore
    private List<Job> jobs;


    @OneToMany(mappedBy = "company")
    private List<Review> reviews;
}
