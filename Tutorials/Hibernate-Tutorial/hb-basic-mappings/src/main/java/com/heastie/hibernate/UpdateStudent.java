package com.heastie.hibernate;

import com.heastie.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {

    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 3;

            //Start the transaction
            session.beginTransaction();

            //Commit transaction
            session.getTransaction().commit();

            //Get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Retrieve student based on the id
            System.out.println("Getting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Updating student...");
            myStudent.setEmail("john@luv2code.com");

            //Commit the transaction
            session.getTransaction().commit();

            //Updating all students
            //Get new session
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//
//            System.out.println("Update email for all students");
//
//            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
//
//            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }

    }

}
