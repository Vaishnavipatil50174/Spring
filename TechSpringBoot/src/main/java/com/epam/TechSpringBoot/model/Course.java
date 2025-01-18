package com.epam.TechSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "c_Name")
    String c_Name;
    @ManyToMany(mappedBy = "courses")  // Inverse side

    @JsonIgnore
    private List<User> user;
}
