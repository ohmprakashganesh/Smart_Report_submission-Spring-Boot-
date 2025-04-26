package com.report.impl;

import org.springframework.stereotype.Service;

import com.report.entities.Assignment;
import com.report.repository.AssignmentRepo;
import com.report.services.AssignmentService;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepo assignmentRepository;

  
    public AssignmentServiceImpl(AssignmentRepo assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }


    // @Override
    // public Assignment createAssignment(Assignment assignment) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'createAssignment'");
    // }


    // @Override
    // public Assignment getAssignmentById(Long id) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getAssignmentById'");
    // }


    // @Override
    // public Assignment updateAssignment(Long id, Assignment assignment) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'updateAssignment'");
    // }


    // @Override
    // public void deleteAssignment(Long id) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'deleteAssignment'");
    // }

    @Override
    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public Assignment getAssignmentById(Long id) {
        return assignmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Assignment not found"));
    }

    @Override
    public Assignment updateAssignment(Long id, Assignment assignment) {
        if (!assignmentRepository.existsById(id)) {
            throw new RuntimeException("Assignment not found");
        }
        return assignmentRepository.save(assignment);
    }

    @Override
    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }
}
