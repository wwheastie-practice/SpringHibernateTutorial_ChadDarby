package com.heastie.hibernate;

import com.heastie.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudent {

    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {
            //Start the transaction
            session.beginTransaction();

            //Query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            //Display students
            displayStudents(theStudents);

            //Query students with lastName = 'Doe'
            theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();

            //Display students with lastName = 'Doe'
            System.out.println("\n\nStudents who have last name Doe");
            displayStudents(theStudents);

            //Query students with the email @luv2code.com
            theStudents = session.createQuery("from Student s where s.email like '%luv2code.com'").getResultList();

            //Display students with the email @luv2code.com
            System.out.println("\n\nStudents who have the email luv2code");
            displayStudents(theStudents);

            //Query students: lastName='Doe' OR firstName='Daffy'
            theStudents = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
            System.out.println("\n\nStudents who have the lastName='Doe' OR firstName='Daffy'");
            displayStudents(theStudents);

            //Commit transaction
            session.getTransaction().commit();

            System.out.println("\n\nDone!");
        } finally {
            factory.close();
        }

    }

    private static void displayStudents(List<Student> theStudents) {
        for(Student student: theStudents) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
    }

}
