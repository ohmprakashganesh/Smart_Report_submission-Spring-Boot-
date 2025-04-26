package com.report.entities;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Assignment {
    @Id 
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    // private String title;
    private String description;

    @ManyToOne
    @JsonIgnore
    private StudentGroup studentGroup;

    @OneToMany(mappedBy="assignment", cascade=CascadeType.ALL)
    private List<AssignmentIteration> iterations;
}
