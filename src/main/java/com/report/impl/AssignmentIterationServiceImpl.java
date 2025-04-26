package com.report.impl;

import org.springframework.stereotype.Service;

import com.report.entities.AssignmentIteration;
import com.report.repository.AssignmentIterationRepo;
import com.report.services.AssignmentIterationService;

@Service
public class AssignmentIterationServiceImpl implements AssignmentIterationService {

    private  AssignmentIterationRepo assignmentIterationRepository;

  
    public AssignmentIterationServiceImpl(AssignmentIterationRepo assignmentIterationRepository) {
        this.assignmentIterationRepository = assignmentIterationRepository;
    }


    // @Override
    // public AssignmentIteration createIteration(AssignmentIteration iteration) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'createIteration'");
    // }


    // @Override
    // public AssignmentIteration getIterationById(Long id) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getIterationById'");
    // }


    // @Override
    // public AssignmentIteration updateIteration(Long id, AssignmentIteration iteration) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'updateIteration'");
    // }


    // @Override
    // public void deleteIteration(Long id) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'deleteIteration'");
    // }

    @Override
    public AssignmentIteration createIteration(AssignmentIteration iteration) {
        return assignmentIterationRepository.save(iteration);
    }

    @Override
    public AssignmentIteration getIterationById(Long id) {
        return assignmentIterationRepository.findById(id).orElseThrow(() -> new RuntimeException("Iteration not found"));
    }

    @Override
    public AssignmentIteration updateIteration(Long id, AssignmentIteration iteration) {
        if (!assignmentIterationRepository.existsById(id)) {
            throw new RuntimeException("Iteration not found");
        }
        return assignmentIterationRepository.save(iteration);
    }


    @Override
    public void deleteIteration(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteIteration'");
    }
}
