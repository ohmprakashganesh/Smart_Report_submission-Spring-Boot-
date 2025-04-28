package com.report.controller;

import com.report.DTOs.AssignmentIterDTO;
import com.report.entities.User;
import lombok.RequiredArgsConstructor;
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

import com.report.entities.AssignmentIteration;
import com.report.services.AssignmentIterationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/itr")
public class AssignmentIterationController {
     public User user;


    private final AssignmentIterationService assignmentIterationService;

//    @Autowired
//    public AssignmentIterationController(AssignmentIterationService assignmentIterationService) {
//        this.assignmentIterationService = assignmentIterationService;
//    }

    //submitting the Assignment
    @PostMapping
    public ResponseEntity<AssignmentIteration> createIteration(@RequestBody AssignmentIterDTO iteration) {
        AssignmentIteration createdIteration = assignmentIterationService.createIteration(iteration);
        return new ResponseEntity<>(createdIteration, HttpStatus.CREATED);
    }

    //get the single assignment
    @GetMapping("/{id}")
    public ResponseEntity<AssignmentIteration> getIteration(@PathVariable Long id) {
        try {
            Optional<AssignmentIteration> iteration = assignmentIterationService.getIterationById(id);
            return new ResponseEntity<>(iteration.get(), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List< AssignmentIteration >> getIterationAll() {
        try {
            List<AssignmentIteration> iteration = assignmentIterationService.getIterationAll();
            return new ResponseEntity<>(iteration, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/byStudent")
    public ResponseEntity<List< AssignmentIteration >> getIterationByStudent() {
        try {
            List<AssignmentIteration> iteration = assignmentIterationService.getIterationByStd(user);
            return new ResponseEntity<>(iteration, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
//    getIterationByGroup
//
//    @GetMapping("/byAssignment")
//    public ResponseEntity<List< AssignmentIteration >> getIterationByAssignment() {
//        try {
//            List<AssignmentIteration> iteration = assignmentIterationService.getIterationByAssignment(user);
//            return new ResponseEntity<>(iteration, HttpStatus.OK);
//        }catch (Exception ex){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//update the Assignment iteration
    @PutMapping("/{id}")
    public ResponseEntity<AssignmentIteration> updateIteration(@PathVariable Long id, @RequestBody AssignmentIteration iteration) {
        AssignmentIteration updatedIteration = assignmentIterationService.updateIteration(id, iteration);
        return new ResponseEntity<>(updatedIteration, HttpStatus.OK);
    }

    //delete the assignment
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIteration(@PathVariable Long id) {
        assignmentIterationService.deleteIteration(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
