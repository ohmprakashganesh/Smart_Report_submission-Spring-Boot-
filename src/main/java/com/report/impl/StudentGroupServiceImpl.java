package com.report.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.report.entities.StudentGroup;
import com.report.repository.StudentGroupRepo;
import com.report.services.StudentGroupService;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {

    private final StudentGroupRepo studentGroupRepository;


    public StudentGroupServiceImpl(StudentGroupRepo studentGroupRepository) {
        this.studentGroupRepository = studentGroupRepository;
    }


    // @Override
    // public StudentGroup createGroup(StudentGroup group) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'createGroup'");
    // }


    // @Override
    // public StudentGroup getGroupById(Long id) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getGroupById'");
    // }


    // @Override
    // public StudentGroup updateGroup(Long id, StudentGroup group) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'updateGroup'");
    // }


    // @Override
    // public void deleteGroup(Long id) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'deleteGroup'");
    // }

    @Override
    public StudentGroup createGroup(StudentGroup group) {
        return studentGroupRepository.save(group);
    }

    @Override
    public StudentGroup getGroupById(Long id) {
        return studentGroupRepository.findById(id).orElseThrow(() -> new RuntimeException("Group not found"));
    }

    @Override
    public StudentGroup updateGroup(Long id, StudentGroup group) {
        if (!studentGroupRepository.existsById(id)) {
            throw new RuntimeException("Group not found");
        }
        return studentGroupRepository.save(group);
    }

    @Override
    public void deleteGroup(Long id) {
        studentGroupRepository.deleteById(id);
    }

    @Override
    public List<StudentGroup> allGroups() {
      return  studentGroupRepository.findAll();
        
    }

    


   

 
}
