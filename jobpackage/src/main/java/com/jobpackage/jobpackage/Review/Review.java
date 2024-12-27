package com.jobpackage.jobpackage.Review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jobpackage.jobpackage.Company.Company;

import jakarta.annotation.Generated;
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
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String description;
    private int rating;

    @ManyToOne
    @JsonIgnore
    private Company company;
}
