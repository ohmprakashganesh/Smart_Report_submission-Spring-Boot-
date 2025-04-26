package com.report.services;

import com.report.entities.AssignmentIteration;

import java.util.Optional;

public interface AssignmentIterationService {
    AssignmentIteration createIteration(AssignmentIteration iteration);
   Optional< AssignmentIteration> getIterationById(Long id);
    AssignmentIteration updateIteration(Long id, AssignmentIteration iteration);
    void deleteIteration(Long id);
}
