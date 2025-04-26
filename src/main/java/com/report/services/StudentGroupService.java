package com.report.services;

import java.util.List;

import com.report.entities.StudentGroup;

public interface StudentGroupService {
    StudentGroup createGroup(StudentGroup group);
    StudentGroup getGroupById(Long id);
    List<StudentGroup> allGroups();
    StudentGroup updateGroup(Long id, StudentGroup group);
    void deleteGroup(Long id);
}
