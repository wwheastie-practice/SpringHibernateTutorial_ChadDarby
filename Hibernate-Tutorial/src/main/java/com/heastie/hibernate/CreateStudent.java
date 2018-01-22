package com.heastie.hibernate;

import com.heastie.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {

    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {
            //Create student object
            System.out.println("Creating a new student object...");
            Student student = new Student("Paul", "Wall", "paul@luv2code.com");

            //Start the transaction
            session.beginTransaction();

            //Save the student object
            System.out.println("Saving student information...");
            session.save(student);

            //Commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }

    }

}
