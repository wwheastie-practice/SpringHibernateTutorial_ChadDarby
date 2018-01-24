package com.heastie.hibernate;

import com.heastie.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {

    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {
            //Create student object
            System.out.println("Creating a new student object...");
            Student student = new Student("Daffy", "Duck", "daffy@luv2code.com");

            //Start the transaction
            session.beginTransaction();

            //Save the student object
            System.out.println("Saving student information...");
            session.save(student);

            //Commit transaction
            session.getTransaction().commit();

            //-----------------------------------

            //Find out student's id (primary key)
            System.out.println("Saved Student's id: " + student.getId());

            //Get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //Retrieve student based on the id
            System.out.println("\nGetting student with id: " + student.getId());
            Student myStudent = session.get(Student.class, student.getId());

            System.out.println("Get complete!: " + myStudent);
            //System.out.println(myStudent.getFirstName() + " " + myStudent.getLastName());

            //Commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }

    }

}
