package com.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.report.entities.AssignmentIteration;

public interface AssignmentIterationRepo extends  JpaRepository<AssignmentIteration, Long> {
    
}
