package org.heastie.app;

import org.heastie.entity.Instructor;
import org.heastie.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyApp {
    public static void main(String[] args) {

        //Create session factory
        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {
            //Create objects
            Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
            InstructorDetail detail = new InstructorDetail("http://www.youtube.com", "Luv 2 Code!!!!");

            //Associate objects
            instructor.setInstructorDetail(detail);

            //Start transaction
            session.beginTransaction();

            //Save the instructor
            System.out.println("Saving instructor: " + instructor);
            session.save(instructor);

            //Commit transaction
            session.getTransaction().commit();

            //Done
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }
}
