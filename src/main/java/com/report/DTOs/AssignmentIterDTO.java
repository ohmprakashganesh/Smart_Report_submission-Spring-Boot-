package com.report.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.report.entities.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentIterDTO {





    private Long id;
    private IterationType iterationType;
    private String documentUrl;
    private SubmissionStatus status;
    private Long submittedBy; // ID of the user
    private Long assignmentId;

//    private Long id;
//
//
//    @Enumerated(EnumType.STRING)
//    private IterationType iterationType;
//
//    private String documentUrl;
//
//
//    private Long assignmentId;
//
//
//    private SubmissionStatus status = SubmissionStatus.SUBMITTED;
//
//
//
//    private Long studentSubmitId; // User with role STUDENT
//
//    private Long feedbackId;
}


