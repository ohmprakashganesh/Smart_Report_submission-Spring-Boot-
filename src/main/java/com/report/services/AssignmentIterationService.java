package com.report.services;

import com.report.entities.AssignmentIteration;

public interface AssignmentIterationService {
    AssignmentIteration createIteration(AssignmentIteration iteration);
    AssignmentIteration getIterationById(Long id);
    AssignmentIteration updateIteration(Long id, AssignmentIteration iteration);
    void deleteIteration(Long id);
}
