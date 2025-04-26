package com.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.report.entities.User;

@Repository
public interface UserRepo extends  JpaRepository<User, Long> {
    
}
