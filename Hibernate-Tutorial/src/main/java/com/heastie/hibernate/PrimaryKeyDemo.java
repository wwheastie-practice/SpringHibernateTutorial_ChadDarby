package com.heastie.hibernate;

import com.heastie.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {
            //Create 3 student objects
            System.out.println("Creating a new student object...");
            Student student1 = new Student("John", "Doe", "john@luv2code.com");
            Student student2 = new Student("Mary", "Public", "mary@luv2code.com");
            Student student3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

            //Start the transaction
            session.beginTransaction();

            //Save the student object
            System.out.println("Saving student information...");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            //Commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

}
