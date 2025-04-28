package com.report.entities;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
    @Id 
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    // private String title;
    private String description;

    private String title;

    @ManyToOne
    @JsonBackReference(value = "supervisor-assignment")
    private StudentGroup studentGroup;


    @OneToMany(mappedBy="assignment", cascade=CascadeType.ALL)
    private List<AssignmentIteration> iterations;
}
