package com.report.entities;
import java.util.List;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class StudentGroup {
    @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String groupName;

    @OneToMany(mappedBy = "group")
    private List<User> students; // Users with role STUDENT

    @ManyToOne
    private User supervisor; // User with role SUPERVISOR

    @OneToMany(mappedBy = "studentGroup")
    private List<Assignment> assignments;
}
