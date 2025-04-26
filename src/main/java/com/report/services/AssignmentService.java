package com.report.services;

import com.report.entities.Assignment;

public interface AssignmentService {
    Assignment createAssignment(Assignment assignment);
    Assignment getAssignmentById(Long id);
    Assignment updateAssignment(Long id, Assignment assignment);
    void deleteAssignment(Long id);
}
