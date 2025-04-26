package com.report.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.report.entities.AssignmentIteration;
import com.report.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDTO {

    private Long id;

    private String comments;


    private LocalDateTime submittedAt;


    private Long assignmentIterationId;


    private Long supervisorId; // User with role SUPERVISOR
}
