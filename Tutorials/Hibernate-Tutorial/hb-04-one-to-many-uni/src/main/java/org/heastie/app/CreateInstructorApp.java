package org.heastie.app;

import org.heastie.entity.Course;
import org.heastie.entity.Instructor;
import org.heastie.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorApp {
    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory = new Configuration()
                                .configure()
                                .addAnnotatedClass(Instructor.class)
                                .addAnnotatedClass(InstructorDetail.class)
                                .addAnnotatedClass(Course.class)
                                .buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {
            //Create objects
            Instructor instructor = new Instructor("Susan", "Public", "susan.public@luv2code.com");
            InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "Video Games");

            //Associate objects
            instructor.setInstructorDetail(instructorDetail);

            //Start transaction
            session.beginTransaction();

            //Save instructor
            session.save(instructor);

            //Commit transaction
            session.getTransaction().commit();


        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
