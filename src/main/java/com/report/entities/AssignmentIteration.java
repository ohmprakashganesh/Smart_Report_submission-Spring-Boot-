package com.report.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;


@Entity
@Data
public class AssignmentIteration {
    @Id 
        @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id;

    @Enumerated(EnumType.STRING)
    private IterationType iterationType;

    private String documentUrl;

    @ManyToOne
    private Assignment assignment;

    @Enumerated(EnumType.STRING)
    private SubmissionStatus status = SubmissionStatus.SUBMITTED;


    @ManyToOne
    private User submittedBy; // User with role STUDENT

    @OneToOne(mappedBy="assignmentIteration", cascade = CascadeType.ALL)
    private Feedback feedback;
}
