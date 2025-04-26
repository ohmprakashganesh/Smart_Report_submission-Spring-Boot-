package com.report.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.report.DTOs.StrudentGroupDTO;
import com.report.entities.User;
import com.report.mapping.MappingCls;
import com.report.repository.UserRepo;
import org.springframework.stereotype.Service;

import com.report.entities.StudentGroup;
import com.report.repository.StudentGroupRepo;
import com.report.services.StudentGroupService;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {

    private final StudentGroupRepo studentGroupRepository;
    private  final MappingCls mapper;
    private  final UserRepo userRepo;

    public StudentGroupServiceImpl(UserRepo userRepo, StudentGroupRepo studentGroupRepository, MappingCls mapper) {
        this.studentGroupRepository = studentGroupRepository;
        this.mapper=mapper;
        this.userRepo=userRepo;
    }

    @Override
    public StrudentGroupDTO createGroup(StrudentGroupDTO dto) {
        //fetch and set std
        List<User> students=new ArrayList<>();
        List<Long> stds=dto.getStdIds();
        for(Long id: stds){
            Optional<User> opt= userRepo.findById(id);
            if(opt.isPresent()){
                students.add(opt.get());
            }
        }
        User supervisor=null;
        //fetch and set supervisor
        Optional<User> opt= userRepo.findById(dto.getSupervisorId());
        if(opt.isPresent()){
            supervisor=opt.get();
        }

         StudentGroup std= mapper.dtoToStudentGroup(dto);
        std.setStudents(students);
        std.setSupervisor(supervisor);

       StudentGroup createdGroup = studentGroupRepository.save(std);
     StrudentGroupDTO obj= mapper.studentGroupToDTO(createdGroup);
        return obj;
    }

    @Override
    public StudentGroup getGroupById(Long id) {
        return studentGroupRepository.findById(id).orElseThrow(() -> new RuntimeException("Group not found"));
    }

    @Override
    public StudentGroup updateGroup(Long id, StudentGroup group) {
        StudentGroup gru= studentGroupRepository.findById(id).orElseThrow(()-> new RuntimeException("not found with id "+id) );
        gru.setGroupName(group.getGroupName());
        gru.setStudents(group.getStudents());
        gru.setAssignments(group.getAssignments());
        gru.setSupervisor(group.getSupervisor());
        return studentGroupRepository.save(gru);
    }

    @Override
    public void deleteGroup(Long id) {
        studentGroupRepository.deleteById(id);
        System.out.println("deleted successfully ");

    }

    @Override
    public List<StudentGroup> allGroups() {
      return  studentGroupRepository.findAll();
        
    }

    


   

 
}
