package org.heastie.app;

import org.heastie.entity.Course;
import org.heastie.entity.Instructor;
import org.heastie.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseApp {
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
            //Start transaction
            session.beginTransaction();

            //Get course from database
            Course course = session.get(Course.class, 11);

            //Delete course
            session.delete(course);

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
