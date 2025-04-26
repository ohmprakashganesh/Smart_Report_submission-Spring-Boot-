package com.report.services;

import com.report.entities.Assignment;

import java.util.List;

public interface AssignmentService {
    Assignment createAssignment(Assignment assignment);
    Assignment getAssignmentById(Long id);
      List<Assignment> getAllAssignment();
    Assignment updateAssignment(Long id, Assignment assignment);
    void deleteAssignment(Long id);
}
