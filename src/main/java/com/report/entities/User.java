package com.report.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Entity
@Data
public class User {

    @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;

     @Enumerated (EnumType.STRING)
    private Role role;

    // Student-only relation
    @ManyToOne
    private StudentGroup group;

    // Supervisor-only relation
    @OneToMany(mappedBy = "supervisor")
    private List<StudentGroup> supervisedGroups;

    public List<StudentGroup> getSupervisedGroups() {
        return supervisedGroups;
    }

    public void setSupervisedGroups(List<StudentGroup> supervisedGroups) {
        this.supervisedGroups = supervisedGroups;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public StudentGroup getGroup() {
//        return group;
//    }
//
//    public void setGroup(StudentGroup group) {
//        this.group = group;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
}
