package org.example;

import org.example.dao.StudentDAO;
import org.example.dao.StudentDAOImpl;
import org.example.entity.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan
public class App 
{
    public static void main( String[] args )
    {

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(App.class);

        StudentDAOImpl studentDAOimpl=context.getBean("studentDAOImpl",StudentDAOImpl.class);

        Student sonu=new Student();
        sonu.setName("riva");
        studentDAOimpl.saveStudent(sonu);
    }
}
