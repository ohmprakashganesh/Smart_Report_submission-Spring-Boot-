package com.report.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Feedback {
    @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String comments;
    
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime submittedAt;


    @OneToOne
    private AssignmentIteration assignmentIteration;

    @ManyToOne
    private User supervisor; // User with role SUPERVISOR
}
