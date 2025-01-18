package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl {
    @PersistenceContext(unitName = "sqldb")
    EntityManager entityManager;
    @Transactional
    public void saveStudent(Student student) {
        entityManager.persist(student);
        System.out.println("Done");

    }
}
