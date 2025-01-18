package com.epam.ashish.springboot_h2.repository;

import com.epam.ashish.springboot_h2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
