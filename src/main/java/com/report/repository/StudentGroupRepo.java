package com.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.report.entities.StudentGroup;

public interface StudentGroupRepo extends  JpaRepository<StudentGroup, Long> {
    
}
