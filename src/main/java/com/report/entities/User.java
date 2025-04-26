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
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
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
}
