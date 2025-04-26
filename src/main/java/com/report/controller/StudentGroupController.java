package com.report.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.report.entities.StudentGroup;
import com.report.services.StudentGroupService;

@RestController
@RequestMapping("/api/groups")
public class StudentGroupController {

    private final StudentGroupService studentGroupService;

    @Autowired
    public StudentGroupController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    @PostMapping
    public ResponseEntity<StudentGroup> createGroup(@RequestBody StudentGroup group) {
        StudentGroup createdGroup = studentGroupService.createGroup(group);
        return new ResponseEntity<>(createdGroup, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentGroup> getGroup(@PathVariable Long id) {
        StudentGroup group = studentGroupService.getGroupById(id);
        return new ResponseEntity<>(group, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List< StudentGroup>> getAll() {
        List<StudentGroup> group = studentGroupService.allGroups();
        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentGroup> updateGroup(@PathVariable Long id, @RequestBody StudentGroup group) {
        StudentGroup updatedGroup = studentGroupService.updateGroup(id, group);
        return new ResponseEntity<>(updatedGroup, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
        studentGroupService.deleteGroup(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
