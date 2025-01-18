package com.epam.ashish.springboot_h2;

import com.epam.ashish.springboot_h2.entity.Student;
import com.epam.ashish.springboot_h2.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class StudentTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void test_saveStudents(){

        Student student= new Student("ashish");
      Student stud=  this.studentRepository.save(student);

        System.out.println(stud.getId());

    }


}
